# Hello字节码

```java
javap -c com.geektime.zacharyye.Hello
Compiled from "Hello.java"
public class com.geektime.zacharyye.Hello {
  public com.geektime.zacharyye.Hello();
    Code:
       0: aload_0														// 加载局部变量（引用？）到操作栈
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V 调用构造函数初始化
       4: return														// 返回？

  public static void main(java.lang.String[]);
    Code:
       0: iconst_1													// 加载常量int到操作栈
       1: istore_1													// 将int数值从操作数栈存储到局部变量表
       2: bipush        97									// 将常量加载到操作数栈
       4: istore_2													// 将int数值从操作数栈存储到局部变量表
       5: ldc2_w        #7                  // double 0.1d  常量 -> 操作数栈
       8: dstore_3													// double 操作数栈 -> 局部变量表
       9: ldc           #9                  // float 0.2f   常量 -> 操作数栈
      11: fstore        5										// float 常量 -> 局部变量表
      13: ldc2_w        #10                 // long 2l  常量 -> 操作数栈
      16: lstore        6										// long 数值 操作数栈 -> 局部变量表
      18: iload_1														// int 局部变量 -> 操作栈
      19: iload_2														// int 局部变量 -> 操作栈
      20: iadd															// int 加法
      21: i2d																// int -> double
      22: dload_3														// double 局部变量 -> 操作栈
      23: fload         5										// float 局部变量 -> 操作栈
      25: f2d																// float -> double
      26: dmul															// double 乘法运算
      27: lload         6										// long 局部变量 -> 操作栈
      29: l2d																// long -> double
      30: ddiv															// double 除法运算
      31: dsub															// double 减法运算
      32: dstore        8										// double 操作数栈 -> 局部变量表
      34: dload         8										// double 局部变量 -> 操作栈
      36: ldc2_w        #12                 // double 200.0d  常量 -> 操作数栈
      39: dcmpg															// double 比较
      40: ifge          64									// int 大于等于 -> 64，小于 -> 继续
      43: dload         8										// double 局部变量 -> 操作数栈
      45: ldc2_w        #14                 // double 100.0d  常量 -> 操作数栈
      48: dcmpl															// double 比较
      49: iflt          55									// int 小于 -> 55，不小于 -> 继续
      52: goto          64									// 跳转至 64
      55: dload         8										// double 局部变量 -> 操作数栈
      57: dconst_1													// 常量 -> 操作数栈
      58: dadd															// double 加法运算
      59: dstore        8										// 操作数栈 -> 局部变量
      61: goto          34									// 跳转至 34
      64: getstatic     #16                 // Field java/lang/System.out:Ljava/io/PrintStream; 调用类静态方法
      67: dload         8										// double 局部变量 -> 操作数栈
      69: invokevirtual #22                 // Method java/io/PrintStream.println:(D)V 调用接口方法
      72: return
}
```

```java
javap -c -verbose com.geektime.zacharyye.Hello
Classfile /Users/zachary/Documents/geektime/java-01/Week_01/zacharyye/src/main/java/com/geektime/zacharyye/Hello.class
  Last modified 2021年1月7日; size 616 bytes
  SHA-256 checksum 861f6a2991df01ef2b81f37a0fa5de443365fbc7af240389d4188241918d10ba
  Compiled from "Hello.java"
public class com.geektime.zacharyye.Hello
  minor version: 0
  major version: 59
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #28                         // com/geektime/zacharyye/Hello
  super_class: #2                         // java/lang/Object
  interfaces: 0, fields: 0, methods: 2, attributes: 1
Constant pool:
   #1 = Methodref          #2.#3          // java/lang/Object."<init>":()V
   #2 = Class              #4             // java/lang/Object
   #3 = NameAndType        #5:#6          // "<init>":()V
   #4 = Utf8               java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Double             0.1d
   #9 = Float              0.2f
  #10 = Long               2l
  #12 = Double             200.0d
  #14 = Double             100.0d
  #16 = Fieldref           #17.#18        // java/lang/System.out:Ljava/io/PrintStream;
  #17 = Class              #19            // java/lang/System
  #18 = NameAndType        #20:#21        // out:Ljava/io/PrintStream;
  #19 = Utf8               java/lang/System
  #20 = Utf8               out
  #21 = Utf8               Ljava/io/PrintStream;
  #22 = Methodref          #23.#24        // java/io/PrintStream.println:(D)V
  #23 = Class              #25            // java/io/PrintStream
  #24 = NameAndType        #26:#27        // println:(D)V
  #25 = Utf8               java/io/PrintStream
  #26 = Utf8               println
  #27 = Utf8               (D)V
  #28 = Class              #29            // com/geektime/zacharyye/Hello
  #29 = Utf8               com/geektime/zacharyye/Hello
  #30 = Utf8               Code
  #31 = Utf8               LineNumberTable
  #32 = Utf8               main
  #33 = Utf8               ([Ljava/lang/String;)V
  #34 = Utf8               StackMapTable
  #35 = Class              #36            // "[Ljava/lang/String;"
  #36 = Utf8               [Ljava/lang/String;
  #37 = Utf8               SourceFile
  #38 = Utf8               Hello.java
{
  public com.geektime.zacharyye.Hello();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 8: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: (0x0009) ACC_PUBLIC, ACC_STATIC
    Code:
      stack=6, locals=10, args_size=1
         0: iconst_1
         1: istore_1
         2: bipush        97
         4: istore_2
         5: ldc2_w        #7                  // double 0.1d
         8: dstore_3
         9: ldc           #9                  // float 0.2f
        11: fstore        5
        13: ldc2_w        #10                 // long 2l
        16: lstore        6
        18: iload_1
        19: iload_2
        20: iadd
        21: i2d
        22: dload_3
        23: fload         5
        25: f2d
        26: dmul
        27: lload         6
        29: l2d
        30: ddiv
        31: dsub
        32: dstore        8
        34: dload         8
        36: ldc2_w        #12                 // double 200.0d
        39: dcmpg
        40: ifge          64
        43: dload         8
        45: ldc2_w        #14                 // double 100.0d
        48: dcmpl
        49: iflt          55
        52: goto          64
        55: dload         8
        57: dconst_1
        58: dadd
        59: dstore        8
        61: goto          34
        64: getstatic     #16                 // Field java/lang/System.out:Ljava/io/PrintStream;
        67: dload         8
        69: invokevirtual #22                 // Method java/io/PrintStream.println:(D)V
        72: return
      LineNumberTable:
        line 11: 0
        line 12: 2
        line 13: 5
        line 14: 9
        line 15: 13
        line 16: 18
        line 17: 34
        line 18: 43
        line 19: 52
        line 17: 55
        line 22: 64
        line 23: 72
      StackMapTable: number_of_entries = 3
        frame_type = 255 /* full_frame */
          offset_delta = 34
          locals = [ class "[Ljava/lang/String;", int, int, double, float, long, double ]
          stack = []
        frame_type = 20 /* same */
        frame_type = 8 /* same */
}
SourceFile: "Hello.java"
```

