package com.geektime.zacharyye;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class JvmClassloaderPrintPath {

  public static void main(String[] args) {
//    URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs(); jdk15 没有这个文件
    URL[] urls = null;
    System.out.println("启动类加载器");
    for(URL url : urls) {
      System.out.println(" --> " + url.toExternalForm());
    }
    //扩展类加载器
    printClassLoader("扩展类加载器", JvmClassloaderPrintPath.class.getClassLoader().getParent());

    //应用类加载器
    printClassLoader("应用类加载器", JvmClassloaderPrintPath.class.getClassLoader());
  }

  public static void printClassLoader(String name, ClassLoader classLoader) {
    if(classLoader != null) {
      System.out.println(name + "ClassLoader -> " + classLoader.toString());
      printURLForClassLoader(classLoader);
    } else {
      System.out.println(name + "ClassLoader -> null");
    }
  }

  public static void printURLForClassLoader(ClassLoader classLoader) {
    Object ucp = insightField(classLoader, "ucp");
    Object path = insightField(ucp, "path");
    ArrayList ps = (ArrayList) path;
    for(Object p : ps) {
      System.out.println(" ==> " + p.toString() );
    }
  }

  public static Object insightField(Object obj, String fName) {
    try {
      Field f = null;
      if(obj instanceof URLClassLoader) {
        f = URLClassLoader.class.getDeclaredField(fName);
      } else {
        f = obj.getClass().getDeclaredField(fName);
      }
      f.setAccessible(true);
      return f.get(obj);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
