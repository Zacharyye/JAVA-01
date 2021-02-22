package zachary.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloReflect {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
    Class clazz = Class.forName("reflect.Hello");
    Hello obj = (Hello) clazz.newInstance();
    Method method = clazz.getMethod("hello", null);
    method.invoke(obj, null);
  }
}
