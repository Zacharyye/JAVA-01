package com.zachary.netty.outbound.httpclient;

import com.zachary.netty.filter.HeaderHttpResponseFilter;
import com.zachary.netty.filter.HttpRequestFilter;
import com.zachary.netty.filter.HttpResonseFilter;
import com.zachary.netty.router.HttpEndpointRouter;
import com.zachary.netty.router.RandomHttpEndpointRouter;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import lombok.Data;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.List;
import java.util.concurrent.*;
import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

@Data
public class HttpOutboundHandler {
  private static CloseableHttpAsyncClient httpAsyncClient;
  private static ExecutorService proxyService;
  private List<String> backendUrls;
  public static final HttpOutboundHandler instance = new HttpOutboundHandler();

  HttpResonseFilter filter = new HeaderHttpResponseFilter();
  HttpEndpointRouter router = new RandomHttpEndpointRouter();

  private HttpOutboundHandler() {}

//  public HttpOutboundHandler(List<String> backends) {
//    this.backendUrls = backends.stream().map(this::formatUrl).collect(Collectors.toList());
//
//    int cores = Runtime.getRuntime().availableProcessors();
//    long keepAliveTime = 1000;
//    int queueSize = 2048;
//    RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
//    proxyService = new ThreadPoolExecutor(cores, cores,
//            keepAliveTime, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(queueSize),
//            new NamedThreadFactory("proxyService"), handler);
//    System.out.println("proxyService --- " + proxyService);
//
//    IOReactorConfig iOConfig = IOReactorConfig.custom()
//            .setConnectTimeout(5000)
//            .setSoTimeout(5000)
//            .setIoThreadCount(cores)
//            .setRcvBufSize(32 * 1024)
//            .build();
//
//    httpAsyncClient = HttpAsyncClients.custom().setMaxConnTotal(40)
//            .setMaxConnPerRoute(8)
//            .setDefaultIOReactorConfig(iOConfig)
//            .setKeepAliveStrategy((response, context) -> 6000)
//            .build();
//    httpAsyncClient.start();
//  }

   static {
//    this.backendUrls = backends.stream().map(this::formatUrl).collect(Collectors.toList());

    int cores = Runtime.getRuntime().availableProcessors();
    long keepAliveTime = 1000;
    int queueSize = 2048;
    RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
    proxyService = new ThreadPoolExecutor(cores, cores,
            keepAliveTime, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(queueSize),
            new NamedThreadFactory("proxyService"), handler);
    System.out.println("proxyService --- " + proxyService);

    IOReactorConfig iOConfig = IOReactorConfig.custom()
            .setConnectTimeout(5000)
            .setSoTimeout(5000)
            .setIoThreadCount(cores)
            .setRcvBufSize(32 * 1024)
            .build();

    httpAsyncClient = HttpAsyncClients.custom().setMaxConnTotal(40)
            .setMaxConnPerRoute(8)
            .setDefaultIOReactorConfig(iOConfig)
            .setKeepAliveStrategy((response, context) -> 6000)
            .build();
    httpAsyncClient.start();
  }

  public static String formatUrl(String backend) {
    return backend.endsWith("/") ? backend.substring(0, backend.length() - 1) : backend;
  }

  public void handle(final FullHttpRequest fullHttpRequest, final ChannelHandlerContext ctx, HttpRequestFilter filter) {
    String backendUrl = router.route(this.backendUrls);
    final String url = backendUrl + fullHttpRequest.uri();
    filter.filter(fullHttpRequest, ctx);
    proxyService.submit(() -> fetchGet(fullHttpRequest, ctx, url));
  }

  private void fetchGet(final FullHttpRequest inbound, final ChannelHandlerContext ctx, final String url) {
    final HttpGet httpGet = new HttpGet(url);
    httpGet.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
    httpGet.setHeader("mao", inbound.headers().get("mao"));

    httpAsyncClient.execute(httpGet, new FutureCallback<HttpResponse>() {
      @Override
      public void completed(HttpResponse httpResponse) {
        try {
          handleResponse(inbound, ctx, httpResponse);
        } catch (Exception e) {
          e.printStackTrace();
        } finally {

        }
      }

      @Override
      public void failed(Exception e) {
        httpGet.abort();
        e.printStackTrace();
      }

      @Override
      public void cancelled() {
        httpGet.abort();
      }
    });
  }

  private void handleResponse(final FullHttpRequest fullHttpRequest, final ChannelHandlerContext ctx, final HttpResponse endpointResponse) {
    FullHttpResponse response = null;
    try {
      byte[] body = EntityUtils.toByteArray(endpointResponse.getEntity());
      response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(body));
      response.headers().set("Content-Type", "application/json");
      response.headers().setInt("Content-Length", Integer.parseInt(endpointResponse.getFirstHeader("Content-Length").getValue()));

      filter.filter(response);
    } catch (Exception e) {
      e.printStackTrace();
      response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
      exceptionCaught(ctx, e);
    } finally {
      if(fullHttpRequest != null) {
        if(!HttpUtil.isKeepAlive(fullHttpRequest)) {
          ctx.write(response).addListener(ChannelFutureListener.CLOSE);
        } else {
          ctx.write(response);
        }
      }
      ctx.flush();
    }
  }

  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    cause.printStackTrace();
    ctx.close();
  }
}
