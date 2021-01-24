
public class OkHttpRequest {
  public static void main(String[] args) {
    //jar 包引入有问题，待解决
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url("http://localhost:8081")
            .build();
    try (Response response = client.newCall(request).execute()) {
      return response.body().string();
    }
  }
}
