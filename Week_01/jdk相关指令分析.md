## JDK 11

### G1 GC

```
jhsdb jmap --heap --pid 7980

Attaching to process ID 7980, please wait...
Debugger attached successfully.
Server compiler detected.
JVM version is 11.0.1+13-LTS

using thread-local object allocation.
Garbage-First (G1) GC with 8 thread(s)

Heap Configuration:
   MinHeapFreeRatio         = 40
   MaxHeapFreeRatio         = 70
   MaxHeapSize              = 2147483648 (2048.0MB)
   NewSize                  = 1363144 (1.2999954223632812MB)
   MaxNewSize               = 1287651328 (1228.0MB)
   OldSize                  = 5452592 (5.1999969482421875MB)
   NewRatio                 = 2
   SurvivorRatio            = 8
   MetaspaceSize            = 21807104 (20.796875MB)
   CompressedClassSpaceSize = 1073741824 (1024.0MB)
   MaxMetaspaceSize         = 17592186044415 MB
   G1HeapRegionSize         = 1048576 (1.0MB)

Heap Usage:
G1 Heap:
   regions  = 2048
   capacity = 2147483648 (2048.0MB)
   used     = 74417152 (70.9697265625MB)
   free     = 2073066496 (1977.0302734375MB)
   3.4653186798095703% used
G1 Young Generation:
Eden Space:
   regions  = 53
   capacity = 89128960 (85.0MB)
   used     = 55574528 (53.0MB)
   free     = 33554432 (32.0MB)
   62.35294117647059% used
Survivor Space:
   regions  = 12
   capacity = 12582912 (12.0MB)
   used     = 12582912 (12.0MB)
   free     = 0 (0.0MB)
   100.0% used
G1 Old Generation:
   regions  = 6
   capacity = 59768832 (57.0MB)
   used     = 6259712 (5.9697265625MB)
   free     = 53509120 (51.0302734375MB)
   10.473204495614034% used
```

### Parallel GC

```
jhsdb jmap --heap --pid 8687                                                                1 ↵ zachary@zhouyindeMacBook-Pro
Attaching to process ID 8687, please wait...
Debugger attached successfully.
Server compiler detected.
JVM version is 11.0.1+13-LTS

using thread-local object allocation.
Parallel GC with 8 thread(s)

Heap Configuration:
   MinHeapFreeRatio         = 0
   MaxHeapFreeRatio         = 100
   MaxHeapSize              = 2147483648 (2048.0MB)
   NewSize                  = 44564480 (42.5MB)
   MaxNewSize               = 715653120 (682.5MB)
   OldSize                  = 89653248 (85.5MB)
   NewRatio                 = 2
   SurvivorRatio            = 8
   MetaspaceSize            = 21807104 (20.796875MB)
   CompressedClassSpaceSize = 1073741824 (1024.0MB)
   MaxMetaspaceSize         = 17592186044415 MB
   G1HeapRegionSize         = 0 (0.0MB)

Heap Usage:
PS Young Generation
Eden Space:
   capacity = 133169152 (127.0MB)
   used     = 17281832 (16.481239318847656MB)
   free     = 115887320 (110.51876068115234MB)
   12.977353794368232% used
From Space:
   capacity = 6815744 (6.5MB)
   used     = 6800752 (6.4857025146484375MB)
   free     = 14992 (0.0142974853515625MB)
   99.78003868689903% used
To Space:
   capacity = 9961472 (9.5MB)
   used     = 0 (0.0MB)
   free     = 9961472 (9.5MB)
   0.0% used
PS Old Generation
   capacity = 89653248 (85.5MB)
   used     = 15831856 (15.098434448242188MB)
   free     = 73821392 (70.40156555175781MB)
   17.658987658762793% used
```

