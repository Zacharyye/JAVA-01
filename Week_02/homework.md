课后作业

### GC 作业

**1. 使用GCLogAnalysis.java自己演练一遍串行/并行/CMS/G1案例 **

- 总结

  - 堆分配内存过小可能导致内存溢出或者频繁Full GC；堆内存分配过大，Full GC时间较长，也会影响到性能

- 运行环境

  - jdk1.8.0_231
  - macOS  Big Sur
  - MacBook Pro (13-inch, 2018, Four Thunderbolt 3 Ports)
  - 2.3 GHz 四核Intel Core i5
  - 8 GB 2133 MHz LPDDR3

- 直接运行程序  5s运行时间

  - **简要分析**：

  - ```
    java GCLogAnalysis
    正在执行...
    执行结束！共生成对象次数：77038
    
    java GCLogAnalysis
    正在执行...
    执行结束！共生成对象次数：83775
    
    java GCLogAnalysis
    正在执行...
    执行结束！共生成对象次数：82763
    ```

- 串行GC

  - **简要分析**：

  - ```
    java -Xmx4g -Xms4g -XX:+UseSerialGC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    正在执行...
    ~~
    2021-01-24T00:18:24.965-0800: [GC (Allocation Failure) 2021-01-24T00:18:24.965-0800: [DefNew: 1258303K->139776K(1258304K), 0.1651049 secs] 3072139K->2109318K(4054528K), 0.1651443 secs] [Times: user=0.09 sys=0.06, real=0.17 secs]
    执行结束！共生成对象次数：55065
    Heap
     def new generation   total 1258304K, used 184491K [0x00000006c0000000, 0x0000000715550000, 0x0000000715550000)
      eden space 1118528K,   3% used [0x00000006c0000000, 0x00000006c2baafc8, 0x0000000704450000)
      from space 139776K, 100% used [0x000000070ccd0000, 0x0000000715550000, 0x0000000715550000)
      to   space 139776K,   0% used [0x0000000704450000, 0x0000000704450000, 0x000000070ccd0000)
     tenured generation   total 2796224K, used 1969542K [0x0000000715550000, 0x00000007c0000000, 0x00000007c0000000)
       the space 2796224K,  70% used [0x0000000715550000, 0x000000078d8b1bf0, 0x000000078d8b1c00, 0x00000007c0000000)
     Metaspace       used 2583K, capacity 4486K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - ```
    java -Xmx2g -Xms2g -XX:+UseSerialGC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    正在执行...
    ~~
    2021-01-24T00:10:12.655-0800: [GC (Allocation Failure) 2021-01-24T00:10:12.655-0800: [DefNew: 629119K->69887K(629120K), 0.0310040 secs] 1313120K->882443K(2027264K), 0.0310427 secs] [Times: user=0.03 sys=0.00, real=0.03 secs]
    执行结束！共生成对象次数：65948
    Heap
     def new generation   total 629120K, used 240920K [0x0000000740000000, 0x000000076aaa0000, 0x000000076aaa0000)
      eden space 559232K,  30% used [0x0000000740000000, 0x000000074a706138, 0x0000000762220000)
      from space 69888K,  99% used [0x0000000762220000, 0x000000076665fff0, 0x0000000766660000)
      to   space 69888K,   0% used [0x0000000766660000, 0x0000000766660000, 0x000000076aaa0000)
     tenured generation   total 1398144K, used 812555K [0x000000076aaa0000, 0x00000007c0000000, 0x00000007c0000000)
       the space 1398144K,  58% used [0x000000076aaa0000, 0x000000079c422e70, 0x000000079c423000, 0x00000007c0000000)
     Metaspace       used 2590K, capacity 4490K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - ```
    java -Xmx1g -Xms1g -XX:+UseSerialGC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    正在执行...
    ~~
    2021-01-24T00:08:43.921-0800: [GC (Allocation Failure) 2021-01-24T00:08:43.921-0800: [DefNew: 314559K->34943K(314560K), 0.0210754 secs] 815372K->606542K(1013632K), 0.0211351 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
    执行结束！共生成对象次数：64702
    Heap
     def new generation   total 314560K, used 46204K [0x0000000780000000, 0x0000000795550000, 0x0000000795550000)
      eden space 279616K,   4% used [0x0000000780000000, 0x0000000780aff550, 0x0000000791110000)
      from space 34944K,  99% used [0x0000000793330000, 0x000000079554fd88, 0x0000000795550000)
      to   space 34944K,   0% used [0x0000000791110000, 0x0000000791110000, 0x0000000793330000)
     tenured generation   total 699072K, used 571599K [0x0000000795550000, 0x00000007c0000000, 0x00000007c0000000)
       the space 699072K,  81% used [0x0000000795550000, 0x00000007b8383d70, 0x00000007b8383e00, 0x00000007c0000000)
     Metaspace       used 2590K, capacity 4490K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - 先是Young GC；后期基本都是Full GC，虽然没有内存溢出，但是Full GC很频繁

    ```
    java -Xmx512m -Xms512m -XX:+UseSerialGC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    正在执行...
    ~~
    2021-01-24T00:04:04.832-0800: [Full GC (Allocation Failure) 2021-01-24T00:04:04.832-0800: [Tenured: 349532K->349526K(349568K), 0.0546442 secs] 506670K->380150K(506816K), [Metaspace: 2577K->2577K(1056768K)], 0.0546959 secs] [Times: user=0.06 sys=0.00, real=0.05 secs]
    执行结束！共生成对象次数：34118
    Heap
     def new generation   total 157248K, used 36603K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
      eden space 139776K,  26% used [0x00000007a0000000, 0x00000007a23bef00, 0x00000007a8880000)
      from space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)
      to   space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
     tenured generation   total 349568K, used 349526K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
       the space 349568K,  99% used [0x00000007aaaa0000, 0x00000007bfff5b78, 0x00000007bfff5c00, 0x00000007c0000000)
     Metaspace       used 2583K, capacity 4486K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - ```
    java -Xmx256m -Xms256m -XX:+UseSerialGC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    正在执行...
    ~~
    2021-01-24T00:01:05.823-0800: [Full GC (Allocation Failure) 2021-01-24T00:01:05.823-0800: [Tenured: 174769K->174153K(174784K), 0.0227100 secs] 252724K->252108K(253440K), [Metaspace: 2577K->2577K(1056768K)], 0.0227435 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:43)
    	at GCLogAnalysis.main(GCLogAnalysis.java:21)
    Heap
     def new generation   total 78656K, used 78008K [0x00000007b0000000, 0x00000007b5550000, 0x00000007b5550000)
      eden space 69952K, 100% used [0x00000007b0000000, 0x00000007b4450000, 0x00000007b4450000)
      from space 8704K,  92% used [0x00000007b4cd0000, 0x00000007b54ae110, 0x00000007b5550000)
      to   space 8704K,   0% used [0x00000007b4450000, 0x00000007b4450000, 0x00000007b4cd0000)
     tenured generation   total 174784K, used 174153K [0x00000007b5550000, 0x00000007c0000000, 0x00000007c0000000)
       the space 174784K,  99% used [0x00000007b5550000, 0x00000007bff62498, 0x00000007bff62600, 0x00000007c0000000)
     Metaspace       used 2607K, capacity 4486K, committed 4864K, reserved 1056768K
      class space    used 282K, capacity 386K, committed 512K, reserved 1048576K
    ```

- 并行GC

  - ```
    java -Xmx256m -Xms256m -XX:+UseParallelGC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    正在执行...
    ~~~
    2021-01-23T23:02:24.635-0800: [Full GC (Ergonomics) [PSYoungGen: 65244K->65244K(76288K)] [ParOldGen: 174902K->174884K(175104K)] 240146K->240128K(251392K), [Metaspace: 2577K->2577K(1056768K)], 0.0119203 secs] [Times: user=0.06 sys=0.00, real=0.01 secs]
    2021-01-23T23:02:24.647-0800: [Full GC (Allocation Failure) [PSYoungGen: 65244K->65244K(76288K)] [ParOldGen: 174884K->174865K(175104K)] 240128K->240109K(251392K), [Metaspace: 2577K->2577K(1056768K)], 0.0140957 secs] [Times: user=0.07 sys=0.00, real=0.02 secs]
    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:37)
    	at GCLogAnalysis.main(GCLogAnalysis.java:21)
    Heap
     PSYoungGen      total 76288K, used 65536K [0x00000007bab00000, 0x00000007c0000000, 0x00000007c0000000)
      eden space 65536K, 100% used [0x00000007bab00000,0x00000007beb00000,0x00000007beb00000)
      from space 10752K, 0% used [0x00000007beb00000,0x00000007beb00000,0x00000007bf580000)
      to   space 10752K, 0% used [0x00000007bf580000,0x00000007bf580000,0x00000007c0000000)
     ParOldGen       total 175104K, used 174865K [0x00000007b0000000, 0x00000007bab00000, 0x00000007bab00000)
      object space 175104K, 99% used [0x00000007b0000000,0x00000007baac45a8,0x00000007bab00000)
     Metaspace       used 2607K, capacity 4486K, committed 4864K, reserved 1056768K
      class space    used 282K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - ```
    java -Xmx512m -Xms512m -XX:+UseParallelGC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    正在执行...
    ~~~
    2021-01-23T22:54:29.765-0800: [Full GC (Ergonomics) [PSYoungGen: 131584K->12945K(153088K)] [ParOldGen: 349458K->348988K(349696K)] 481042K->361933K(502784K), [Metaspace: 2577K->2577K(1056768K)], 0.0447547 secs] [Times: user=0.23 sys=0.00, real=0.04 secs]
    执行结束！共生成对象次数：33367
    Heap
     PSYoungGen      total 153088K, used 78515K [0x00000007b5580000, 0x00000007c0000000, 0x00000007c0000000)
      eden space 131584K, 59% used [0x00000007b5580000,0x00000007ba22ce40,0x00000007bd600000)
      from space 21504K, 0% used [0x00000007bd600000,0x00000007bd600000,0x00000007beb00000)
      to   space 21504K, 0% used [0x00000007beb00000,0x00000007beb00000,0x00000007c0000000)
     ParOldGen       total 349696K, used 348988K [0x00000007a0000000, 0x00000007b5580000, 0x00000007b5580000)
      object space 349696K, 99% used [0x00000007a0000000,0x00000007b54cf320,0x00000007b5580000)
     Metaspace       used 2583K, capacity 4486K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - ```
    java -Xmx1g -Xms1g -XX:+UseParallelGC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    正在执行...
    ~~~
    2021-01-23T22:52:57.885-0800: [GC (Allocation Failure) [PSYoungGen: 262144K->43505K(305664K)] 643501K->458295K(1005056K), 0.0096273 secs] [Times: user=0.05 sys=0.01, real=0.01 secs]
    执行结束！共生成对象次数：67420
    Heap
     PSYoungGen      total 305664K, used 83243K [0x00000007aab00000, 0x00000007c0000000, 0x00000007c0000000)
      eden space 262144K, 15% used [0x00000007aab00000,0x00000007ad1ce8a0,0x00000007bab00000)
      from space 43520K, 99% used [0x00000007bd580000,0x00000007bfffc4e0,0x00000007c0000000)
      to   space 43520K, 0% used [0x00000007bab00000,0x00000007bab00000,0x00000007bd580000)
     ParOldGen       total 699392K, used 414790K [0x0000000780000000, 0x00000007aab00000, 0x00000007aab00000)
      object space 699392K, 59% used [0x0000000780000000,0x0000000799511a50,0x00000007aab00000)
     Metaspace       used 2590K, capacity 4490K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - ```
    java -Xmx2g -Xms2g -XX:+UseParallelGC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    正在执行...
    ~~
    2021-01-23T22:52:26.462-0800: [GC (Allocation Failure) [PSYoungGen: 611831K->87037K(611840K)] 1410524K->997834K(2010112K), 0.0224646 secs] [Times: user=0.15 sys=0.00, real=0.02 secs]
    执行结束！共生成对象次数：69518
    Heap
     PSYoungGen      total 611840K, used 173978K [0x0000000795580000, 0x00000007c0000000, 0x00000007c0000000)
      eden space 524800K, 16% used [0x0000000795580000,0x000000079aa673b8,0x00000007b5600000)
      from space 87040K, 99% used [0x00000007b5600000,0x00000007baaff6d8,0x00000007bab00000)
      to   space 87040K, 0% used [0x00000007bab00000,0x00000007bab00000,0x00000007c0000000)
     ParOldGen       total 1398272K, used 910797K [0x0000000740000000, 0x0000000795580000, 0x0000000795580000)
      object space 1398272K, 65% used [0x0000000740000000,0x0000000777973510,0x0000000795580000)
     Metaspace       used 2590K, capacity 4490K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - ```
    java -Xmx4g -Xms4g -XX:+UseParallelGC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    正在执行...
    ~~
    2021-01-23T22:42:23.581-0800: [GC (Allocation Failure) [PSYoungGen: 1223159K->174577K(1223168K)] 3023065K->2096774K(4019712K), 0.1402250 secs] [Times: user=0.20 sys=0.15, real=0.14 secs]
    执行结束！共生成对象次数：63440
    Heap
     PSYoungGen      total 1223168K, used 216907K [0x000000076ab00000, 0x00000007c0000000, 0x00000007c0000000)
      eden space 1048576K, 4% used [0x000000076ab00000,0x000000076d456ac0,0x00000007aab00000)
      from space 174592K, 99% used [0x00000007b5580000,0x00000007bfffc498,0x00000007c0000000)
      to   space 174592K, 0% used [0x00000007aab00000,0x00000007aab00000,0x00000007b5580000)
     ParOldGen       total 2796544K, used 1922197K [0x00000006c0000000, 0x000000076ab00000, 0x000000076ab00000)
      object space 2796544K, 68% used [0x00000006c0000000,0x00000007355256f0,0x000000076ab00000)
     Metaspace       used 2590K, capacity 4490K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

- CMS GC

  - ```
    java -Xmx4g -Xms4g -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    Java HotSpot(TM) 64-Bit Server VM warning: disabling UseAdaptiveSizePolicy; it is incompatible with UseConcMarkSweepGC.
    正在执行...
    ~~
    执行结束！共生成对象次数：53572
    Heap
     par new generation   total 613440K, used 90000K [0x00000006c0000000, 0x00000006e9990000, 0x00000006e9990000)
      eden space 545344K,   4% used [0x00000006c0000000, 0x00000006c15642d8, 0x00000006e1490000)
      from space 68096K,  99% used [0x00000006e1490000, 0x00000006e570ffc0, 0x00000006e5710000)
      to   space 68096K,   0% used [0x00000006e5710000, 0x00000006e5710000, 0x00000006e9990000)
     concurrent mark-sweep generation total 3512768K, used 1668529K [0x00000006e9990000, 0x00000007c0000000, 0x00000007c0000000)
     Metaspace       used 2583K, capacity 4486K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - ```
    java -Xmx2g -Xms2g -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    ~~
    2021-01-23T16:07:36.024-0800: [GC (Allocation Failure) 2021-01-23T16:07:36.024-0800: [ParNew: 613439K->68095K(613440K), 0.0307376 secs] 1297232K->874872K(2029056K), 0.0308178 secs] [Times: user=0.18 sys=0.00, real=0.03 secs]
    2021-01-23T16:07:36.055-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 806777K(1415616K)] 874944K(2029056K), 0.0001560 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    2021-01-23T16:07:36.056-0800: [CMS-concurrent-mark-start]
    2021-01-23T16:07:36.059-0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
    2021-01-23T16:07:36.059-0800: [CMS-concurrent-preclean-start]
    2021-01-23T16:07:36.061-0800: [CMS-concurrent-preclean: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
    2021-01-23T16:07:36.061-0800: [CMS-concurrent-abortable-preclean-start]
    2021-01-23T16:07:36.129-0800: [GC (Allocation Failure) 2021-01-23T16:07:36.129-0800: [ParNew: 613439K->68095K(613440K), 0.0316079 secs] 1420216K->1001660K(2029056K), 0.0316920 secs] [Times: user=0.19 sys=0.00, real=0.04 secs]
    执行结束！共生成对象次数：71566
    Heap
     par new generation   total 613440K, used 463412K [0x0000000740000000, 0x0000000769990000, 0x0000000769990000)
      eden space 545344K,  72% used [0x0000000740000000, 0x000000075820d3f8, 0x0000000761490000)
      from space 68096K,  99% used [0x0000000761490000, 0x000000076570fe78, 0x0000000765710000)
      to   space 68096K,   0% used [0x0000000765710000, 0x0000000765710000, 0x0000000769990000)
     concurrent mark-sweep generation total 1415616K, used 933564K [0x0000000769990000, 0x00000007c0000000, 0x00000007c0000000)
     Metaspace       used 2590K, capacity 4490K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - ```
    java -Xmx1g -Xms1g -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    
    2021-01-23T16:05:24.960-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 504931K(699072K)] 540284K(1013632K), 0.0002718 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    2021-01-23T16:05:24.960-0800: [CMS-concurrent-mark-start]
    2021-01-23T16:05:24.962-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
    2021-01-23T16:05:24.962-0800: [CMS-concurrent-preclean-start]
    2021-01-23T16:05:24.964-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    2021-01-23T16:05:24.964-0800: [CMS-concurrent-abortable-preclean-start]
    2021-01-23T16:05:24.998-0800: [GC (Allocation Failure) 2021-01-23T16:05:24.998-0800: [ParNew: 314558K->34942K(314560K), 0.0208422 secs] 819490K->616935K(1013632K), 0.0208951 secs] [Times: user=0.13 sys=0.00, real=0.02 secs]
    2021-01-23T16:05:25.055-0800: [GC (Allocation Failure) 2021-01-23T16:05:25.055-0800: [ParNew: 314558K->34942K(314560K), 0.0181161 secs] 896551K->691994K(1013632K), 0.0181819 secs] [Times: user=0.10 sys=0.01, real=0.02 secs]
    2021-01-23T16:05:25.075-0800: [CMS-concurrent-abortable-preclean: 0.007/0.111 secs] [Times: user=0.31 sys=0.01, real=0.11 secs]
    2021-01-23T16:05:25.075-0800: [GC (CMS Final Remark) [YG occupancy: 52674 K (314560 K)]2021-01-23T16:05:25.075-0800: [Rescan (parallel) , 0.0011280 secs]2021-01-23T16:05:25.076-0800: [weak refs processing, 0.0000124 secs]2021-01-23T16:05:25.076-0800: [class unloading, 0.0003017 secs]2021-01-23T16:05:25.077-0800: [scrub symbol table, 0.0003499 secs]2021-01-23T16:05:25.077-0800: [scrub string table, 0.0002570 secs][1 CMS-remark: 657051K(699072K)] 709726K(1013632K), 0.0021829 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
    2021-01-23T16:05:25.077-0800: [CMS-concurrent-sweep-start]
    2021-01-23T16:05:25.079-0800: [CMS-concurrent-sweep: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    2021-01-23T16:05:25.079-0800: [CMS-concurrent-reset-start]
    2021-01-23T16:05:25.080-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
    2021-01-23T16:05:25.114-0800: [GC (Allocation Failure) 2021-01-23T16:05:25.114-0800: [ParNew: 314558K->34943K(314560K), 0.0218105 secs] 816022K->610416K(1013632K), 0.0218706 secs] [Times: user=0.14 sys=0.00, real=0.02 secs]
    2021-01-23T16:05:25.136-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 575472K(699072K)] 610488K(1013632K), 0.0001630 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    2021-01-23T16:05:25.137-0800: [CMS-concurrent-mark-start]
    2021-01-23T16:05:25.138-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
    2021-01-23T16:05:25.138-0800: [CMS-concurrent-preclean-start]
    2021-01-23T16:05:25.139-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
    2021-01-23T16:05:25.140-0800: [CMS-concurrent-abortable-preclean-start]
    2021-01-23T16:05:25.171-0800: [GC (Allocation Failure) 2021-01-23T16:05:25.171-0800: [ParNew: 314559K->34943K(314560K), 0.0170110 secs] 890032K->682231K(1013632K), 0.0170782 secs] [Times: user=0.10 sys=0.00, real=0.01 secs]
    2021-01-23T16:05:25.229-0800: [GC (Allocation Failure) 2021-01-23T16:05:25.229-0800: [ParNew: 314559K->314559K(314560K), 0.0000217 secs]2021-01-23T16:05:25.230-0800: [CMS2021-01-23T16:05:25.230-0800: [CMS-concurrent-abortable-preclean: 0.003/0.090 secs] [Times: user=0.18 sys=0.00, real=0.09 secs]
     (concurrent mode failure): 647287K->370516K(699072K), 0.0683508 secs] 961847K->370516K(1013632K), [Metaspace: 2584K->2584K(1056768K)], 0.0684641 secs] [Times: user=0.06 sys=0.00, real=0.07 secs]
    2021-01-23T16:05:25.334-0800: [GC (Allocation Failure) 2021-01-23T16:05:25.334-0800: [ParNew: 279025K->34943K(314560K), 0.0171653 secs] 649542K->460802K(1013632K), 0.0172502 secs] [Times: user=0.10 sys=0.00, real=0.02 secs]
    执行结束！共生成对象次数：75971
    Heap
     par new generation   total 314560K, used 46831K [0x0000000780000000, 0x0000000795550000, 0x0000000795550000)
      eden space 279616K,   4% used [0x0000000780000000, 0x0000000780b9be68, 0x0000000791110000)
      from space 34944K,  99% used [0x0000000791110000, 0x000000079332fe48, 0x0000000793330000)
      to   space 34944K,   0% used [0x0000000793330000, 0x0000000793330000, 0x0000000795550000)
     concurrent mark-sweep generation total 699072K, used 425858K [0x0000000795550000, 0x00000007c0000000, 0x00000007c0000000)
     Metaspace       used 2590K, capacity 4490K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - ```
    java -Xmx521m -Xms512m -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    ~~
    2021-01-23T16:04:01.509-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 356934K(357056K)] 386848K(516800K), 0.0001873 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    2021-01-23T16:04:01.509-0800: [CMS-concurrent-mark-start]
    2021-01-23T16:04:01.511-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
    2021-01-23T16:04:01.511-0800: [CMS-concurrent-preclean-start]
    2021-01-23T16:04:01.513-0800: [CMS-concurrent-preclean: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
    2021-01-23T16:04:01.513-0800: [CMS-concurrent-abortable-preclean-start]
    2021-01-23T16:04:01.513-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    2021-01-23T16:04:01.513-0800: [GC (CMS Final Remark) [YG occupancy: 47721 K (159744 K)]2021-01-23T16:04:01.513-0800: [Rescan (parallel) , 0.0011141 secs]2021-01-23T16:04:01.514-0800: [weak refs processing, 0.0000196 secs]2021-01-23T16:04:01.514-0800: [class unloading, 0.0004030 secs]2021-01-23T16:04:01.514-0800: [scrub symbol table, 0.0003923 secs]2021-01-23T16:04:01.515-0800: [scrub string table, 0.0002645 secs][1 CMS-remark: 356934K(357056K)] 404655K(516800K), 0.0022835 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    2021-01-23T16:04:01.515-0800: [CMS-concurrent-sweep-start]
    2021-01-23T16:04:01.516-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
    2021-01-23T16:04:01.516-0800: [CMS-concurrent-reset-start]
    2021-01-23T16:04:01.516-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    2021-01-23T16:04:01.531-0800: [GC (Allocation Failure) 2021-01-23T16:04:01.531-0800: [ParNew: 159509K->159509K(159744K), 0.0000219 secs]2021-01-23T16:04:01.531-0800: [CMS: 356654K->357037K(357056K), 0.0603419 secs] 516164K->387509K(516800K), [Metaspace: 2577K->2577K(1056768K)], 0.0604232 secs] [Times: user=0.06 sys=0.00, real=0.06 secs]
    2021-01-23T16:04:01.592-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 357037K(357056K)] 388171K(516800K), 0.0002744 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
    2021-01-23T16:04:01.592-0800: [CMS-concurrent-mark-start]
    执行结束！共生成对象次数：34732
    Heap
     par new generation   total 159744K, used 36545K [0x000000079f600000, 0x00000007aa350000, 0x00000007aa350000)
      eden space 142016K,  25% used [0x000000079f600000, 0x00000007a19b0790, 0x00000007a80b0000)
      from space 17728K,   0% used [0x00000007a80b0000, 0x00000007a80b0000, 0x00000007a9200000)
      to   space 17728K,   0% used [0x00000007a9200000, 0x00000007a9200000, 0x00000007aa350000)
     concurrent mark-sweep generation total 357056K, used 357037K [0x00000007aa350000, 0x00000007c0000000, 0x00000007c0000000)
     Metaspace       used 2583K, capacity 4486K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - 内存过小，最终Full GC也无法回收掉更多内存，无法提供内存存储对象，导致溢出

    ```
    java -Xmx256m -Xms256m -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    Java HotSpot(TM) 64-Bit Server VM warning: disabling UseAdaptiveSizePolicy; it is incompatible with UseConcMarkSweepGC.
    正在执行...
    ~~
    2021-01-23T16:03:35.496-0800: [Full GC (Allocation Failure) 2021-01-23T16:03:35.496-0800: [CMS: 174510K->174491K(174784K), 0.0217484 secs] 252935K->252916K(253440K), [Metaspace: 2577K->2577K(1056768K)], 0.0217868 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]
    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:37)
    	at GCLogAnalysis.main(GCLogAnalysis.java:21)
    Heap
     par new generation   total 78656K, used 78441K [0x00000007b0000000, 0x00000007b5550000, 0x00000007b5550000)
      eden space 69952K, 100% used [0x00000007b0000000, 0x00000007b4450000, 0x00000007b4450000)
      from space 8704K,  97% used [0x00000007b4450000, 0x00000007b4c9a5b0, 0x00000007b4cd0000)
      to   space 8704K,   0% used [0x00000007b4cd0000, 0x00000007b4cd0000, 0x00000007b5550000)
     concurrent mark-sweep generation total 174784K, used 174491K [0x00000007b5550000, 0x00000007c0000000, 0x00000007c0000000)
     Metaspace       used 2608K, capacity 4486K, committed 4864K, reserved 1056768K
      class space    used 282K, capacity 386K, committed 512K, reserved 1048576K
    ```

- G1 GC

  - **简要分析** ：内存资源分配1g～2g时生成的对象数量明显较高；内存分配过小，会导致堆内存溢出或者频繁FullGC，导致STW时间过长；内存分配过大，也可能导致GC STW时间较长

  - ```
    java -Xmx256m -Xms256m -XX:+UseG1GC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    ~~
    2021-01-23T16:00:33.510-0800: [Full GC (Allocation Failure)  201M->262K(256M), 0.0018841 secs]
       [Eden: 0.0B(12.0M)->0.0B(153.0M) Survivors: 0.0B->0.0B Heap: 201.8M(256.0M)->262.6K(256.0M)], [Metaspace: 2577K->2577K(1056768K)]
     [Times: user=0.00 sys=0.00, real=0.00 secs]
    2021-01-23T16:00:33.511-0800: [GC concurrent-mark-abort]
    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:43)
    	at GCLogAnalysis.main(GCLogAnalysis.java:21)
    Heap
     garbage-first heap   total 262144K, used 262K [0x00000007b0000000, 0x00000007b0100800, 0x00000007c0000000)
      region size 1024K, 1 young (1024K), 0 survivors (0K)
     Metaspace       used 2608K, capacity 4486K, committed 4864K, reserved 1056768K
      class space    used 282K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - ```
    java -Xmx512m -Xms512m -XX:+UseG1GC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    
    ~~
    2021-01-23T15:59:56.485-0800: [GC pause (G1 Humongous Allocation) (young) (to-space exhausted), 0.0026648 secs]
       [Parallel Time: 1.5 ms, GC Workers: 8]
          [GC Worker Start (ms): Min: 5070.4, Avg: 5070.6, Max: 5071.3, Diff: 0.9]
          [Ext Root Scanning (ms): Min: 0.0, Avg: 0.2, Max: 0.7, Diff: 0.6, Sum: 1.3]
          [Update RS (ms): Min: 0.0, Avg: 0.5, Max: 0.7, Diff: 0.7, Sum: 4.3]
             [Processed Buffers: Min: 0, Avg: 7.2, Max: 11, Diff: 11, Sum: 58]
          [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
          [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
          [Object Copy (ms): Min: 0.0, Avg: 0.2, Max: 0.6, Diff: 0.6, Sum: 1.3]
          [Termination (ms): Min: 0.0, Avg: 0.5, Max: 0.6, Diff: 0.6, Sum: 3.6]
             [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 8]
          [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
          [GC Worker Total (ms): Min: 0.6, Avg: 1.3, Max: 1.5, Diff: 0.9, Sum: 10.6]
          [GC Worker End (ms): Min: 5071.9, Avg: 5071.9, Max: 5071.9, Diff: 0.0]
       [Code Root Fixup: 0.0 ms]
       [Code Root Purge: 0.0 ms]
       [Clear CT: 0.1 ms]
       [Other: 1.1 ms]
          [Evacuation Failure: 0.1 ms]
          [Choose CSet: 0.0 ms]
          [Ref Proc: 0.7 ms]
          [Ref Enq: 0.0 ms]
          [Redirty Cards: 0.1 ms]
          [Humongous Register: 0.1 ms]
          [Humongous Reclaim: 0.0 ms]
          [Free CSet: 0.0 ms]
       [Eden: 13.0M(24.0M)->0.0B(25.0M) Survivors: 1024.0K->0.0B Heap: 399.4M(512.0M)->393.2M(512.0M)]
     [Times: user=0.01 sys=0.00, real=0.00 secs]
    执行结束！共生成对象次数：19422
    Heap
     garbage-first heap   total 524288K, used 403242K [0x00000007a0000000, 0x00000007a0101000, 0x00000007c0000000)
      region size 1024K, 1 young (1024K), 0 survivors (0K)
     Metaspace       used 2583K, capacity 4486K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - ```
    java -Xmx1g -Xms1g -XX:+UseG1GC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    ~~
    2021-01-23T15:58:58.106-0800: [GC pause (G1 Evacuation Pause) (young), 0.0122115 secs]
       [Parallel Time: 10.8 ms, GC Workers: 8]
          [GC Worker Start (ms): Min: 5058.2, Avg: 5058.5, Max: 5059.2, Diff: 1.0]
          [Ext Root Scanning (ms): Min: 0.0, Avg: 0.1, Max: 0.4, Diff: 0.4, Sum: 1.2]
          [Update RS (ms): Min: 3.2, Avg: 3.8, Max: 4.0, Diff: 0.8, Sum: 30.0]
             [Processed Buffers: Min: 28, Avg: 48.1, Max: 57, Diff: 29, Sum: 385]
          [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.2]
          [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
          [Object Copy (ms): Min: 6.3, Avg: 6.4, Max: 6.4, Diff: 0.1, Sum: 50.8]
          [Termination (ms): Min: 0.0, Avg: 0.0, Max: 0.1, Diff: 0.1, Sum: 0.4]
             [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 8]
          [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
          [GC Worker Total (ms): Min: 9.6, Avg: 10.3, Max: 10.7, Diff: 1.1, Sum: 82.7]
          [GC Worker End (ms): Min: 5068.9, Avg: 5068.9, Max: 5068.9, Diff: 0.0]
       [Code Root Fixup: 0.0 ms]
       [Code Root Purge: 0.0 ms]
       [Clear CT: 0.1 ms]
       [Other: 1.4 ms]
          [Choose CSet: 0.0 ms]
          [Ref Proc: 0.8 ms]
          [Ref Enq: 0.0 ms]
          [Redirty Cards: 0.1 ms]
          [Humongous Register: 0.2 ms]
          [Humongous Reclaim: 0.1 ms]
          [Free CSet: 0.1 ms]
       [Eden: 174.0M(174.0M)->0.0B(28.0M) Survivors: 8192.0K->23.0M Heap: 869.1M(1024.0M)->706.7M(1024.0M)]
     [Times: user=0.08 sys=0.00, real=0.01 secs]
    执行结束！共生成对象次数：67056
    Heap
     garbage-first heap   total 1048576K, used 750039K [0x0000000780000000, 0x0000000780102000, 0x00000007c0000000)
      region size 1024K, 43 young (44032K), 23 survivors (23552K)
     Metaspace       used 2590K, capacity 4490K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - ```
    java -Xmx2g -Xms2g -XX:+UseG1GC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    ~~
    2021-01-23T15:56:27.422-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark), 0.0208924 secs]
       [Parallel Time: 18.6 ms, GC Workers: 8]
          [GC Worker Start (ms): Min: 5053.2, Avg: 5053.3, Max: 5053.3, Diff: 0.1]
          [Ext Root Scanning (ms): Min: 0.1, Avg: 0.1, Max: 0.3, Diff: 0.2, Sum: 1.0]
          [Update RS (ms): Min: 3.7, Avg: 3.9, Max: 3.9, Diff: 0.2, Sum: 31.2]
             [Processed Buffers: Min: 40, Avg: 51.8, Max: 56, Diff: 16, Sum: 414]
          [Scan RS (ms): Min: 0.1, Avg: 0.1, Max: 0.1, Diff: 0.0, Sum: 0.6]
          [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
          [Object Copy (ms): Min: 13.3, Avg: 13.6, Max: 14.2, Diff: 0.9, Sum: 109.0]
          [Termination (ms): Min: 0.0, Avg: 0.7, Max: 1.0, Diff: 1.0, Sum: 5.2]
             [Termination Attempts: Min: 1, Avg: 1.2, Max: 2, Diff: 1, Sum: 10]
          [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.2]
          [GC Worker Total (ms): Min: 18.3, Avg: 18.4, Max: 18.5, Diff: 0.2, Sum: 147.3]
          [GC Worker End (ms): Min: 5071.6, Avg: 5071.7, Max: 5071.7, Diff: 0.1]
       [Code Root Fixup: 0.0 ms]
       [Code Root Purge: 0.0 ms]
       [Clear CT: 0.2 ms]
       [Other: 2.1 ms]
          [Choose CSet: 0.0 ms]
          [Ref Proc: 0.9 ms]
          [Ref Enq: 0.0 ms]
          [Redirty Cards: 0.2 ms]
          [Humongous Register: 0.2 ms]
          [Humongous Reclaim: 0.2 ms]
          [Free CSet: 0.2 ms]
       [Eden: 687.0M(971.0M)->0.0B(839.0M) Survivors: 13.0M->123.0M Heap: 1458.3M(2048.0M)->746.3M(2048.0M)]
     [Times: user=0.13 sys=0.00, real=0.02 secs]
    2021-01-23T15:56:27.443-0800: [GC concurrent-root-region-scan-start]
    2021-01-23T15:56:27.443-0800: [GC concurrent-root-region-scan-end, 0.0002213 secs]
    2021-01-23T15:56:27.443-0800: [GC concurrent-mark-start]
    2021-01-23T15:56:27.445-0800: [GC concurrent-mark-end, 0.0017875 secs]
    2021-01-23T15:56:27.445-0800: [GC remark 2021-01-23T15:56:27.445-0800: [Finalize Marking, 0.0008578 secs] 2021-01-23T15:56:27.446-0800: [GC ref-proc, 0.0000658 secs] 2021-01-23T15:56:27.446-0800: [Unloading, 0.0005223 secs], 0.0024646 secs]
     [Times: user=0.01 sys=0.00, real=0.00 secs]
    2021-01-23T15:56:27.448-0800: [GC cleanup 755M->641M(2048M), 0.0015630 secs]
     [Times: user=0.01 sys=0.01, real=0.00 secs]
    2021-01-23T15:56:27.449-0800: [GC concurrent-cleanup-start]
    2021-01-23T15:56:27.449-0800: [GC concurrent-cleanup-end, 0.0000805 secs]
    执行结束！共生成对象次数：76583
    Heap
     garbage-first heap   total 2097152K, used 683767K [0x0000000740000000, 0x0000000740104000, 0x00000007c0000000)
      region size 1024K, 152 young (155648K), 123 survivors (125952K)
     Metaspace       used 2590K, capacity 4490K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

  - ```
    java -Xmx4g -Xms4g -XX:+UseG1GC -XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps GCLogAnalysis
    
    ~~
    2021-01-23T15:54:11.504-0800: [GC pause (G1 Evacuation Pause) (young), 0.0960838 secs]
       [Parallel Time: 94.6 ms, GC Workers: 8]
          [GC Worker Start (ms): Min: 4891.1, Avg: 4891.2, Max: 4891.3, Diff: 0.2]
          [Ext Root Scanning (ms): Min: 0.0, Avg: 0.1, Max: 0.2, Diff: 0.2, Sum: 0.8]
          [Update RS (ms): Min: 0.1, Avg: 0.1, Max: 0.3, Diff: 0.2, Sum: 1.0]
             [Processed Buffers: Min: 0, Avg: 1.1, Max: 2, Diff: 2, Sum: 9]
          [Scan RS (ms): Min: 0.0, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.5]
          [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
          [Object Copy (ms): Min: 93.5, Avg: 93.7, Max: 94.0, Diff: 0.6, Sum: 749.7]
          [Termination (ms): Min: 0.0, Avg: 0.4, Max: 0.6, Diff: 0.6, Sum: 2.8]
             [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 8]
          [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
          [GC Worker Total (ms): Min: 94.3, Avg: 94.4, Max: 94.5, Diff: 0.3, Sum: 755.0]
          [GC Worker End (ms): Min: 4985.6, Avg: 4985.6, Max: 4985.7, Diff: 0.1]
       [Code Root Fixup: 0.0 ms]
       [Code Root Purge: 0.0 ms]
       [Clear CT: 0.2 ms]
       [Other: 1.3 ms]
          [Choose CSet: 0.0 ms]
          [Ref Proc: 0.6 ms]
          [Ref Enq: 0.0 ms]
          [Redirty Cards: 0.1 ms]
          [Humongous Register: 0.1 ms]
          [Humongous Reclaim: 0.0 ms]
          [Free CSet: 0.3 ms]
       [Eden: 1074.0M(1074.0M)->0.0B(1440.0M) Survivors: 178.0M->158.0M Heap: 2132.5M(4096.0M)->1195.9M(4096.0M)]
     [Times: user=0.12 sys=0.44, real=0.10 secs]
    执行结束！共生成对象次数：53945
    Heap
     garbage-first heap   total 4194304K, used 2432932K [0x00000006c0000000, 0x00000006c0204000, 0x00000007c0000000)
      region size 2048K, 670 young (1372160K), 79 survivors (161792K)
     Metaspace       used 2583K, capacity 4486K, committed 4864K, reserved 1056768K
      class space    used 279K, capacity 386K, committed 512K, reserved 1048576K
    ```

2.wrk压测

- 2个线程，10个用户，运行10秒，一共163043次请求，QPS为16286.59，这期间一共进行了5次GC，耗时最长为75ms

  ```
  wrk -c 10 -d 10s http://localhost:8088/api/hello                                                     zachary@zhouyindeMBP
  Running 10s test @ http://localhost:8088/api/hello
    2 threads and 10 connections
    Thread Stats   Avg      Stdev     Max   +/- Stdev
      Latency     5.50ms   26.59ms 297.60ms   96.52%
      Req/Sec     8.36k     3.28k   16.24k    63.78%
    163043 requests in 10.01s, 19.47MB read
  Requests/sec:  16286.59
  Transfer/sec:      1.94MB
  
  2021-01-24T00:49:19.423-0800: [GC pause (Metadata GC Threshold) (young) (initial-mark), 0.0697270 secs]
     [Parallel Time: 52.8 ms, GC Workers: 8]
        [GC Worker Start (ms): Min: 643835.4, Avg: 643835.6, Max: 643835.7, Diff: 0.3]
        [Ext Root Scanning (ms): Min: 3.4, Avg: 4.6, Max: 7.8, Diff: 4.4, Sum: 36.9]
        [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
           [Processed Buffers: Min: 0, Avg: 0.0, Max: 0, Diff: 0, Sum: 0]
        [Scan RS (ms): Min: 0.0, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.5]
        [Code Root Scanning (ms): Min: 0.0, Avg: 1.2, Max: 2.8, Diff: 2.8, Sum: 9.4]
        [Object Copy (ms): Min: 43.6, Avg: 46.0, Max: 47.8, Diff: 4.1, Sum: 368.2]
        [Termination (ms): Min: 0.0, Avg: 0.4, Max: 0.6, Diff: 0.6, Sum: 3.4]
           [Termination Attempts: Min: 1, Avg: 13.6, Max: 22, Diff: 21, Sum: 109]
        [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.1, Diff: 0.1, Sum: 0.3]
        [GC Worker Total (ms): Min: 52.2, Avg: 52.3, Max: 52.5, Diff: 0.3, Sum: 418.7]
        [GC Worker End (ms): Min: 643887.9, Avg: 643887.9, Max: 643887.9, Diff: 0.0]
     [Code Root Fixup: 0.3 ms]
     [Code Root Purge: 0.0 ms]
     [Clear CT: 0.2 ms]
     [Other: 16.4 ms]
        [Choose CSet: 0.0 ms]
        [Ref Proc: 12.1 ms]
        [Ref Enq: 0.0 ms]
        [Redirty Cards: 0.2 ms]
        [Humongous Register: 0.0 ms]
        [Humongous Reclaim: 0.0 ms]
        [Free CSet: 1.4 ms]
     [Eden: 430.0M(733.0M)->0.0B(579.0M) Survivors: 9216.0K->27.0M Heap: 439.0M(2048.0M)->26.5M(2048.0M)]
   [Times: user=0.10 sys=0.13, real=0.07 secs]
  2021-01-24T00:49:19.493-0800: [GC concurrent-root-region-scan-start]
  2021-01-24T00:49:19.511-0800: [GC concurrent-root-region-scan-end, 0.0183505 secs]
  2021-01-24T00:49:19.512-0800: [GC concurrent-mark-start]
  2021-01-24T00:49:19.514-0800: [GC concurrent-mark-end, 0.0023262 secs]
  2021-01-24T00:49:19.514-0800: [GC remark 2021-01-24T00:49:19.514-0800: [Finalize Marking, 0.0007977 secs] 2021-01-24T00:49:19.515-0800: [GC ref-proc, 0.0001464 secs] 2021-01-24T00:49:19.515-0800: [Unloading, 0.0107823 secs], 0.0120148 secs]
   [Times: user=0.03 sys=0.02, real=0.01 secs]
  2021-01-24T00:49:19.526-0800: [GC cleanup 29M->29M(2048M), 0.0017399 secs]
   [Times: user=0.00 sys=0.01, real=0.00 secs]
  2021-01-24T00:49:21.884-0800: [GC pause (G1 Evacuation Pause) (young), 0.0312403 secs]
     [Parallel Time: 27.5 ms, GC Workers: 8]
        [GC Worker Start (ms): Min: 646293.6, Avg: 646293.6, Max: 646293.7, Diff: 0.2]
        [Ext Root Scanning (ms): Min: 0.3, Avg: 0.9, Max: 4.5, Diff: 4.2, Sum: 7.6]
        [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
           [Processed Buffers: Min: 0, Avg: 0.0, Max: 0, Diff: 0, Sum: 0]
        [Scan RS (ms): Min: 0.0, Avg: 0.2, Max: 0.4, Diff: 0.4, Sum: 1.2]
        [Code Root Scanning (ms): Min: 0.0, Avg: 1.5, Max: 3.9, Diff: 3.9, Sum: 12.4]
        [Object Copy (ms): Min: 13.8, Avg: 15.9, Max: 17.8, Diff: 4.0, Sum: 127.5]
        [Termination (ms): Min: 0.0, Avg: 6.7, Max: 8.9, Diff: 8.9, Sum: 53.4]
           [Termination Attempts: Min: 1, Avg: 50.4, Max: 77, Diff: 76, Sum: 403]
        [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.2]
        [GC Worker Total (ms): Min: 19.0, Avg: 25.3, Max: 27.4, Diff: 8.4, Sum: 202.2]
        [GC Worker End (ms): Min: 646312.7, Avg: 646318.9, Max: 646321.0, Diff: 8.3]
     [Code Root Fixup: 0.3 ms]
     [Code Root Purge: 0.1 ms]
     [Clear CT: 0.2 ms]
     [Other: 3.1 ms]
        [Choose CSet: 0.0 ms]
        [Ref Proc: 0.8 ms]
        [Ref Enq: 0.0 ms]
        [Redirty Cards: 0.1 ms]
        [Humongous Register: 0.1 ms]
        [Humongous Reclaim: 0.0 ms]
        [Free CSet: 1.7 ms]
     [Eden: 579.0M(579.0M)->0.0B(654.0M) Survivors: 27.0M->21.0M Heap: 605.5M(2048.0M)->20.5M(2048.0M)]
   [Times: user=0.11 sys=0.01, real=0.03 secs]
  2021-01-24T00:49:23.153-0800: [GC pause (G1 Evacuation Pause) (young), 0.0266185 secs]
     [Parallel Time: 22.7 ms, GC Workers: 8]
        [GC Worker Start (ms): Min: 647562.6, Avg: 647562.7, Max: 647562.7, Diff: 0.1]
        [Ext Root Scanning (ms): Min: 0.4, Avg: 1.1, Max: 4.9, Diff: 4.5, Sum: 8.6]
        [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
           [Processed Buffers: Min: 0, Avg: 0.0, Max: 0, Diff: 0, Sum: 0]
        [Scan RS (ms): Min: 0.0, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.8]
        [Code Root Scanning (ms): Min: 0.0, Avg: 1.2, Max: 2.6, Diff: 2.6, Sum: 10.0]
        [Object Copy (ms): Min: 16.1, Avg: 18.8, Max: 20.9, Diff: 4.8, Sum: 150.6]
        [Termination (ms): Min: 0.0, Avg: 0.7, Max: 1.5, Diff: 1.5, Sum: 5.8]
           [Termination Attempts: Min: 1, Avg: 60.2, Max: 96, Diff: 95, Sum: 482]
        [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
        [GC Worker Total (ms): Min: 21.8, Avg: 22.0, Max: 22.5, Diff: 0.7, Sum: 175.8]
        [GC Worker End (ms): Min: 647584.5, Avg: 647584.6, Max: 647585.2, Diff: 0.7]
     [Code Root Fixup: 0.7 ms]
     [Code Root Purge: 0.0 ms]
     [Clear CT: 0.2 ms]
     [Other: 2.9 ms]
        [Choose CSet: 0.0 ms]
        [Ref Proc: 1.4 ms]
        [Ref Enq: 0.0 ms]
        [Redirty Cards: 0.1 ms]
        [Humongous Register: 0.2 ms]
        [Humongous Reclaim: 0.0 ms]
        [Free CSet: 0.9 ms]
     [Eden: 654.0M(654.0M)->0.0B(1208.0M) Survivors: 21.0M->20.0M Heap: 674.5M(2048.0M)->19.5M(2048.0M)]
   [Times: user=0.12 sys=0.02, real=0.03 secs]
  2021-01-24T00:49:25.702-0800: [GC pause (G1 Evacuation Pause) (young), 0.0757752 secs]
     [Parallel Time: 60.5 ms, GC Workers: 8]
        [GC Worker Start (ms): Min: 650111.9, Avg: 650111.9, Max: 650112.1, Diff: 0.2]
        [Ext Root Scanning (ms): Min: 1.4, Avg: 4.8, Max: 26.7, Diff: 25.3, Sum: 38.3]
        [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
           [Processed Buffers: Min: 0, Avg: 0.0, Max: 0, Diff: 0, Sum: 0]
        [Scan RS (ms): Min: 0.1, Avg: 0.2, Max: 0.3, Diff: 0.2, Sum: 1.4]
        [Code Root Scanning (ms): Min: 0.0, Avg: 8.9, Max: 21.5, Diff: 21.5, Sum: 71.3]
        [Object Copy (ms): Min: 33.3, Avg: 45.9, Max: 58.2, Diff: 24.9, Sum: 367.5]
        [Termination (ms): Min: 0.0, Avg: 0.4, Max: 0.6, Diff: 0.6, Sum: 3.2]
           [Termination Attempts: Min: 1, Avg: 38.0, Max: 53, Diff: 52, Sum: 304]
        [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.2, Diff: 0.2, Sum: 0.4]
        [GC Worker Total (ms): Min: 60.2, Avg: 60.3, Max: 60.4, Diff: 0.2, Sum: 482.1]
        [GC Worker End (ms): Min: 650172.1, Avg: 650172.2, Max: 650172.3, Diff: 0.2]
     [Code Root Fixup: 0.4 ms]
     [Code Root Purge: 0.0 ms]
     [Clear CT: 0.6 ms]
     [Other: 14.2 ms]
        [Choose CSet: 0.0 ms]
        [Ref Proc: 11.2 ms]
        [Ref Enq: 0.0 ms]
        [Redirty Cards: 0.1 ms]
        [Humongous Register: 0.1 ms]
        [Humongous Reclaim: 0.0 ms]
        [Free CSet: 2.3 ms]
     [Eden: 1208.0M(1208.0M)->0.0B(1206.0M) Survivors: 20.0M->22.0M Heap: 1227.5M(2048.0M)->21.5M(2048.0M)]
   [Times: user=0.15 sys=0.14, real=0.07 secs]
  2021-01-24T00:49:27.971-0800: [GC pause (G1 Evacuation Pause) (young), 0.0166742 secs]
     [Parallel Time: 13.2 ms, GC Workers: 8]
        [GC Worker Start (ms): Min: 652380.7, Avg: 652380.8, Max: 652380.8, Diff: 0.2]
        [Ext Root Scanning (ms): Min: 0.3, Avg: 0.9, Max: 3.3, Diff: 3.0, Sum: 7.0]
        [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
           [Processed Buffers: Min: 0, Avg: 0.0, Max: 0, Diff: 0, Sum: 0]
        [Scan RS (ms): Min: 0.1, Avg: 0.2, Max: 0.2, Diff: 0.2, Sum: 1.3]
        [Code Root Scanning (ms): Min: 0.0, Avg: 1.5, Max: 4.1, Diff: 4.1, Sum: 12.2]
        [Object Copy (ms): Min: 8.2, Avg: 10.3, Max: 12.3, Diff: 4.1, Sum: 82.6]
        [Termination (ms): Min: 0.0, Avg: 0.0, Max: 0.1, Diff: 0.1, Sum: 0.3]
           [Termination Attempts: Min: 1, Avg: 62.6, Max: 90, Diff: 89, Sum: 501]
        [GC Worker Other (ms): Min: 0.0, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.5]
        [GC Worker Total (ms): Min: 12.9, Avg: 13.0, Max: 13.1, Diff: 0.2, Sum: 103.9]
        [GC Worker End (ms): Min: 652393.7, Avg: 652393.7, Max: 652393.8, Diff: 0.1]
     [Code Root Fixup: 0.2 ms]
     [Code Root Purge: 0.0 ms]
     [Clear CT: 0.9 ms]
     [Other: 2.3 ms]
        [Choose CSet: 0.0 ms]
        [Ref Proc: 1.1 ms]
        [Ref Enq: 0.0 ms]
        [Redirty Cards: 0.1 ms]
        [Humongous Register: 0.1 ms]
        [Humongous Reclaim: 0.0 ms]
        [Free CSet: 0.8 ms]
     [Eden: 1206.0M(1206.0M)->0.0B(1208.0M) Survivors: 22.0M->20.0M Heap: 1227.5M(2048.0M)->20.0M(2048.0M)]
   [Times: user=0.10 sys=0.01, real=0.01 secs]
  ^CHeap
   garbage-first heap   total 2097152K, used 868351K [0x0000000740000000, 0x0000000740104000, 0x00000007c0000000)
    region size 1024K, 849 young (869376K), 20 survivors (20480K)
   Metaspace       used 36586K, capacity 38514K, committed 38704K, reserved 1083392K
    class space    used 4565K, capacity 4902K, committed 4912K, reserved 1048576K
  
  ```

- 