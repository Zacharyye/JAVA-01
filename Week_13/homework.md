学习笔记

### 1.搭建一个3节点Kafka集群，测试功能和性能；实现spring Kafka下对kafka集群的操作

- 执行性能测试

  - ```
    bin/kafka-producer-perf-test.sh --topic test32 --num-records 100000 --record-size 1000 --throughput 2000 --producer-props bootstrap.servers=localhost:9002
    
    10000 records sent, 2000.0 records/sec (1.91 MB/sec), 5.2 ms avg latency, 324.0 ms max latency.
    10002 records sent, 2000.4 records/sec (1.91 MB/sec), 0.5 ms avg latency, 4.0 ms max latency.
    10002 records sent, 2000.4 records/sec (1.91 MB/sec), 0.5 ms avg latency, 27.0 ms max latency.
    10002 records sent, 2000.4 records/sec (1.91 MB/sec), 0.3 ms avg latency, 4.0 ms max latency.
    10004 records sent, 2000.4 records/sec (1.91 MB/sec), 0.3 ms avg latency, 3.0 ms max latency.
    10004 records sent, 2000.4 records/sec (1.91 MB/sec), 0.4 ms avg latency, 19.0 ms max latency.
    10000 records sent, 2000.0 records/sec (1.91 MB/sec), 0.4 ms avg latency, 25.0 ms max latency.
    10000 records sent, 2000.0 records/sec (1.91 MB/sec), 0.3 ms avg latency, 2.0 ms max latency.
    10002 records sent, 2000.4 records/sec (1.91 MB/sec), 0.4 ms avg latency, 22.0 ms max latency.
    100000 records sent, 1999.680051 records/sec (1.91 MB/sec), 0.87 ms avg latency, 324.00 ms max latency, 0 ms 50th, 1 ms 95th, 5 ms 99th, 70 ms 99.9th.
    ```

  - ```
    bin/kafka-consumer-perf-test.sh --bootstrap-server localhost:9002 --topic test32 -- fetch-size 1048576 --messages 100000 --threads 1
    
    
    start.time, end.time, data.consumed.in.MB, MB.sec, data.consumed.in.nMsg, nMsg.sec, rebalance.time.ms, fetch.time.ms, fetch.MB.sec, fetch.nMsg.sec
    WARNING: Exiting before consuming the expected number of messages: timeout (10000 ms) exceeded. You can use the --timeout option to increase the timeout.
    2021-04-11 21:33:28:273, 2021-04-11 21:33:38:378, 0.0000, 0.0000, 0, 0.0000, 0, 10105, 0.0000, 0.0000
    ```

    

