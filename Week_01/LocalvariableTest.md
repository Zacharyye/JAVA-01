```java
javac -g:vars com/geektime/zacharyye/LocalVariableTest.java
javap -c -verbose com.geektime.zacharyye.LocalVariableTest
Classfile /Users/zachary/Documents/geektime/java-01/Week_01/zacharyye/src/main/java/com/geektime/zacharyye/LocalVariableTest.class
  Last modified 2021-1-7; size 709 bytes
  MD5 checksum c51b6b7d3712461e3dd0ca8842de9b9f
public class com.geektime.zacharyye.LocalVariableTest
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #9.#27         // java/lang/Object."<init>":()V
   #2 = Class              #28            // com/geektime/zacharyye/MovingAverage
   #3 = Methodref          #2.#27         // com/geektime/zacharyye/MovingAverage."<init>":()V
   #4 = Methodref          #2.#29         // com/geektime/zacharyye/MovingAverage.submit:(D)V
   #5 = Methodref          #2.#30         // com/geektime/zacharyye/MovingAverage.getAvg:()D
   #6 = Fieldref           #31.#32        // java/lang/System.out:Ljava/io/PrintStream;
   #7 = Methodref          #33.#34        // java/io/PrintStream.println:(D)V
   #8 = Class              #35            // com/geektime/zacharyye/LocalVariableTest
   #9 = Class              #36            // java/lang/Object
  #10 = Utf8               <init>
  #11 = Utf8               ()V
  #12 = Utf8               Code
  #13 = Utf8               LocalVariableTable
  #14 = Utf8               this
  #15 = Utf8               Lcom/geektime/zacharyye/LocalVariableTest;
  #16 = Utf8               main
  #17 = Utf8               ([Ljava/lang/String;)V
  #18 = Utf8               args
  #19 = Utf8               [Ljava/lang/String;
  #20 = Utf8               ma
  #21 = Utf8               Lcom/geektime/zacharyye/MovingAverage;
  #22 = Utf8               num1
  #23 = Utf8               I
  #24 = Utf8               num2
  #25 = Utf8               avg
  #26 = Utf8               D
  #27 = NameAndType        #10:#11        // "<init>":()V
  #28 = Utf8               com/geektime/zacharyye/MovingAverage
  #29 = NameAndType        #37:#38        // submit:(D)V
  #30 = NameAndType        #39:#40        // getAvg:()D
  #31 = Class              #41            // java/lang/System
  #32 = NameAndType        #42:#43        // out:Ljava/io/PrintStream;
  #33 = Class              #44            // java/io/PrintStream
  #34 = NameAndType        #45:#38        // println:(D)V
  #35 = Utf8               com/geektime/zacharyye/LocalVariableTest
  #36 = Utf8               java/lang/Object
  #37 = Utf8               submit
  #38 = Utf8               (D)V
  #39 = Utf8               getAvg
  #40 = Utf8               ()D
  #41 = Utf8               java/lang/System
  #42 = Utf8               out
  #43 = Utf8               Ljava/io/PrintStream;
  #44 = Utf8               java/io/PrintStream
  #45 = Utf8               println
{
  public com.geektime.zacharyye.LocalVariableTest();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/geektime/zacharyye/LocalVariableTest;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=3, locals=6, args_size=1
         0: new           #2                  // class com/geektime/zacharyye/MovingAverage
         3: dup
         4: invokespecial #3                  // Method com/geektime/zacharyye/MovingAverage."<init>":()V
         7: astore_1
         8: iconst_1
         9: istore_2
        10: iconst_2
        11: istore_3
        12: aload_1
        13: iload_2
        14: i2d
        15: invokevirtual #4                  // Method com/geektime/zacharyye/MovingAverage.submit:(D)V
        18: aload_1
        19: iload_3
        20: i2d
        21: invokevirtual #4                  // Method com/geektime/zacharyye/MovingAverage.submit:(D)V
        24: aload_1
        25: invokevirtual #5                  // Method com/geektime/zacharyye/MovingAverage.getAvg:()D
        28: dstore        4
        30: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
        33: dload         4
        35: invokevirtual #7                  // Method java/io/PrintStream.println:(D)V
        38: return
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      39     0  args   [Ljava/lang/String;
            8      31     1    ma   Lcom/geektime/zacharyye/MovingAverage;
           10      29     2  num1   I
           12      27     3  num2   I
           30       9     4   avg   D
}
```

