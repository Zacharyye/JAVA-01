import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Homework_7 {
  public static void main(String[] args) {
    //启动新线程 1 - 新建一个线程并启动
    new Thread(() ->
      System.out.println(Thread.currentThread().getName() + "启动了")
    ).start();

    //启动新线程 2 - 线程池1
    Executors.newSingleThreadExecutor().submit(() -> System.out.println(Thread.currentThread().getName() + "启动了"));

    //启动新线程 3 - 线程池2
    Executors.newFixedThreadPool(1).submit(() -> System.out.println(Thread.currentThread().getName() + "启动了"));

    //启动新线程4 - 线程池3
    Executors.newCachedThreadPool().submit(() ->System.out.println(Thread.currentThread().getName() + "启动了"));

    //启动新线程5 - 线程池4
    Executors.newScheduledThreadPool(1)
            .scheduleAtFixedRate(() -> System.out.println(Thread.currentThread().getName() + "启动了")
                    , 2000
                    , 24L * 60 * 60 * 1000
                    , TimeUnit.MILLISECONDS);
    //启动新线程6 - 线程池5
    ThreadPoolExecutor myThreadPool = new ThreadPoolExecutor(
            2,
            5,
            6000,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(100),
            new ThreadFactory() {
              private final AtomicInteger mThreadNum = new AtomicInteger(1);
              @Override
              public Thread newThread(Runnable r) {
                Thread t = new Thread(r, String.format("ZAC-Thread-Z-%d", mThreadNum.getAndIncrement()));
                return t;
              }
            },
            new ThreadPoolExecutor.AbortPolicy()
    );
    myThreadPool.submit(() -> System.out.println(Thread.currentThread().getName() + "启动了"));
    System.exit(1);
  }
}
