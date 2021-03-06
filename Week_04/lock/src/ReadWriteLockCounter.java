import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class ReadWriteLockCounter {
  private int sum = 0;
  //可重入-读写锁-公平锁
  private ReadWriteLock lock = new ReentrantReadWriteLock(true);

  public int incrAndGet() {
    try {
      lock.writeLock().lock(); //写锁；独占锁；被读锁排斥
      return ++sum;
    } finally {
      lock.writeLock().unlock();
    }
  }

  public int getSum() {
    try {
      lock.readLock().lock(); //读锁；共享锁；保证可见型
      return sum;
    } finally {
      lock.readLock().unlock();
    }
  }

  public static void testCounter() {
    int loopNum = 100_000;
    ReadWriteLockCounter counter = new ReadWriteLockCounter();
    AtomicInteger sum = new AtomicInteger(0);
    IntStream.range(0, loopNum).parallel().forEach(c -> {
//      counter.incrAndGet();
//      System.out.println(counter.getSum());;
      System.out.println(sum.incrementAndGet());
    });
  }

  public static void main(String[] args) {
    testCounter();
  }
}
