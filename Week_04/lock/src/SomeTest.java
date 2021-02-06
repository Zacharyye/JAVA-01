import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SomeTest {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    //1.CompletableFuture
    CompletableFuture<String> cf = CompletableFuture.supplyAsync((() -> "hello,楼下小黑哥"));
    cf.thenApply(String::toLowerCase);
    cf.thenCompose(s -> CompletableFuture.supplyAsync(s::toLowerCase));
    System.out.println(cf.get());

    //2.四两拨千斤 - 并行Stream
    List<Integer> list = new ArrayList<>();
    IntStream.range(1, 10000).forEach(i -> list.add(i));
    BlockingQueue<Long> blockingQueue = new LinkedBlockingQueue<>(10000);
    List<Long> longList = list.stream().parallel()
            .map(i -> i.longValue())
            .sorted()
            .collect(Collectors.toList());
      //并行
    longList.stream().parallel().forEach(i -> {
      try {
        blockingQueue.put(i);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    System.out.println("blockingQueue" + blockingQueue.toString());
    System.out.println("size: " + blockingQueue.size());
  }
}
