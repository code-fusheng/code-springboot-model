# code-springboot-model

```
init : 工程建设 --- 规范化 SpringBoot 工程单体项目骨架
feature : 代码生成 --- 新增 MybatisPlus 代码生成工具配置
fix : 文件忽略 --- 处理本地以及远程 .DS_Store(Mac文件图标) 文件问题
feature : 精度处理 --- 新增 Jackson 序列化类型转换处理前端 long 类型精度问题
feature : 认证授权 --- 新增 Spring Security 认证授权体系逻辑
feature : 认证授权 --- 新增用户名密码登录 login 接口以及用户信息 info 接口
feature : 线程变量 --- 新增本地线程变量 ThreadLocalContext 持有者类
feature : 切面模版 --- 新增 AOP 切面配置参考模版
feature : 易错问题 --- 新增 ThreadLocal 使用案例以及说明
feature : 易错问题 --- 新增 ConcurrentHashMap 使用案例以及说明
feature : 易错问题 --- 新增 ThreadPool 使用案例以及说明
feature : 易错问题 --- 新增 Hikari JMX MBean 连接池信息注册以及存活时间配置; 配合 Jconsole 以及 mrk 进行压测监控
file : 归档管理 --- 初始化DB数据 D-V0.1.0.sql 文件，用于初始化系统元数据
design : 架构设计 --- 调整系统整体实体对象结构,新增领域驱动模型domain以及持久层po模型
feature : 易错问题 --- (待补充)新增 JudgmentTest 类:描述等值判断在各个场景下的问题
feature : 易错问题 --- 新增 PrecisionTest 类:描述类型精度在各个场景下的问题与处理
feature : 易错问题 --- 新增 CollectionTest 类:描述了 Arrays.asList 与 Collection 中部分使用的易错问题
feature : 易错问题 --- 新增 NullPointerTest 类:描述了常见的几种空指针场景以及优化处理方式
feature : 易错问题 --- 新增 Exception 异常情况的场景与处理方式
feature : 架构设计 --- 新增 GlobalExceptionHandler 以及 Exceptions 等异常处理类与场景测试
feature : 易错问题 --- 新增 ThreadPoolExceptionTest 类: 阐述了线程池的常见异常处理方式
feature : 系统日志 --- 探索系统日志 requestId 的设计实现方式
feature : 系统日志/易错问题 --- 新增 logback-spring.xml 的使用细节与常见问题
feature : 易错问题 --- 新增 FileIOErrorTest 类:描述文件 IO 使用过程中常见的问题与处理方式
feature : 易错问题 --- 新增 RedisTest 类: 通过使用默认的 RedisTemplate 与 StringRedisTemplate，探索自定义 Redis 序列化的起源
feature : 系统配置 --- 新增 RedisConfig 类, 依据前面探索实践的结果对 Redis 的(反)序列化做相应的合理配置
feature : 技术研究 --- 新增 poi-tl 基于 apache poi 的 office 工具; 新增 echarts-java 构建 html 节点树
feature : 易错问题 --- 新增 DateTest 类: 研究使用 Java8 前后的时间、日期类
feature : 易错问题 --- 完善 DateTest 类: 新增 LocalDateTime 日期计算与常用工具方法
feature : 易错问题 --- 新增 Reflect & Generics 错误测试类: 调试反射与范型的常见用法与坑
feature : 易错问题 --- 新增 AnnotationTest... 类: 研究测试 Annotation 类继承的情况
feature : 易错问题 --- 新增 Test/Bean 类: 探索单例 Bean 的作用域问题
file : 配置管理 --- 新增 nginx 生产环境配置管理同步脚本
file : 配置管理 --- 新增 K8S 工程项目部署配置文件以及脚本
```