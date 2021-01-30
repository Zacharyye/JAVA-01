package com.zachary.netty.okhttp;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
public class HttpUtils {
  private static OkHttpClient client = new OkHttpClient();

  @SneakyThrows
  public static String httpGet(String url) {
    Request request = new Request.Builder()
            .url(url)
            .build();
    log.info("GET请求参数" + request.toString());
    try (Response response = client.newCall(request).execute()) {
      log.info("GET响应" + response.toString());
      return response.body().string();
    }
  }

  public static void main(String[] args) {
    System.out.println(httpGet("http://localhost:8808/test"));;
  }
}
