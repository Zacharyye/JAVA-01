课后作业实践

### 1.配置redis的主从复制，sentinel高可用，Cluster集群

```
# 主从复制
docker run --rm -d -p 16379:6379 --name mredis -v /Users/zachary/redis:/conf -v /Users/zachary/redis/log/redis:/var/log/redis -v /Users/zachary/redis/data:/data redis

docker run --rm -d -p 16371:6371 --name sredis1 -v /Users/zachary/redis:/conf -v /Users/zachary/redis/log/redis:/var/log/redis -v /Users/zachary/redis/data1:/data redis

docker run --rm -d -p 16372:6372 --name sredis2 -v /Users/zachary/redis:/conf -v /Users/zachary/redis/log/redis:/var/log/redis -v /Users/zachary/redis/data2:/data redis
```

```
docker run -d --name redis-sentinel -v /Users/zachary/redis/data-s:/var/redis/data -v /Users/zachary/redis:/conf redis /Users/zachary/redis/sentinel1.conf --sentinel
```



### 2.搭建ActiveMQ服务，基于JMS，写代码分别实现对于queue和topic的消息生产和消费，代码提交到github

