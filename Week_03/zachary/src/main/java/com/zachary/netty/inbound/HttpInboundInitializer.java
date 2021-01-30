package com.zachary.netty.inbound;

import com.zachary.netty.outbound.httpclient.HttpOutboundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class HttpInboundInitializer extends ChannelInitializer<SocketChannel> {
  private List<String> proxyServer;

  public static final HttpInboundInitializer instance = new HttpInboundInitializer();

  private HttpInboundInitializer() {}


  @Override
  protected void initChannel(SocketChannel socketChannel) throws Exception {
    ChannelPipeline p = socketChannel.pipeline();
    HttpInboundHandler httpInboundHandler = HttpInboundHandler.instance;
    HttpOutboundHandler httpOutboundHandler = HttpOutboundHandler.instance;
    httpOutboundHandler.setBackendUrls(proxyServer.stream().map(HttpOutboundHandler::formatUrl).collect(Collectors.toList()));
    httpInboundHandler.setProxyServer(this.proxyServer);
    httpInboundHandler.setHandler(httpOutboundHandler);
    System.out.println("ChannelPipeline -- " + p);
    p.addLast(new HttpServerCodec());
    p.addLast(new HttpObjectAggregator(1024 * 1024));
    p.addLast(httpInboundHandler);
  }
}
