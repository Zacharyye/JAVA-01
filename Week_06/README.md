学习笔记

# 第11课 Java相关框架（3）

### 1.Java8 Lambda *

- 什么是Lambda表达式？

  - Lambda表达式（lambda expression）是一个匿名函数，Lambda表达式基于数学中的λ演算得名，直接对应于其中的lambda抽象（lambda abstraction），是一个匿名函数，即没有函数名的函数。

- Java Lambda 表达式

  - 面向对象与面向函数

  - Java里，函数不是第一等公民，需要封装到接口里。从而Java Lambda表达式 --> 内部匿名类。

  - 方法签名

  - 两种函数

  - 只有一行时可以省略大阔号

    - (parameters) -> expression
    - (parameters) -> {statements;}

  - 不接收参数，返回值为5

    - ```
      () -> 5
      ```

  - 接收一个参数（数字类型），返回其2倍的值

    - ```
      x -> 2*x
      ```

  - 接收2个参数（数字），并返回他们的差值

    - ```
      (x,y) -> x - y
      ```

  - 接收2个int型整数，返回他们的和

    - ```
      (int x, int y) -> x + y
      ```

  - 接收一个string对象，并在控制台打印，不返回任何值（看起来像是返回void）

    - ```
      (String s) -> System.out.print(s)
      ```

- 深入Java8 函数式

  - @FunctionalInterface
  - Predicate<T> 有参数、条件判断
  - Function<T, R> 有参数、有返回值
  - Consumer<T> 无返回值
  - Supplier<T> 无参数、有返回值

- 再聊聊Java集合与泛型

  - 什么是泛型
  - 伪泛型、擦除法
  - 运行期这么判断有泛型
  - lambda里有泛型
  - 多个泛型约束条件
  - 泛型也是为了简化编程

### 2.Java8 Stream *

- 什么是流
  - Stream（流）是一个来自数据源的元素队列并支持聚合操作
    - 元素：特定类型的对象，形成一个队列，Java中的Stream并不会存储元素，而是按需计算
    - 数据源：流的来源。可以是集合，数组，I/O channel，产生器generator等
    - 聚合操作 类似SQL语句一样的操作，比如filter，map，reduce，find，match，sorted等
    - 和以前的Collection操作不同，Stream操作还有两个基础的特征：
      - Pipelining：中间操作都会返回流对象本身。这样多个操作可以串联成一个管道，如同流式风格（fluent style）。这样做可以对操作进行优化，比如延迟执行（laziness） 和短路（short-circuiting）
      - 内部迭代：以前对集合遍历都是通过Iterator或者For-Each的方式，显式的在集合外部进行迭代，这叫外部迭代。Stram提供了内部迭代的方式，通过访问者模式（Visitor）实现。
  - Stream操作
    - 中间操作
      - 选择和过滤
        - filter（Predicate p）接收Lambda，从流冲排除某些元素
        - distinct()筛选，通过流锁生成元素的hashCode()和equals()去除重复元素
        - limit(long maxSize)截断流，使其元素不超过给定数量。
        - skip(long n)跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流
      - 映射
        - map(Function f) 接收Lambda，将元素转换成其他形式或提取信息；接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
        - mapToDouble(ToDoubleFunction f)接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的DoubleStream
        - mapToInt(ToIntFunction f)接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的IntStream
        - mapToLong(ToLongFunction f)接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的LongStream
        - flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
      - 排序
        - sorted()产生一个新流，其中按自然顺序排序
        - Sorted(Comparator comp)产生一个新流，其中按比较器顺序排序
    - 终止操作
      - 查找与匹配
        - allMatch - 检查是否匹配所有元素
        - anyMatch - 检查是否至少匹配一个元素
        - noneMatch - 检查是否没有匹配的元素
        - findFirst - 返回第一个元素
        - findAny - 返回当前流中的任意元素
        - count - 返回流中元素的总个数
        - max - 返回流中最大值
        - min - 返回流中最小值
      - 归约reduce，需要初始值（类比Map-Reduce）
      - 收集collect
        - toList List<T> 把流中元素收集到List
        - toSet Set<T> 把流中元素收集到Set
        - toCollection Collection<T> 把流中元素收集到创建的集合
        - count - 计算流中元素的个数
        - summaryStatistics 统计最大最小平均值
      - 迭代forEach
    - Stream大大简化了集合编程

### 3.Lombok

- Lombok是什么？
  - Lombok是基于jsr269实现的一个非常神奇的java类库，会利用注解自动生成java Bean中烦人的get、set方法及有参无参构造函数，还能自动生成logger、ToString、HashCode、Buildre等java特色的函数或是符合设计模式的方法，能够让你java Bean更简洁，更美观
  - 基于字节码增强，编译期处理
  - 可以配置开发工具IDE或Maven使用
- 示例
  - @Setter @Getter
  - @Data
  - @XXXConstructor
  - @Builder
  - @ToString
  - @Sl4j

### 4.Guava

- 什么是Guava
  - Guava是一种基于开源的Java库，其中包含谷歌正在由他们很多项目使用的很多核心库。这个库是为了方便编码，并减少编码错误。这个库提供用于集合，缓存，支持原语，并发性，常见注解，字符串处理，I/O和验证的实用方法。
- Guava的好处
  - 标准化 - Guava库是由谷歌托管
  - 高效 - 可靠、快速和有效的扩展Java标准库
  - 优化 - Guava库经过高度的优化
- JDK8里的一些新特性源于Guava
- 集合【Collections】
  - Guava对JDK集合的扩展，这是Guava最成熟和为人所知的部分
  - 不可变集合：用不可变的集合进行防御性编程和性能提升
  - 新集合类型：multisets，multimaps，tables，bidirectional maps等
  - 强大的集合工具类：提供java.util.Collections中没有的集合工具
  - 扩展工具类：让实现和扩展集合类变得更容易，比如创建Collection的装饰器，或实现迭代器
- 缓存【Caches】
  - 本地缓存实现，支持多种缓存过期策略
- 并发【Concurrency】
  - ListenableFuture：完成后触发回调的Future
- 字符串处理【Strings】
  - 非常有用的字符串工具，包括分割、连接、填充等操作
- 事件总线【EventBus】
  - 发布-订阅模式的组件通信，进程内模块间解耦
- 反射【Reflection】
  - Guava的Java反射机制工具类

### 5.设计原则 *

- 面向对象设计原则SOLID
  - S.O.L.I.D是面向对象设计和编程（OOD&OOP）中几个重要编码原则（Programming Principle）的首字母缩写
  - SRP： The Single Responsibility Principle 单一责任原则
  - OCP：The Open Closed Principle 开放封闭原则
  - LSP：The Liskov Substitution Principle 里氏替换原则
  - ISP：The Interface Segregation Principle 接口分离原则
  - DIP：The Dependency Inversion Principle 依赖倒置原则
- 最小知识原则：KISS 高内聚低耦合
- 编码规则、checkstyle
  - 为什么需要编码规范？
  - 常见的编码规范
    - Google编码规范
    - Alibaba编码规范
    - VIP规范
  - 其他规范
    - 架构设计规范，技术调研规范，数据库规范等等

### 6.设计模式 *

- GoF 23个经典设计模式（面向接口编程）
- 本质是一类特定场景下通用解决经验
- 创建型
  - Factory Method（工厂方法）
  - Abstract Factory（抽象工厂）
  - Builder（建造者）
  - Prototype（原型）
  - Singleton（单例）
- 结构型
  - Adapter（适配器）
  - Bridge（桥接）
  - Composite（组合）
  - Facade（外观）
  - Flyweight（享元）
  - Proxy（代理）
- 行为型
  - Interpreter（解释器）
  - Template Method（模版方法）
  - Chain of Responsibility（责任链）
  - Command（命令）
  - Iterator（迭代器）
  - Mediator（中介者）
  - Memento（备忘录）
  - Observer（观察者）
  - State（状态）
  - Strategy（策略）
  - Visitor（访问者）
- 设计模式与反模式
  - 模式的3个层次：解决方案层面（架构模式），组件层面（框架模式），代码层面（GoF设计模式）
  - 其他模式：集成模式，事务模式，IO模式/Context模式，甚至状态机FSM，规则引擎RE，workflow都是模式
  - 反模式：死用模式，都是反模式

### 7.单元测试 * 

- 什么是单元测试
  - 手工回归测试
  - 自动化端到端测试
  - 集成测试
  - 单元测试
  - UI - 服务 - 单元
- 发现缺陷越提前，修复成本越小
- 如何做单元测试
  - JUnit -> TestCase，TestSuite，Runner
  - SpringTest
  - Mock技术
    - Mockito
    - easyMock
  - 单元测试方法应该每个方法是一个case，断言充分，提示明确
  - 单测要覆盖所有的corner case
  - 充分使用mock（一切皆可mock）
  - 如果发现不好测试，则说明业务代码设计存在问题，可以反向优化代码
  - 批量测试用例使用参数化单元测试
  - 注意测试是单线程执行
  - 合理使用before，after，setup准备环境
  - 合理使用通用测试基类
  - 配合checkstyle，coverge等工具
  - 制定单元测试覆盖率基线
- 单元测试的常见陷阱与经验
  - 尽量不要访问外部数据库等外部资源
  - 如果必须用数据库考虑用嵌入式DB+事务自动会滚
  - 防止静态变量污染导致测试无效
  - 小心测试方法的顺序导致的不同环境测试失败
  - 单元测试总时间特别长的问题

### 8.回顾



# 第十二课 性能与SQL优化（1）

### 1.再聊聊性能优化

- 什么是性能
  - 吞吐与延迟
  - 没有量化就没有改进
  - 80/20原则
  - 过早的优化是万恶之源
  - 脱离场景谈性能都是耍流氓
- DB/SQL优化是业务系统性能优化的核心
  - 业务系统的分类：计算密集型、数据密集型
  - 业务处理本身无状态，数据状态最终要保存到数据库
  - 一般来说，DB/SQL操作的消耗在一次处理中占比最大
  - 业务系统发展的不同阶段和时期，性能瓶颈要点不同，类似木桶装水

### 2.关系数据库MySQL

- 什么是关系数据库
  - E-R图
- 数据库设计范式
  - 第一范式 1NF - 关系R属于第一范式，当且仅当R中每一个属性A的值域只包含原子项
    - 消除重复数据，即每一列都是不可再分的基本数据项
    - 每个列都是原子的
  - 第二范式 2NF - 在满足1NF的基础上，消除非主属性对码的部分函数依赖
    - 消除部分依赖，表中没有列只与主见的部分相关，即每一行都被主键唯一标识；每个列都有主键
  - 第三范式 3NF - 在满足2NF的基础上，消除非主属性对码的传递函数依赖
    - 消除传递依赖，消除表中列不依赖主键，而是依赖表中的非主键列的情况，即没有列是与主键不相关的
    - 从表只引用主表的主键，即表中每列都和主键相关
  - BC范式 BCNF - 在满足3NF的基础上，消除主属性对码的部分和传递函数依赖
    - 巴斯-科德范式
  - 第四范式 4NF - 消除非平凡的多值依赖
  - 第五范式 5NF - 消除一些不合适的连接依赖
- 常见关系数据库
  - 开源：MySQL、PostgreSQL
  - 商业：Oracle，DB2，SQLServer
  - 内存数据库：Redis？，VoltDB
  - 图数据库：Neo4j，Nebula
  - 时序数据库：InfluxDB，openTSDB
  - 其他关系数据库：Access，Sqlite，H2，Derby，Sybase，Infomix等
  - NoSQL数据库：MongoDB，Hbase，Cassandra，CouchDB
  - NewSQL/分布式数据库：TiDB、CockroachDB、NuoDB、OpenGauss、OB、TDSQL

### 3.深入数据库原理

- SQL语言
  - 数据查询语言（DQL）
  - 数据操作语言（DML）
  - 事务控制语言（TCL）
  - 数据控制语言（DCL）
  - 数据定义语言（DDL）
  - 指针控制语言（CCL）
- MySQL数据库
  - 4.0支持InnoDB，事务
  - 2003年，5.0
  - 5.6 - 历史使用最多的版本
  - 5.7 - 近期使用最多的版本
  - 8.0 - 最新和功能完善的版本
  - 5.6/5.7的差异
    - 5.7支持
      - 多主
      - MGR高可用
      - 分区表
      - json
      - 性能
      - 修复XA等
  - 5.7/8.0的差异
    - 通用表达式
    - 窗口函数
    - 持久化参数
    - 自增列持久化
    - 默认编码 utf8mb4
    - DDL原子性
    - JSON增强
    - 不再对group by进行隐式排序？？==>坑
- MySQL存储
  - 独占模式
    - 日志组文件：ib_logfile0和ib_logifle1，默认均为5M
    - 表结构文件：*.frm
    - 独占表空间文件：*.ibd
    - 字符集和排序规则文件：db.opt
    - binlog二进制日志文件：记录主数据库服务器的DDL和DML操作
    - 二进制日志索引文件：master-bin.index，共享模式innodb_file_per_table=1
    - 数据都在ibdata1
- MySQL简化执行流程
- MySQL详细执行流程
- MySQL执行引擎和状态
- MySQL对SQL执行顺序
- MySQL索引原理
  - 数据是按页来分块的，当一个数据倍用到时，其附近的数据也通常会马上倍使用
  - InnoDB使用B+树实现聚集索引

### 4.MySQL配置优化 *

- 连接请求的变量
  - Max_connections
  - Back_log
  - Wait_timeout和interactive_timeout
- 查看参数配置
  - show variables like xxx
  - My.cnf文件
- 缓冲区变量
  - Key_buffer_size
  - Query_cache_size(查询缓存简称 QC)
  - Max_connect_errors
  - Sort_buffer_size
  - Max_allowed_packet=32M
  - Join_buffer_size=2M
  - Thread_cache_size=300
- 配置Innodb的几个变量
  - Innodb_buffer_pool_size
  - Innodb_flush_log_at_trx_commit
  - Innodb_thread_concurrency=0
  - Innodb_log_buffer_size
  - Innodb_log_file_size=50M
  - Innodb_log_files_in_group=3
  - Read_buffer_size=1M
  - Read_rnd_buffer_size=16M
  - Bulk_insert_buffer_size=64M
  - binary log

### 5.数据库设计优化 *

- 如何恰当选择引擎
- 库表如何命名
- 如何合理拆分宽表
- 如何选择恰当数据类型：明确、尽量小
- char、varchar的选择
- (text/blob/clob)的使用问题
- 文件、图片是否要存入到数据库
- 时间日期的存储问题
- 树枝的精度问题
- 是否使用外键、触发器
- 唯一约束和索引的关系
- 是否可以冗余字段
- 是否使用游标、变量、视图、自定义函数、存储过程
- 自增主键的使用问题
- 能够在线修改表机构（DDL操作）
- 逻辑删除还是物理删除
- 要不要加create_time，update_time时间戳
- 如何快速导入导出、备份数据

### 6.回顾