package com.zachary.netty.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public interface HttpResonseFilter {
  void filter(FullHttpResponse response);
}
