学习笔记

## 开营

～

## 预习 - 第1课

1. JVM核心技术（一）：基础知识

- 编程语言跨平台
  - 源代码跨平台
  - 二进制跨平台
- 字节码、类加载器、虚拟机
- Java字节码技术
  - Java bytecode由单子节（byte）的指令组成，理论上最多支持256个操作码，实际上Java只使用了200左右的操作码，还有一些操作码则保留给调试操作
  - 指令按性质分为四大类：
    - 栈操作指令，包括与局部变量交互的指令
    -  程序流程控制指令
    - 对象操作指令，包括方法调用指令
    - 算数运算以及类型转换指令
  - 字节码的运行时结构
    - JVM是一台基于栈的计算机器
    - 每个线程都有一个独属于自己的线程栈，用于存储栈帧
    - 每一次方法调用，JVM都会自动创建一个栈帧
    - 栈帧由操作数栈，局部变量数组以及一个Class引用组成
    - Class引用指向当前方法在运行时常量池中对应的Class
  - 算数操作与类型转换
  - 方法调用的指令
    - invokestatic - 用于调用某个类的静态方法，这是方法调用指令中最快的一个
    - invokespecial - 用来调用构造函数，但也可以用于调用同一个类中的private方法，以及可见的超类方法
    - invokevirtual - 如果是具体类型的目标对象，invokevirtual用于调用公共、受保护和package级的私有方法
    - invokeinterface - 当通过接口引用来调用方法时，将会编译为invokeinterface指令
    - invokedynamic - jdk7新增加的指令，是实现“动态类型语言”支持而进行的升级改进，同时也是jdk8以后支持lambda表达式的实现基础
- JVM类加载器
  - 类的生命周期
    - 加载 - Loading，找Class文件
    - 验证 - Verification，验证格式、依赖
    - 准备 - Preparation，静态字段、方法表
    - 解析 - Resolution，符号解析为引用
    - 初始化 - Initialization，构造器、静态变量赋值、静态代码块
    - 使用 - Using
    - 卸载 - Unloading
    - 【链接】包含校验、准备、解析三个步骤
  - 类的加载时机
    - 当虚拟机启动时，初始化用户指定的主类，就是启动执行的main方法所在的类
    - 当遇到用以新建目标实例的new指令时，初始化new指令的目标类，就是new一个类的时候要初始化
    - 当遇到调用静态方法的指令时，初始化该静态方法所在的类
    - 当遇到访问静态字段的指令时，初始化该静态字段所在的类
    - 子类的初始化会触发父类的初始化
    - 如果一个接口定义了default方法，那么直接实现或者间接实现该接口的类的初始化，会触发该接口的初始化
    - 使用反射API对某个类进行反射调用时，初始化这个类，其实跟前面一样，反射调用要么是已经有实例了，要么是静态方法，都需要初始化
    - 当初次调用MethodHandle实例时，初始化该MethodHandle指向的方法所在的类
  - 不会初始化（可能会加载）
    - 通过子类引用父类的静态字段，只会触发父类的初始化，而不会触发子类的初始化
    - 定义对象数组，不会触发该类的初始化
    - 常量在编译期间会存入调用类的常量池中，本质上并没有直接引用定义常量的类，不会触发定义常量所在的类
    - 通过类名获取Class对象，不会触发类的初始化，Hello.class不会让Hello类初始化
    - 通过Class.forName加载指定类时，如果指定参数Initialize为false时也不会触发类初始化，其实这个参数是告诉虚拟机，是否要对类进行初始化。Class.forName("jvm.Hello")默认会加载Hello类
    - 通过ClassLoader默认的loadClass方法，也不会触发初始化动作（加载了，但是不初始化）
  - 三类加载器
    - 启动类加载器 - BootstrapClassLoader
    - 扩展类加载器 - ExtClassLoader
    - 应用类加载器 - AppClassLoader
    - 加载器特点：
      - 双亲委派
      - 负责依赖
      - 缓存加载
  - 显示当前ClassLoader加载了哪些Jar
  - 自定义ClassLoader
  - 添加引用类的几种方式
    - 放到JDK的lib/ext下，或者-Djava.ext.dirs
    - java -cp/classpath 或者 class文件放到当前路径
    - 自定义ClassLoader加载
    - 拿到当前执行类的ClassLoader，反射调用addUrl方法添加Jar或路径（JDK9无效）
- JVM内存模型
  - JVM内存结构 
    - 线程栈
    - 堆内存
  - 每个线程都只能访问自己的线程栈
  - 每个线程都不能访问（看不见）其他线程的局部变量
  - 所有原生类型的局部变量都存储在线程栈中，因此对其他线程是不可见的
  - 线程可以将一个原生变量值的副本传给另一个线程，但不能共享原生局部变量本身
  - 堆内存中包含了Java代码中创建的所有对象，不管是哪个线程创建的。其中也涵盖了包装类型（例如Byte、Integer、Long等）
  - 不管是创建一个对象并将其赋值给局部变量，还是赋值给另一个对象的成员变量，创建的对象都会被保存到堆内存中。
  - 如果是原生数据类型的局部变量，那么它的内容就全部保留在线程栈上
  - 如果是对象引用，则栈中的局部变量槽位中保存着对象的引用地址，而实际的对象内容保存在堆中
  - 对象的成员变量与对象本身一起存储在堆上，不管成员变量的类型是原生数值，还是对象引用
  - 类的静态变量则和类定义一样都保存在堆中
  - 总结
    - 方法中使用的原生数据类型和对象引用地址在栈上存储；对象、对象成员与类定义、静态变量在堆上
    - 堆内存又称为“共享堆”，堆中的所有对象，可能被所有线程访问，只要他们能拿到对象的引用地址
    - 如果一个线程可以访问某个对象时，也就可以访问该对象的成员变量
    - 如果两个线程同时调用某个对象的同一方法，则它们都可以访问到这个对象的成员变量，但每个线程的局部变量副本时独立的
  - JVM内存整体结构
    - 每启动一个线程，JVM就会在栈空间栈分配对应的线程栈，比如1MB的空间（- Xss1m）。
    - 线程栈也叫做Java方法栈。如果使用了JNI方法，则会分配一个单独的本地方法栈（Native Stack）。
    - 线程执行过程中，一般会有多个方法组成调用栈（Stack Trace），比如A调用B，B调用C。。。每执行到一个方法，就会创建对应的栈帧（Frame）。
  - JVM栈内存结构
    - 栈帧是一个逻辑上的概念，具体的大小在一个方法编写完成后基本上就能确定
    - 比如返回值 需要一个空间存放，每个局部变量都需要对应的地址空间，此外还有给指令使用的操作数栈，以及class指针（标识这个栈帧对应的是哪个类的方法，指向非堆里面的Class对象）。
  - JVM堆内存结构
    - 堆内存是所有线程共用的内存空间，JVM将Heap内存分为年轻代（Young generation）和老年代（Old generation，也叫Tenured）两部分。
    - 年轻代还划分为3个内存池，新生代（Eden space）和存活区（Survivor space），在大部分GC算法中有2个存活区（S0、S1），在我们可以观察到的任何时刻，S0和S1总有一个是空的，但一般较小，也不浪费多少空间
    - Non-Heap本质上还是Heap，只是一般不归GC管理，里面划分为3个内存池
    - Metaspace，以前叫持久代（永久代，Permanent generation），Java8换了个名字叫Metaspace
    - CCS，Compressed Class Space，存放class信息的，和Metaspace有交叉
    - Code Cache，存放JIT编译器编译后的本地机器代码
  - CPU与内存行为
    - CPU乱序执行
    - volatile关键字
    - 原子性操作
    - 内存屏障
- JVM启动参数
  - 以-开头为标准参数，所有的JVM都要实现这些参数，并且向后兼容
  - -D设置系统属性
  - 以-X开头为非标准参数，基本都是传给JVM的，默认JVM实现这些参数的功能，但是并不保证所有JVM实现都满足，且不保证向后兼容。可以使用java -X命令来查看当前JVM支持的非标准参数
  - 以-XX：开头为非稳定参数，专门用于控制JVM的行为，跟具体的JVM实现有关，随时可能会在下个版本取消
  - -XX：+-Flag是形式，+-是对布尔值进行开关
  - -XX：key=value形式，指定某个选项的值
  - 参数
    - 系统属性参数
    - 运行模式参数
      - -server
      - -client
      - -Xint
      - -Xcomp
      - -Xmixed
    - 堆内存设置参数
      - -Xmx 
      - -Xms
      - -Xmn == - XX：NewSize
      - -XX：MaxPermSize=size
      - -XX：MaxMetaspaceSize=size
      - -XX：MaxDirectMemorySize=size
      - -Xss
    - GC设置参数
      - -XX：+UseG1GC：使用G1垃圾回收器
      - -XX：+UseConcMarkSweepGC：使用CMS垃圾回收器
      - -XX：+UseSerialGC：使用串行垃圾回收器
      - -XX：+UseParallelGC：使用并行垃圾回收器
      - //Java 11+
        - -XX：+UnlockExperimentalVMOptions -XX：+UseZGC
      - //Java 12+
        - -XX：+UnlockExperimentalVMOptions -XX：+UseShenandoahGC
    - 分析诊断参数
      - -XX：+-HeapDumpOnOutOfMemoryError
      - -XX：HeapDumpPath
      - -XX：OnError
      - -XX：OnOutOfMemoryError
      - -XX：ErrorFile=filename
      - -Xdebug -Xrunjdwp：transport=dt_socket,server=y,suspend=n,address=1506 远程调试
    - JavaAgent参数
      - Ageng是JVM中的一项黑科技，可以通过无侵入方式来做很多事情，比如注入AOP 代码，执行统计等等。
      - -agentlib:libname
      - -agentpath:pathname
      - -javaagent:jarpath 启用外部的agent哭
      - -Xnoagent 禁用所有agent

## 课上

- 字节码不是用来看的，是给JVM执行的

- JVM内存整体结构
  - Java方法栈 - 一般会有多个方法组成调用栈
- JVM栈内存结构
  - 栈帧是一个逻辑上的概念，具体的大小在一个方法编写完成后基本上确定
- JVM堆内存结构
  - Heap - 
    - 年轻代
      - 新生代、存活区（S0，S1），S0、S1总有一个是空的
    - 老年代
  - Non-Heap 
    - 本质上还是Heap，只是一般不归GC管理，里面划分为3个内存池
      - Metaspace - 持久代，以前的永久代
      - CCS - Compressed Class Space，存放class信息和Metaspace有交叉
      - Code Cache，存放JIT编译器编译后的本地机器代码
      - JVM使用的数据
      - 跟业务无关？
- CPU与内存行为
  - CPU乱序执行
  - volatile关键字
  - 原子性操作
  - 内存屏障

# 预习 - 第2课 

### JVM核心技术 -- 工具与GC策略

1. JDK内置命令行工具

- ```java
  java/javac/javap/javadoc/javah/extcheck/jdb/jdeps/jar/keytool/jarsigner/policytool
  ```

- ```java
  jps/jinfo 查看java进程
  jstat 查看JVM内部gc相关信息
  jmap 查看heap或类占用空间统计
  jstack 查看线程信息
  jcmd	执行jvm相关分析命令
  jrunscript/jjs 执行js命令
  ```

- jinfp命令报错

  - Can't attach symbolicator to the process
  - **Linux**：ptrace-scope 机制
  - macOS - 升级到jdk9以上

- jstat

  - jstat -gc 19959 1000 1000

- jmap - heap pid/jmap -histo pid

  - jmap -dump:format=b,file=3826.hprof3826

- jcmd 

  - jcmd pid VM.version
  - jcmd pid VM.flags
  - jcmd pid VM.command_line
  - jcmd pid VM.system_properties
  - jcmd pid Thread.print
  - jcmd pid GC.class_histogram
  - jcmd pid GC.heap_info

- Jrunscript/jjs

- jconsole

- jvisualvm

- 图形化工具

  - visualGC
  - jmc

3. GC的背景与一般原理

- 为什么会有GC
  - 本质上是内存资源的有限性，因此需要大家共享使用，手工申请，手动释放
  - 引用计数 -> 引用更新
  - 标记清除算法（Mark and Sweep）
    - Marking （标记）- 遍历所有的可达对象，并在本地内存（native）中分门别类记下
    - Sweeping（清除）- 这一步保证了，不可达对象所占用的内存，在之后进行内存分配时可以重用
  - 并行GC和CMS的基本原理
    - 优势：可以处理循环依赖，只扫描部分对象

4. 串行GC/并行GC（Serial GC/Parallel GC）

- 年轻代 ： 标记 - 复制
- 老年代：标记 - 清除 - 整理

5. CMS GC/G1 GC

- ～

6. G1 GC

- ![image-20210113164641568](/Users/zachary/Library/Application Support/typora-user-images/image-20210113164641568.png)

7. ZGC/Shenandoah GC

- ～



# 课上

1. 命令工具

- jps -l

- jstat jmap(jhsdb jmap) 查看堆内存，jstack 查看线程

- jStat -gc(util) pid 1000 1000 每1000ms打印一次，打印1000次
-  wrk http://localhost:8080/api/hello 进行压测

- jstack -l pid 显示线程信息
  - kill -3 打印出堆栈信息，kill -signal 发送信号
- jcmd pid help 查看可用命令
- Jrunscript / jjs

2.图形化工具

- jconsole
- Jenny shell
- visualGC 插件 idea/eclipse 可使用
- jmc - 重要
  - 但一般不建议在线上使用，此工具比较重，会干扰

3.GC的背景与一般原理

- 内存资源的有限性
- 引用计数
  - 循环以来
  - 内存泄漏、内存溢出
- 标记清除算法
  - marking - 标记可达对象
  - sweeping - 清除不可达对象，释放内存
- 并行GC和CMS的基本原理
  - CMS - C表示并行
- 除了清除，还要做压缩
  - STW - 标记、清除上百万对象，STOP THE WORLD，会GC暂停
- 分代假设：大部分新生对象很快无用；存活较长时间的对象，可能存活更长时间
- 内存池划分：不同类型对象不同区域，不同策略处理
  - 新创建的对象都会先分配到年轻代，一段时间后，如果还存活，就会提升到老年代
  - 年轻代 8:1:1
    - 新生代 - 其中的绝大部分对象是要被回收掉的  
      - TLAB * （多个）
    - S0
    - S1
- GC时对象在内存之间转移
  - 控制提升阈值的参数
    - -XX:+MaxRenuringThreshold=15
  - 对象分配在新生代的Eden区
    - 标记阶段Eden区存活的对象就会复制到存活区
    - 为什么是复制，不是移动？
      - 新生代有三个区，GC时把存活对象复制到其中一个区，另外两个区可以直接覆盖
      - 老年代只有一个区，只能移动后再处理废弃对象
    - 两个存活区from和to，互换角色。对象存活到一定周期会提升到老年代
  - 老年代默认都是存活对象，采用移动方式：
    - 标记所有通过GC roots可达的对象
    - 删除所有不可达对象
    - 整理老年代空间中的内容，方法是将所有的存活对象复制，从老年代空间开始的地方依次存放
  - GC Roots
    - 当前正在执行的方法里的局部变量和输入参数
    - 活动线程
    - 所有的类的静态字段
    - JNI引用
  - 清楚、复制、整理（压缩）

4.串行GC/并行GC（Serial GC/Parallel GC）

- Java8 默认是并行GC 
- 串行GC / Serial GC /ParNewGC
  - -XX:+UseSerialGC	配置好串行GC
  - 串行GC对年轻代使用mark-copy（标记-复制）算法，对老年代使用mark-sweep-compact（标记-清除-整理）算法。
  - 两者都是单线程的垃圾收集器，不能进行并行处理，所以都会触发全线暂停（STW），停止所有的应用线程
  - 因此这种GC算法不能充分利用多核CPU，不管有多少CPU内核，JVM在垃圾收集时都只能使用单个核心
  - CPU利用率高，暂停时间长。
- 并行GC / Parallel GC
  - -XX:+UserParallelGC
  - -XX:+UserParallelOldGC
  - -XX:+UseParallelGC -XX:+UseParallelOldGC
    - 以上三种等效
  - 年轻代和老年代的垃圾回收都会触发STW事件
  - 在年轻代使用标记-复制（mark-copy）算法，在老年代使用标记-清除-整理（mark-sweep-compact）算法
  - -XX:ParallelGCThreads=N来指定GC线程数，其默认值为CPU核心数
  - 并行垃圾收集器适用于多核服务器，主要目标是增加吞吐量，因为对系统资源的有效使用，能达到更高的吞吐量
    - 在GC期间，所有CPU内核都在并行清理垃圾，所以总暂停时间更短
    - 在两次GC周期的间隔期，没有GC线程在原型，不会消耗任何系统资源
- CMS GC（Mostly Concurrent Mark and Sweep Garbage Collector
  - -XX:+UseConcMarkSweepGC
  - 其对年轻代采用并行STW方式的mark-copy（标记-复制）算法，对老年代主要使用并发mark-sweep（标记-清除）算法
  - CMS GC的设计目标是避免在老年代垃圾收集时出现长时间的卡顿，主要通过两种手段来达成此目标：
    - 不对老年代进行整理，而是使用空闲列表来管理内存空间的回收
    - 在mark-and-sweep（标记-清除）阶段的大部分工作和应用线程一起并发执行
    - 也就是说，在这些阶段并没有明显的应用程序暂停。但值得注意的是，它仍然和应用线程争抢CPU时间。默认情况下，CMS使用的并发线程数等于CPU核心数的1/4
    - 如果服务器是多核CPU，并且主要调优目标是降低GC停顿导致的系统延迟，那么使用CMS是个很明智的选择。进行老年代的并发回收时，可能会伴随着多次年轻代的minor GC。
    - 并行Parallel与并发Concurrent的区别
- CMS GC - 六个阶段1（STW）
  - 阶段1 - Initial Mark（初始标记）
    - 这个阶段伴随着STW暂停。初始标记的目标是标记所有的根对象，包括根对象直接引用的对象，以及被年轻代中所有存活对象所引用的对象（老年代单独回收）。
  - 阶段2 - Concurrent Mark（并发标记）
    - 在此阶段，CMS GC遍历老年代，标记所有的存活对象，从前一阶段“Initial Mark”找到的根对象开始算起。“并发标记”阶段，就是与应用程序同时运行，不用暂停的阶段。
  - 阶段3 - Concurrent Preclean（并发预清理）
    - 此阶段同样是与应用线程并发执行的，不需要停止应用线程。因为前一阶段【并发标记】与程序并发运行，可能有一些引用关系已经发生了改变。如果在并发标记过程中引用关系发生了变化，JVM会通过“Card（卡片）”的方式将发生了改变的区域标记为“脏”区，这就是所谓的卡片标记。
  - 阶段4 - Final Remark（最终标记）
    - 最终标记阶段是此次GC事件中的第二次（也是最后一次）STW停顿。本阶段的目标是完成老年代中所有存活对象的标记。因为之前的预清理阶段是并发执行的，有可能GC线程跟不上应用程序的修改速度。所以需要一次STW暂停来处理各种复杂的情况。通常CMS会尝试在年轻代尽可能空的时候进行进行Final Remark阶段，以免连续处罚多次STW。
  - 阶段5 - Concurrent Sweep（并发清除）
    - 
  - 阶段6 - Concurrent Reset（并发重置）
    - 此阶段与应用程序并发执行，不需要STW停顿。JVM在此阶段删除不再使用的对象，并回收他们占用的内存空间。
  - 老式内存碎片化问题
- G1 GC
  - G1的全称是Garbage-First，意为垃圾优先，哪一块的垃圾最多就优先清理它
  - G1 GC最要的设计目标是：将STW停顿的时间和分布，变成可预期且可配置的
  - 事实上，G1 GC是一款软实时垃圾收集器，可以为其设置某项特定的性能指标。为了达成可预期停顿时间的指标，G1 GC有一些独特的实现。
  - 首先，堆不再分成年轻代和老年代，而是划分为多个（通常是2048个）可以存放对象的小块堆区域（smaller heap regions）。每个小块，可能一会儿被定义成Eden区，一会被指定为Survivor区或者Old区。在逻辑上，所有的Eden区和Survivor区合起来就是年轻代，所有的Old区拼在一起那就是老年代。
  - -XX:+UseG1GC -XX:MaxGCPauseMillis=50
  - 这样划分之后，使得G1不必每次都去收集整个堆空间，而是以增量的方式来进行处理：每次只处理一部分内存块，称为此次GC的回收集（collection set）。每次暂停都会收集所有年轻代的内存块，但一般只包含部分老年代的内存块
  - G1的另一项创新是，在并发阶段估算每个小堆存活对象的总数。构建回收集的原则是：垃圾最多的小块会被优先收集。这也是G1名称的由来。
- G1 GC的处理步骤1
  - 年轻代模式转移暂停（Evacuation Pause）
    - G1 GC会通过前面一段时间的运行情况来不断的调整自己的回收策略和行为，以此来比较稳定地控制暂停时间。在应用程序刚启动时，G1 还没有采集到什么足够的信息，这时候就处理初始的fully-young模式。当年轻代空间用满后，应用线程会被暂停，年轻代内存块中的存活对象被拷贝到存活区。如果还没有存活区，则任意选择一部分空闲的内存块作为存活区。
    - 拷贝的过程称为转移
  - 并发标记
    - ～
    - 类似CMS
    - 5个阶段
      - Initial Mark
      - Root Region Scan
      - Concurrent Mark
      - Remark
      - Cleanup
- 注意事项
  - 特别需要注意的是，某些情况下G1触发了Full GC，这时G1会退化使用Serial收集器来完成垃圾的清理工作，它仅仅使用单线程来完成GC工作，GC暂停时间将达到秒级别的
- 常见的GC组合（重点）
  - Serial + Serial Old实现单线程的低延迟垃圾回收机制
  - ParNew+CMS，实现多线程的低延迟垃圾回收机制
  - Parallel Scavenge和Parallel Scavenge Old，实现多线程的高吞吐量垃圾回收机制。
- GC如何选择
  - 选择正确的GC算法，唯一可行的方式就是去尝试，一般性的指导原则：
    - 如果系统考虑吞吐优先，CPU资源都用来最大程度处理业务，用Parallel GC
    - 如果系统考虑低延迟优先，每次GC时间尽量短，用CMS GC
    - 如果系统内存堆较大，同时希望整体来看平均GC时间可控，使用G1 GC
  - 对于内存大小的考量：
    - 一般4G以上，算是比较大，用G1的性价比较高
    - 一般超过8G，比如16H-64G内存，非常推荐使用G1 GC
- ZGC/Shenandoah GC
  - 算法几乎一摸一样，细节上有差异
- 