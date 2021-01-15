package jvm;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.Base64;

public class HelloClassLoader extends ClassLoader {
  public static void main(String[] args) {
//    try {
//      Object hello = new HelloClassLoader().findClass("com.geektime.zacharyye.classloader.Hello").newInstance();
//      System.out.println(hello instanceof Hello);
//      Method[] methods = hello.getClass().getDeclaredMethods();
//      Arrays.stream(methods).forEach(m -> {
//        System.out.println(m.getName());
//        try {
//          m.invoke(hello, null);
//        } catch (IllegalAccessException e) {
//          e.printStackTrace();
//        } catch (InvocationTargetException e) {
//          e.printStackTrace();
//        }
//      });
//    } catch (ClassNotFoundException e) {
//      e.printStackTrace();
//    } catch (InstantiationException e) {
//      e.printStackTrace();
//    } catch (IllegalAccessException e) {
//      e.printStackTrace();
//    }
    try {
      Object hello = new HelloClassLoader().findClass("Hello").newInstance();
      Method method = hello.getClass().getMethod("hello");
      method.invoke(hello);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
//    try {
//      new HelloClassLoader().generateXlassFile();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
  }

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    byte[] contentBytes  = new byte[0];
    try {
      contentBytes = decode(getFileContent());
    } catch (IOException e) {
      e.printStackTrace();
    }

    return defineClass(name, contentBytes, 0 , contentBytes.length);
  }

  public byte[] decode(byte[] contentBytes) {
    byte[] newBytes = new byte[contentBytes.length];
    for(int i = 0; i < contentBytes.length; i++) {
      newBytes[i] = (byte) (255 - contentBytes[i]);
    }
    return newBytes;
  }

  public byte[] getFileContent() throws IOException {
    File file = new File("/Users/zachary/Documents/geektime/java-01/Week_01/jvm/Hello.xlass");
    byte[] fileByte = new byte[(int) file.length()];
    FileInputStream inputStream = new FileInputStream(file);
    for(int i = 0; i < fileByte.length; i++) {
      fileByte[i] = (byte) inputStream.read();
    }
    return fileByte;
  }

  public void  generateXlassFile() throws IOException {
    String file = this.getClass().getResource("Hello.class").getFile();
    File file1 = new File(file);
    byte[] fileByte = new byte[(int) file1.length()];
    FileInputStream inputStream = new FileInputStream(file1);
    byte[] newBytes = new byte[fileByte.length];
    for(int i = 0; i < fileByte.length; i++) {
      fileByte[i] = (byte) (255 - inputStream.read());
    }
    File file2 = new File("/Users/zachary/Documents/geektime/java-01/Week_01/jvm/Hello.xlass");
    System.out.println(file2);
    if(!file1.exists()) {
      file1.createNewFile();
    }
    FileOutputStream outputStream = new FileOutputStream(file2);
    outputStream.write(fileByte);
    inputStream.close();
    outputStream.close();
  }
}
