学习笔记

# 第21课 分布式缓存 - 缓存技术

### 1.从数据的使用说起

- 把数据的使用频率和方式分个类
  - 静态数据 - 一般不变，类似于字典表
  - 准静态数据 - 变化频率很低，部门结构设置，全国行政区划数据等
  - 中间状态数据 - 一些计算的可复用中间数据，变量副本，配置中心的本地副本。
  - ～
  - 热数据 - 使用频率高
  - 读写比较大 - 读的频率 >> 写的频率
  - 这些数据适合于使用缓存的方式访问
  - 广义上来说，为了加速数据处理，让业务更快访问的临时存放冗余数据，都是缓存狭义上，现在一般在分布式系统里把缓存到内存的数据叫做内存缓存。
- 缓存无处不在
  - 内存 ～ 可以看作是CPU和磁盘之间的缓存
  - CPU与内存的处理速度也不一致，出现L1&L2 Cache
  - 网络处理，数据库引擎的各种Buffer，都可以看作是缓存
  - GUI的Double Buffer（双缓存），是一个经典的性能优化方法
  - 缓存的本质
    - 系统各级处理速度不匹配，导致利用空间换时间
  - 缓存是提升系统性能的一个简单有效的方法。
- 缓存加载时机
  - 启动全量加载 => 全局有效，使用简单
  - 懒加载
    -  同步使用加载
      - 先看缓存是否有数据，没有的话从数据库读取
      - 读取的数据，先放到内存，然后返回给调用方
    - 延迟异步加载
      - 从缓存获取数据，不管是否为空直接返回
      - 策略1异步）如果为空，则发起一个异步加载的线程，负责加载数据
      - 策略2解耦）异步线程负责维护缓存的数据，定期或根据条件触发更新。
- 缓存的有效性与数据同步
  - 为什么一般说变动频率大、一致性要求高的数据，不太适合用缓存
    - 变化大，意味着内存缓存数据<-->原始数据库数据，一直有差异；一致性要求高，意味着只有使用原始数据，甚至加了事务，才是保险的。
  - 如何评价缓存的有效性
    - 读写比：对数据的写操作导致数据变动，意味着维护成本N：1
    - 命中率：命中维护意味着缓存数据被使用，意味着有价值。90%+
  - 对于数据一致性、性能、成本的综合衡量，是引入缓存的必须指标。
- 缓存使用不当导致的问题
  - 系统预热导致启动慢
    - 试想，一个系统启动需要预热半个小时；导致系统不能做到快速应对故障宕机等问题
  - 系统内存资源耗尽
    - 只加入数据，不能清理旧数据
    - 旧数据处理不及时，或者不能有效识别无用数据。

### 2.本地缓存

- 最简单的本地缓存

  - ```java
    public static final Map<String,Object> CACHE = new HashKap();
    CACHE.put("beijing", "100001");
    String cityCode = (String) CACHE.get("beijing");
    ```

- Hibernate/MyBatis都有Cache

  - 一级缓存，session级别
  - 二级缓存，sessionFactory级别

-  Guava Cache

  - ```java
    Cache<String, String> cache = CacheBuilder.newBuilder()
    	.maximumSize(1024)
    	.expireAfterWrite(60, TimeUnit.SECONDS)
    	.weakValues()
    	.build();
    cache.put("word", "Hello Guava Cache");
    System.out.println(cache.getIfPresent("word"));
    ```

  - 此外，还可以显示清楚、统计信息、移除事件的监听器、自动加载等功能。

- Spring Cache

  - 基于注解和AOP,使用非常方便
  - 可以配置Condition和SPEL，非常灵活
  - 需要注意：绕过Spring的话，注解无效
  - 核心功能：@Cacheable、@CachePut、@CacheEvict

### 3.远程缓存

- 本地缓存有什么缺点
  - 在多个集群环境同步？当集群规模增大，缓存的读写放大。
  - 在JVM中长期占用内存？如果是堆内存，总是会影响GC
  - 缓存数据的调度处理，影响执行业务的线程，抢资源。
  - 集中处理缓存
- Redis/Memcached缓存中间件
  - Remote Dictionary Server（Redis）是一个由Salvatore Sanfilippo写的key-value存储系统。Redis是一个开源的使用ANSI C语言编写、遵守BSD协议、支持网络、可基于内存亦可持久化的日志型、Key-Value数据库，并提供多种语言的API。
  - Memcached是以LiveJournal旗下Danga Interactive公司的Brad Fitzpatric为首开发的一款开源高性能，分布式内存对象缓存系统。
- Hazelcast/Ignite内存网格
  - ～

### 4.缓存策略

- 容量
  - 资源有限
    - 缓存数据容量是必须要考虑的问题
    - 思考系统的设计容量、使用容量、峰值，应该是我们做架构设计的一个常识
- 过期策略
  - 按FIFO或LRU
  - 按固定时间过期
  - 按业务时间加权：例如3+5x

### 5.缓存常见问题

- 缓存穿透
  - 问题：大量并发查询不存在的Key，导致都直接将压力透传到数据库
  - 分析：为什么会多次透传呢？不存在一直为空。
  - 需要注意让缓存能够区分KEY不存在和查询到一个空值
  - 解决办法：
    - 缓存空值的KEY，这样第一次不存在也会被加载记录，下次拿到有这个KEY
    - Bloom过滤或RoaringBitmap判断KEY是否存在
    - 完全以缓存为准，使用延迟异步加载的策略2，这样就不会触发更新
- 缓存击穿
  - 问题：某个KEY失效的时候，正好有大量并发请求访问这个KEY
  - 分析：跟前面一个其实很像，属于比较偶然的
  - 解决办法：
    - KEY的更新操作添加全局互斥锁
    - 完全以缓存为准，使用延迟异步加载的策略2，这样就不会触发更新
- 缓存雪崩
  - 问题：当某一时刻发生大规模的缓存失效的情况，会有大量的请求进来直接打到数据库，导致数据库压力过大升值宕机。
  - 分析：一般来说，由于更新策略、或者数据热点、缓存服务宕机等原因，可能会导致缓存数据同一个时间点大规模不可用，或者都更新。所以，需要我们的更新策略要在时间上合适，数据要均匀分散，缓存服务器要多台高可用。
  - 解决办法：
    - 更新策略在时间上做到比较均匀
    - 使用的热数据尽量分散到不同的机器上
    - 多台机器做主从复制或者多副本，实现高可用
    - 实现熔断限流机制，对系统进行负载能力控制。

### 6.总结



# 第22课 分布式缓存-Redis详解

### 1.Redis基本功能

- Redis安装

  - 三种方式：

    - 下载安装、编译源码安装（Windows：微软提供3.x/Memural提供5.x）

    - brew、apt、yum安装

    - docker启动方式

      - ```
        docker pull redis
        docker run -itd --name redis-test -p 6379:6379 redis
        docker image inspect redis:latest|grep -i version
        
        docker exec -it redis-test /bin/bash
        $ redis-cli
        > info
        ```
        
    
  - Docker安装
  
    - 新入门注意的坑：没有redis.conf文件
  
    - 如何处理？
  
      - ```
        docker run -p 6379:6379 --name redis01 -v /etc/redis/redis.conf:/etc/redis/redis.conf -v /etc/redis/data:/data -d redis redis-server /etc/redis/redis.conf --appendonly yes
        ```
  
- Redis性能测试

  - 可以使用自带的命令 redis-benchmark

    - ```
      redis-benckmark -n 100000 -c 32 -t SET,GET,INCR,HSET,LPUSH,MSET -q
      ```

- Redis的5种基本数据结构

  - 1.字符串（String）～简单来说就是三种：int、String、byte[]
    - 字符串类型是Redis中最为基础的数据存储类型，它在Redis中是二进制安全的，这便意味着该类型可以接受任何格式的数据，如JPEG图像数据或json对象描述信息等。在Redis中字符串类型的value最多可以容纳的数据长度是512M
    - `set/get/getset/del/exists/append`
    - `incr/decr/incrby/decrby`
    - 注意：
      - 字符串append：会使用更多的内容
      - 整数共享：如何能使用整数，就尽量使用整数，限制了redis内存+LRU
      - 整数精度问题：redis大概能保证16～，17，18位的大整数就会丢失精度
  - 2.散列（hash）- Map～Pojo Class
    - Redis中的Hash类型可以看成具有String key和String value的map容器。所以该类型非常适合于存储对象的信息。如Username、password和age。如果Hash中包含少量的字段，那么该类型的数据也将仅占用很少的磁盘空间。
    - `hset/hget/hmset/hmget/hgetall/hdel/hincyby`
    - `hexists/hlen/hkeys/hvals`
    - hashmap的方法
  - 3.列表（list）～java的LinkedList
    - 在Redis中，List类型是按照插入顺序排序的字符串链表。和数据结构中的普通链表一样，我们可以在其头部（Left）和尾部）Right）添加新的元素。在插入时，如果该键并不存在，Redis将为该创建一个新的链表。与此相反，如果链表中所有的元素均被移除，那么该键也将会被从数据库中删除。
    - `lpush/rpush/lrange/lpop/rpop`
  - 4.集合（set）～java的set，不重复的list
    - 在redis中，可以将Set类型看作是没有排序的字符集合，和List类型一样，我们也可以在该类型的数值上执行添加、删除和判断某一元素是否存在等操作。这些操作哦的时间复杂度为O(1)，即常量时间内完成一次操作。
    - 和List类型不同的是，Set集合中不允许出现重复的元素。
    - `sadd/srem/smembers/sismember ~ set.add,remove,contains`
    - `sdiff/sinter/sunion~集合求差集，求交集，求并集`
  - 5.有序集合(sorted set)
    - sortedset和set极为相似，他们都是字符串的集合，都不允许重复的成员出现在一个set中。他们之间的主要差别是sortedset中每一个成员都会有一个分数与之关联。redis正是通过分数来为集合的成员进行从小到大的排序。sortedset中分数是可以重复的。
    - `zadd key score member score2 member2...: 将成员以及该成员的分数存到sortedset中`
    - `zscore key member:返回指定成员的分数`
    - `zcard key: 获取集合中成员数量`
    - `zrem key member[member...]:移除集合中指定的成员，可以指定多个成员`
    - `zrange key start end[withscores]:获取集合中脚注为start-end的成员，[withscore]参数表明返回的成员包含其分数`
    - `zrevrange key start stop[withscore]:按照分数从大到小的顺序返回索引从start到stop之间的所有元素（包含两端的元素）`
    - `zremrangebyrank key start stop:按照排名范围删除元素`

- Redis的3种高级数据结构

  - Bitmaps: setbit/getbit/bitop/bitcount/bitpos
    - bitmaps不是一个真实的数据结构。而是String类型上的一组面向bit操作的集合。由于strings是二进制安全的blob，并且它们的最大长度是512m，所以bitmaps能最大设置2^32个不同的bit。
  - Hyperloglogs: pfadd/pfcount/pfmerge
    - 在redis的实现中，使用标准错误小于1%的估计度量结束。这个算法的神奇在于不再需要与需要统计的项相对应的内存，取而代之，使用的内存一直恒定不变。最坏的情况下只需要12k，就可以计算接近2^64个不同元素的基数。
  - GEO：geoadd/geohash/geopos/geodis/georadius/georadiusbymember
    - Redis的GEO特性在Redis3.2版本中推出，这个功能可以将用户给定的地理位置（经度和纬度）信息储存起来，并对这些信息进行操作。

- Redis到底是单线程，还是多线程？

  - 这个问题本身就是个坑
  - IO线程：
    - redis6之前（2020年5月），单线程
    - redis6之后，多线程，NIO模型==>主要的性能提升点
  - 内存处理线程：
    - 单线程 ==> 高性能的核心

### 2.Redis六大使用场景

- 业务数据缓存*

  - 经典用法
  - 通用数据缓存，String、int、list、map等
  - 实时热数据，最新500条
  - 会话缓存，token缓存等

- 业务数据处理

  - 非严格一致性要求的数据：评论，点击等
  - 业务数据去重：订单处理的幂等校验等
  - 业务数据排序：排名，排行榜等

- 全局一致计数*

  - 全局流控计数
  - 秒杀的库存计算
  - 抢红包
  - 全局ID生成

- 高效统计计数

  - id去重，记录访问ip等全局bitmap操作
  - UV、PV等访问量==>非严格一致性要求

- 发布订阅和Stream

  - Pub-Sub模拟队列
    - Subscribe comments publish comments java
  - Redis String 是Redis 5.0版本新增加的数据结构
    - Redis Stream主要用于消息队列（MQ，Message Queue）

- 分布式锁*

  - 获取锁--单个原子性操作

    - `SET dlock my_random_value NX PX 30000`

  - 释放锁--lua脚本-保证原子性+单线程，从而具有事务性

    - ```
      if redis.call("get", KEYS[1]) == ARGV[1] then
      	return redis.call("del", KEYS[1]);
      else
      	return 0
      end
      ```

    - 关注点： 原子性、互斥、超时

### 3.Redis的Java客户端

- Jedis	
  - 官方客户端，类似于JDBC，可以看作是对redis命令的包装
  - 基于BIO，线程不安全，需要配置连接池管理连接
- Lettuce
  - 目前主流推荐的驱动，基于Netty NIO，API线程安全
- Redission
  - 基于Netty NIO，API线程安全
  - 亮点：大量丰富的分布式供能特性，比如JUC的线程安全集合和工具的分布式版本，分布式的基本数据类型和锁等。

### 4.Redis与Spring整合

- Spring Date Redis
  - 核心是RedisTemplate（可以配置基于Jedis，Lettuce，Redission）
  - 使用方式类似于MongoDBTemplate，JDBCTemplate或JPA
  - 封装了基于redis命令操作
- Spring Boot与Redis集成
  - 引入spring-boot-starter-data-redis
  - 配置spring redis
- Spring Cache与Redis集成
  - 默认使用全局的CacheManager自动集成
  - 使用ConcurrentHashMap或ehcache时，不需要考虑序列化问题
  - redis的话，需要：
    - 默认使用java的对象序列化，对象需要实现Serializable
    - 自定义配置，可以修改为其他序列化方式
- Mybatis项目集成cache示例
  - 集成spring boot与mybatis，实现简单单表操作，配置成rest接口
  - 配置ehcache+mybatis集成，实现mybatis二级缓存
  - 配置spring cache+ehcache缓存，实现方法级别缓存
  - 修改spring cache使用redis远程缓存代替ehcache本地缓存
  - 修改spring cache使用jackson json序列化代替java序列化
  - 整个过程中，使用wrk压测rest接口性能，并分析为什么？
  - 尝试调整各种不同的配置和参数，理解cache原理和用法

### 5.Redis高级功能

- Redis事务

  - Redis事务命令
    - 开启事务 - multi
    - 命令入队
    - 执行事务：exec
    - 撤销事务：discard
  - Watch实现乐观锁
    - watch一个key，发生变化则事务失败

- Redis Lua～open resty = nginx + lua jit

  - 类似于数据库的存储过程，mongodb的js脚本
  - 直接执行
    - Eval "return 'hello java'" 0
    - Eval "redis.call('set', KEYS[1], ARGV[1])" 1 Lua-key lua-value
  - 预编译
    - Script load script 脚本片段
    - 返回一个SHA-1签名，shastring
    - `evalsha shastring keynum [key1 key2 key3 ...][param1 param2 param3...]`

- Redis管道技术

  - 合并操作批量处理，且不阻塞前序命令：

  - `% (echo -en "PING\r\n SET pkey redis\r\nGET pkey\r\nINCR visitor\r\nINCR visitor\r\nINCR visitor\r\n";sleep 1)|nc localhost 6379 `

  - 输出

    - ```
      +PONG
      +OK
      $5
      redis
      :1
      :2
      :3
      ```

- Redis数据备份与恢复--RDB～frm

  - 备份

    - 执行save即可在redis数据目录生成数据文件 dump.rdb
    - 也可以异步执行bgsave

  - 恢复

    - 将备份文件（dump.rdb)移动到redis数据目录并启动服务即可

    - 查看文件夹 CONFIG GET dir

    - > CONFIG GET dir
      >
      > 1) "dir"
      >
      > 2)"/data"

- Redis数据备份与恢复--AOF～binlog

  - 备份

    - 如果appendonly配置为yes，则以AOF方式备份Redis数据，那么此时Redis会按照配置，在特定的时候执行追加命令，用以备份数据

    - ```
      appendfilename "appendonly.aof"
      # appendfsync always
      # appendfsync everysec
      # appendfsync no....
      ```

    - AOF文件和Redis命令是同步频率的，假设配置为always，其含义为当Redis执行命令的时候，则同时同步到AOF文件，这样会使得Redis同步刷新AOF文件，造成缓慢。而采用everysec则代表每秒同步一次命令到AOF文件

  - 恢复

    - 自动加载

- Redis性能优化

  - 核心优化点

    - 内存优化

      - ```
        https://redis.io/topics/memory-optimization
        hash-max-ziplist-value 64
        zset-max-ziplist-value 64
        ```

    - CPU优化

      - 不要阻塞
      - 谨慎使用范围操作
      - SLOWLOG get 10，默认10毫秒，默认只保留最后的128条

- Redis分区

  - 设计问题：
    - 容量
    - 分区

- Redis使用的一些经验

  - 性能
    - 线程数与连接数
    - 监控系统读写比和缓存命中率
  - 容量
    - 做好容量评估，合理使用缓存资源
  - 资源管理和分配
    - 尽量每个业务集群单独使用自己的Redis，不混用
    - 控制Redis资源的申请与使用，规范环境和KEY的管理（以一线互联网为例）
    - 监控CPU100%，优化高延迟的操作。

### 6.总结

