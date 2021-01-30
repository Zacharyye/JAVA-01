package com.zachary.netty.inbound;

import com.zachary.netty.filter.HeaderHttpRequestFilter;
import com.zachary.netty.filter.HttpRequestFilter;
import com.zachary.netty.outbound.httpclient.HttpOutboundHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Scope("singleton")
@ChannelHandler.Sharable
@Data
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {
  private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
  private List<String> proxyServer;
  private HttpOutboundHandler handler;
  private HttpRequestFilter filter = new HeaderHttpRequestFilter();

  public static final HttpInboundHandler instance = new HttpInboundHandler();
//  private HttpInboundHandler(List<String> proxyServer) {
//    this.proxyServer = proxyServer;
//    this.handler = new HttpOutboundHandler(this.proxyServer);
//  }

  private HttpInboundHandler () {}

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    try {
      FullHttpRequest request = (FullHttpRequest) msg;
      handler.handle(request, ctx, filter);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      ReferenceCountUtil.release(msg);
    }
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    ctx.flush();
  }
}
