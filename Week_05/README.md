学习笔记

# 第9课 Java相关框架

### 1.Spring 技术发展

### 2.Spring框架设计*

### 3.Spring AOP详解*

- AOP - 面向切面编程
  - Spring早期版本的核心功能，管理对象生命周期与对象装配
  - 为了实现管理和装配，一个自然而然的想法就是，加一个中间层代理（字节码增强）来实现所有对象的托管
- IoC - 控制反转
  - 也称为DI（Dependency Injection）依赖注入
  - 对象装配思路的改进
  - 从对象A直接引用和操作对象B，变成对象A里只需要依赖一个接口IB，系统启动和装配阶段，把IB接口的实例对象注入到对象A，这样A就不需要依赖一个IB接口的具体实现，也就是类B
  - 从而可以实现在不修改代码的情况，修改配置文件，即可以运行时替换成注入IB接口另一实现类C的一个对象实例。

### 4.Spring Bean核心原理*

- Spring Bean生命周期
  - Bean的加载过程 - 创建
    - 创建对象
    - 属性赋值
    - 初始化
    - 注销接口注册
  - Bean的加载过程 - 初始化
    - 检查Aware装配
    - 前置处理、After处理
    - 调用init method
    - 后置处理

### 5.Spring XML配置原理

- XML配置原理
  - 自定义标签
  - schema Location
  - spring.schemas
  - spring.handler
  - 检查XML配置是否正确
  - 从DOM节点parse对象
  - Bean
- 自动化XML配置工具
  - XmlBeans -> Spring-xbean
  - 2个原理
    - 根据Bean的字段结构，自动生成XSD
    - 根据Beande字段结构，配置XML文件
  - XML、@Autowire
  - @Service
  - @Bean、@Configuration
  - @Condition、@AutoConfigureX

### 6.Spring Messaging等技术

### 7.回顾



# 第10课 Java 相关框架（2）

### 1.从Spring到Spring Boot

- Spring变得越来越复杂
  - 配置的发展方向
    - XML - 全局
    - 注解 - 类
    - 配置类 - 方法
    - Spring4以上的新特性，走向Spring Boot
- Spring Boot的出发点
  - Spring臃肿以后的必然选择
  - 一切都是为了简化
    - 让开发变简单
    - 让配置变简单
    - 让运行变简单
  - 怎么变简单 ： 关键字 - 整合
  - 就像是SSH、SSM，国产的Spring Side
  - 基于什么变简单：约定大于配置
- Spring Boot如何做到简化
  - 为什么能做到简化
    - Spring 本身技术的成熟与完善，各方面第三方组件的成熟集成
    - Spring团队在去web容器化等方面的努力
    - 基于MAVEN与POM的Java生态体系，整合POM模版成为可能
    - 避免大量maven导入和各种版本冲突
    - Spring Boot是Spring的一套快速配置脚手架，关注于自动配置，配置驱动
- 什么是Spring Boot
  - Spring Boot使创建独立运行、生产级别的Spring应用变得容易，可以直接运行它。大部分Spring Boot应用仅仅需要最少量的配置
  - 功能特性
    - 创建独立运行的Spring应用
    - 直接嵌入Tomcat或Jetty，Undertow，无需部署WAR包
    - 提供限定性的starter依赖简化配置
    - 在必要时自动化配置Spring和其他三方依赖库
    - 提供生产production-ready特性，例如指标度量，健康检查，外部配置等
    - 完全零代码生产和不需要XML配置

### 2.Spring Boot核心原理 *

- 自动化配置：简化配置核心
  - 基于Configuration，Enable XX，Condition
- spring-boot-start：脚手架核心
  - 整合各种第三方类库，协同工具
- 为什么要约定大于配置
  - 举例来说，JVM有1000多个参数，但是我们不需要一个参数就能java Hello。
  - 优势在于，开箱即用：
    - Maven的目录结构：默认有resources文件夹存放配置文件。默认打包方式是jar。
    - 默认的配置文件：application.propertis或application.yml文件
    - 默认通过spring.profiles.active属性来决定运行环境时的配置文件
    - EnableAutoConfiguration默认对于依赖的starter进行自动装载
    - spring-boot-start-web中默认包含spring-mvc相关依赖以及内置的web容器，使得构建一个web应用更加简单
- Spring Boot自动配置注解
  - @SpringBootApplication	
  - SpringBoot应用标注在某个类上说明这个类是SpringBoot的主配置类，SpringBoot就会运行这个类的main方法来启动SpringBoot项目
    - @SpringBootConfiguration
    - @EnableAutoConfiguration
    - @AutoConfigurationPackage
    - @import({AutoConfigurationImportSelector.class})
    - 加载所有META-INF/spring.factories中存在的配置类（类似SpringMVC中加载所有converter）
  - 条件话自动配置
    - @ConidtionalOnBean
    - @ConditionalOnClass
    - @ConditionalOnMissingBean
    - @CondiitonalOnProperty
    - @ConditionalOnResource
    - @ConditionalOnSingleCandidate
    - @ConditionalOnWebApplication

### 3.Spring Boot Starter 详解 *

- 以一个实际项目讲解start
  - spring.provides
  - spring.factories
  - Additional--metadata
  - 自定义Configuration类

### 4.JDBC 与数据库连接池

- JDBC定义了数据库交互接口
  - DriverManager
  - Connection
  - Statement
  - ResultSet
  - 后来又加了DataSource--Pool
- JDBC是Java里操作数据库的核心
  - Java操作数据库的各种类库，都可以看作是在JDBC上做的增强实现
  - 为什么可以这么做
    - 加上XA事务 - XAConnection
    - 从连接池获取 -- PooledConnection
    - MySQL驱动JDBC接口 -- Connection
- 数据库连接池
  - C3P0
  - DBCP -- Apache CommonPool
  - Druid
  - Hikari

### 5.ORM-Hibernate/Mybatis *

- ORM （Object-Relational Mapping）表示对象关系映射
- Hibernate是一个开源的对象关系映射框架，它对JDBC进行了非常轻量级的对象封装，它将POJO与数据库表建立映射关系，是一个全自动的orm框架，Hibernate可以自动生成SQL语句，自动执行，使得Java程序员可以使用面向对象的思维来操纵数据库。
- Hibernate里需要定义实体类和hbm映射关系文件（IDE一般有工具生成）
- Hibernate里可以使用HQL、Criteria、Native SQL三种方式操作数据库。
- 也可以作为JPA适配实现，使用JPA接口操作。
- MyBatis
  - MyBatis是一款优秀的持久层框架，它支持定制化SQL、存储过程以及高级映射。MyBatis避免了几乎所有的JDBC代码和手动设置参数以及获取结果集。MyBatis可以使用简单的XML或注解来配置和映射原生信息，将接口和Java的POJOs（Plain Old Java Objects，普通的Java对象）映射成数据库中的记录。
  - 半自动化ORM
    - 需要使用映射文件mapper.xml定义map规则和SQL
    - 需要定义mapper/DAO，基于xml规则，操作数据库
    - 可以使用工具生成基础的mapper.xml和mapper/DAO
    - 一个经验就是，继承生成的mapper，而不是覆盖掉
    - 也可以直接在mapper上用注解方式配置SQL
  - 与Hibernate比较
    - Mybatis优点：原生SQL（XML语法），直观，对DBA友好
    - Hibernate优点：简单场景不用写SQL（HQL、Cretiria、SQL）
    - Mybatis缺点：繁琐，可以用Mybatis-generator、Mybatis-plus之类的插件
    - Hibernate缺点：对DBA不友好

### 6.Spring 集成ORM/JPA

- JPA的全称是Java Persistence API ，即Java持久化API，是一套ORM的规范，内部是由一系列的接口和抽象类构成
- JPA通过JDK5.0注解描述对象-关系表映射关系，并将运行期的实体对象持久化到数据库中
- 核心 - EntityManager
- 

### 7.Spring Boot集成ORM/JPA

### 8.回顾