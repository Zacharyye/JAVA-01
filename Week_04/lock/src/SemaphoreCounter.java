import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SemaphoreCounter {
  private int sum = 0;

  private Semaphore readSemaphore = new Semaphore(100, true);
  private Semaphore writeSemaphore = new Semaphore(1);

  public int incrAndGet() {
    try {
      writeSemaphore.acquireUninterruptibly();
      return ++sum;
    } finally {
      writeSemaphore.release();
    }
  }

  public int getSum() {
    try {
      readSemaphore.acquireUninterruptibly();
      return sum;
    } finally {
      readSemaphore.release();
    }
  }

  public static void testCounter() {
    int loopNum = 100_0000;
    SemaphoreCounter counter = new SemaphoreCounter();
    IntStream.range(0, loopNum).parallel().forEach(c -> {
      System.out.println(counter.incrAndGet());;
    });
  }

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    testCounter();
    //CountdownLatch
    int num  = 100;
    CountDownLatch latch = new CountDownLatch(num);
    List<CompletableFuture> list = new ArrayList<>(num);
    for(int i = 0; i < num; i++) {
      CompletableFuture<Void> future = CompletableFuture.runAsync(new CountDownLatchTask(latch));
      list.add(future);
    }
    latch.await();
    for(CompletableFuture future : list) {
      future.get();
    }
    //CyclicBarrier
    num = 2;
    CyclicBarrier barrier = new CyclicBarrier(num);
    list = new ArrayList<>(num);
    for(int i = 0; i < num; i++) {
      CompletableFuture<Void> future = CompletableFuture.runAsync(new CyclicBarrierTask(barrier));
      list.add(future);
    }
    for(CompletableFuture future : list) {
      future.get();
    }
    barrier.reset();
  }

  //CountdownLatch
  public static class CountDownLatchTask implements Runnable {
    private CountDownLatch latch;

    public CountDownLatchTask(CountDownLatch latch) {
      this.latch = latch;
    }

    @Override
    public void run() {
      Integer millis = new Random().nextInt(10000);
      try {
        TimeUnit.MILLISECONDS.sleep(millis);
        this.latch.countDown();
        System.out.println("我的任务OK了：" + Thread.currentThread().getName());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  //CyclicBarrier 示例
  public static class CyclicBarrierTask implements Runnable {
    private CyclicBarrier barrier;

    public CyclicBarrierTask(CyclicBarrier barrier) {
      this.barrier = barrier;
    }

    @Override
    public void run() {
      Integer millis = new Random().nextInt(10000);
      try {
        TimeUnit.MILLISECONDS.sleep(millis);
        this.barrier.await();
        System.out.println("开吃：" + Thread.currentThread().getName());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
