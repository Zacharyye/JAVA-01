package io.zachary.api;

public interface Filter {
  boolean filter(RpcfxRequest request);
}
