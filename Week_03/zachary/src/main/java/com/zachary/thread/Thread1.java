package com.zachary.thread;

public class Thread1 {
  public static void main(String[] args) {
    Runnable task = () -> {
        try {
          Thread.sleep(5000);
        } catch (Exception e) {
          e.printStackTrace();
        }
        Thread t = Thread.currentThread();
        System.out.println("当前线程：" + t.getName());
    };
    Thread thread = new Thread(task);
    thread.setName("test-thread-1");
    thread.setDaemon(true);
    thread.start();
  }
}
