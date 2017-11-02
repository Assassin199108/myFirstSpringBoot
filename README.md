# myFirstSpringBoot
我的第一个spring boot项目（基于Maven构建）

day10一：Spring Boot
        1、@SpringApplication是Spring Boot的项目核心注解主要母的是开启自动配置;
        2、
        application.properties
        是SpringBoot的全局配置文件
        作用是对一些默认配置的配置值进行修改
        3、
        Negative matches:
        未启用的自动配置
        Positive matches
        已经启用的自动配置
        4、
        条件注解的子类
        @ConditionOnBean:当容器里有指定的Bean条件
        @ConditionOnClass:当类路径下有指定的类条件
        @ConditionOnExpression:基于SpEL表达式作为判断条件
        @ConditionOnJava:基于JVM版本作为判断条件
        @ConditionOnJndi:在JNDI存在的条件下查找指定的位置
        @ConditionOnMissingBean:当容器里没有指定的类的条件下
        @ConditionOnMissingClass:当类路径下没有指定的类的条件
        @ConditionOnNotWebApplication:当前项目不是Web项目的条件下
        @ConditionOnProperty:指定的属性是否有指定的值
        @ConditionOnResource:类路径是否有指定的值
        @ConditionOnSingleCandidate:当指定Bean在容器中有一个，或者虽然有多个但是指定首选的Bean
        @ConditionOnWebApplication:当前项目是Web项目的条件下
        
day11一：1:
        Thymeleaf的自动配置类
        ThymeleafProperties
        2:
        WebMVC自配配置类:
            WebMvcProperties
        自动装配Bean类:
            WebMvcAutoConfiguration
            a:ContentNegotiatingViewResolver
            MVC特俗的ViewResolver,并非自己处理view，而是代理给不同的ViewResolver处理
            b:BeanNameViewResolver
            
            c:InternalResourceViewResolver
            
        3:静态资源
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/"
            
        4:接管Spring Boot的Web配置
        注解Configuration并且继承WebMvcConfigurerAdapter
        会自己配置的与Spring Boot配置同时有效
        
        5:注册Servlet Filter Listener
        注册Bean
            a:ServletRegistrationBean
            b:FilterRegistrationBean
            c:ServletListenerRegistrationBean
            
        
        
day12一：
        @{}是引用Web静态资源
        
        Tomcat的配置
        自动配置类:
            ServerProperties
            
        代码配置Tomcat 等server容器
        可以注册一个实现了EmbeddedServletContainerCustomizer接口的Bean;
        --EmbeddedServletContainerCustomizer
               |
               |--TomcatEmbeddedServletContainerFactory
               |--JettyEmbeddedServletContainerFactory
               |--UndertowEmbeddedServletContainerFactory
               
        SSL 的安全Https的配置
        server.ssl.key-store=
        server.ssl.key-store-password=
        server.ssl.key-store-type=JKS
        
        对WebSocket支持
        源码路径:org.springframework.boot.autoconfigure.websocket
        
        广播式
        重写方法配置WebSocket，步骤：
        1：配置类@configuration
        2：使用EnableWebSocketMessageBroker开启websocket支持
        3：继承AbstractWebSocketMessageBrokerConfigurer
        
        
        
day13 一：
        AngularJS
        使用声明式模板+数据绑定，可以只通过前端技术就实现动态页面
        下载地址：https://angularjs.org/
        
        
day 14 

        一：
        Docker镜像的搜索
        https://hub.docker.com/search/?isAutomated=0&isOfficial=0&page=1&pullCount=0&q=&starCount=0
        or
        docker search 镜像名称
        docker api(各种操作)
            docker pull **(下载镜像)
            docker images (镜像列表)
            docker rmi image-id(删除镜像)
            docker run --name container -name -d image-name (运行镜像)
            docker run -d -p 6378:6379 --name ** image
            docker ps =a (查看运行和停止状态的容器)
            docker stop container-name/container-id
            docker start container-name/container-id
            docker run -d -p 6378:6379 --name port-redis redis
            docker rm container-id (删除容器)
            docker rm $(docker ps -a -q) (删除所有容器)
            docker logs container-name/container-id (查看当前容器日志)
            docker exec -it container-id/container-name bash 登录容器
            
        二：Spring Data JPA
            在Spring环境中，可通过@EnableJpaRepositories注解开启Spring Data JPA的支持
            @EnableJpaRepositories(value = "扫描数据访问层所在报下的数据访问接口的定义")
            ---
             |--Repository
                    |
                    |--CrudRepository(增删改查)
                            |
                            |--PagingAndSortingRepository(分页)
                                        |
                                        |--JpaRepository(jpa)
                                        
             JPA接口定义中的模糊方法查询名称与参数名称
             关键子：
             And
             Or
             Is,Equals
             Betweem
             LessThan
             LessThanEqual
             GreaterThan
             GreaterThanEqual
             After
             Before
             IsNull
             IsNotNull,NotNull
             Like
             NotLike
             StartingWith
             EndingWith
             Containing
             OrderBy
             Not
             In
             NotIn
             True
             False
             IgnoreCase
             
                b、限制结果集:top和first关键字
                c、使用@NamedQuery查询注解在实体类上的
                d、使用@Query查询 注解接口定义的方法上
                e、支持@Modifying 和 @Query注解组合时间更新查询
                f、Spring提供JPA基于准则的查询方式Criteria查询的规范（Specification）接口更方便的构造准则查询
                g、排序与分页的支持  SpringDataJpa提供了Sort类以及Page接口和Pageable接口
                
        三：Spring Boot的支持
            配置文件 DataSourceProperties
            Bean自动加载文件 DataSourceAutoConfiguration
            
            自动开启事务的支持
            @EnableTransactionManagement
            配置了
            jdbcTemplate
            放置在类路径下的schema.sql会自动初始化表结构
            放置在类路径下的data.sql会自动填充表数据
            
        四Spring Boot对Jpa的支持
            配置文件 JpaProperties
            bean自动加载文件 HibernateJpaAutoConfiguration
            
        五Spring Boot对Spring Data JPA的支持
            依赖spring-boot-starter-data-jpa
            定义DataSource、实体类和数据访问层
            bean自动加载文件  JpaRepositoriesAutoConfiguration和JpaRepositoriesAutoConfigureRegistrar
            
day 15
        一：Spring Boot 运行在第三方Tomcat
            去除內嵌tomcat
            增加Servlet依赖
            继承 SpringBootServletInitializer ，Servlet3.0 重新Servlet onstartUp 
            重新配置WebMVC配置文件
            
day 16 
        一、完成Spring boot +Spring data jpa + 自定义第三方Tomcat整合
            因包未扫描到实体类
            SpringBoot默认扫描包没包括自己的，自己重新定义LocalContainerEntityManagerFactoryBean
            并开启EnableJpaRepositories 扫描dao层
        二、因 公司 强制加班，今天未能好好学习，晚安吧，明天会更好
        
day 17
       
        一、
        
            JpaRepositoryFactoryBean 的作用
           * 1:我们会获得一个RepositoryFactory
           * 2:将会注册我们自定义的Repositiry的实现
           
day18

        一、
            Spring Data REST
            可以将Repository自动输出为REST资源
            自定义配置类：RepositoryRestMvcConfiguration
            自定义参数配置类 RepositoryRestConfiguration 在上面的config方法中
            他们的子类SpringBootRepositoryRestMvcConfiguration将此方法加入到SpringBoot自动配置类中
            RepositoryRestMvcAutoConfiguration讲bean交由到Spring ioc容器管理
            
            我们可以通过继承RepositoryRestMvcConfiguration此类或者直接在直接的配置类上@Import(RepositoryRestMvcAutoConfiguration讲bean交由到Spring.class)配置类
            
            在application.properties配置"spring.data.rest"为前缀配置属性来设置RepositoryResrConfiguration
            
day 19

        一、Spring事务管理机制
            提供了PlantFormTransactionManager接口
            不同的数据访问技术提供不同的接口实现
            
            数据访问技术                          实现
                JDBC                DataSourceTransactionManager
                JPA                 JpaTransactionManager
                Hibernate           HibernateTransactionManager
                JDO                 JdoTransactionManager
                分布式事务           JtaTransactionManager
                
        二、实现 声明式事务
            @Transactional注解 基于Aop的实现操作
            在配置类上开启声明式事务@EnableTransactionManagement 自动扫描@Transactional注解
            事务的属性
            a、propagationtion
            定义了事务的生命周期，选项
            1:REQUIRED(默认):方法A没有事务创建事务，调用方法B的时候，B使用相同事务，B异常，整个数据回滚
            2:REQUIRES_NEW:对于方法A和B，在方法调用的时候无论是否有事务，都开启新事务，方法B回滚不会使方法A回滚
            3:NESTED:和REQUIRES_NEW类似，但支持JDBC，不支持JPA或Hibernate
            4:SUPPORTS:方法调用有事务就用事务，没就不用
            5:NOT_SUPPORTED:强制方法不在事务中执行，若有事务，则方法调用到结束阶段事务都将会被挂起
            6:NEVER:强制方法不在事务中执行，若有事务则抛出异常
            7:MANDATORY:强制方法在事务中执行，若无事务则抛出异常
            
            b、isolation
            觉得事务的完整性,处理在多食物对相同数据下的处理机制，主要有一下隔离级别
            1:READ_UNCOMMITTED:对于A事务修改了一条记录单没有提及事务，在B事务可以读取到修改后的记录。可导致脏读，不可重复读及幻读
            2:READ_COMMITTED:只有A事务修改记录并提及事务后，B事务才可以读取到提交后的记录；阻止脏读，但可能导致不可重复读和幻读
            3:REPEATABLE_READ:不仅能实现READ_COMMITTED的功能，还阻止当A事务读取了一条记录，B事务将不允许修改这条记录;阻止脏读和不可重复读，但可出现幻读
            4:SERIALIZABLE:此级别下事务是顺序执行的，可以避免上述级别的缺陷，但开销较大
            5:DEFAULT(默认):ORACLE、SQL Server是READ_COMMITED;Mysql是REPEATABLE_READ
            
            c、timeout
            指事务过期时间，默认为当前数据库事务过期时间
            
            d、readOnly
            指定当前事务是否是只读事务
            
            e、rollbackFor
            指定哪个或者哪些异常可以引起事务回滚
            
            f、noRollbackFor
            指定哪个或哪些异常不可以引起回滚事务
            
            Spring Boot专门用于配置的事务类TransactionAutoConfiguration
            
            
day 20
    
        一：缓存Cache
        Spring定义了CacheManager 和 Cache接口用来统一不同的缓存技术
        CacheManager：spring提供的各种缓存技术抽象接口
        1：SimpleCacheManager 使用简单的Collection来存储缓存，主要用来测试用途
        2：ConcurrentMapCacheManager：使用ConcurrentMap来存储缓存
        3：NoOpCacheManager：仅测试用途，不会实际存储缓存
        4：EhCacheCacheManager：使用EhCacheCache作为缓存技术
        5：GuavaCacheManager：使用Goole Guava的GuavaCache作为缓存技术
        6：HazelcastCacheManager：使用Hazelcast作为缓存技术
        7：JCacheCacheManager：支持JCache(JSR-107)标准的实现作为缓存技术
        8：RedisCacheManager： 使用Redis作为缓存技术
        
        二：声明式缓存注解(AOP)
        @Cacheable：在方法执行前Spring查看缓存中是否有数据，有数据，则返回缓存数据，没有将返回值放入缓存
        @CachePut：无论怎样，都会讲方法的返回值放到缓存中。@CachePut的属性与@Cacheable保持一致
        @CacheEvict：将一条或多条数据从缓存中删除
        @Caching：可以通过@Caching注解组合多个注解策略在一个方法上
        
        三：开启声明式缓存
        @EnableCaching
        
        四：Spring Boot 支持
        关键Bean：CacheManager——自动配置类放在org.springframework.boot.autocinfigure.cache
        例：EhCacheCacheConfiguration(使用EhCache)
        配置文件类：CacheProperties
        默认使用的是SimpleCacheConfiguration，即使用ConcurrentMapCacheManager
        需要自己开启配置缓存
            
        五：tips
        如果没有指定key，则方法参数作为key保存到缓存中
        
        六：切换缓存技术
            1:EhCache
                a:导包 net.sf.ehcache
                b:配置文件ehcache.xml放在类路径下，spring boot会自动扫描
                c:spring boot 自动创建EhCacheCacheManager bean
            2:Guava
                a:导包 guava
                b:spring boot 自动创建GuavaCacheManager
            3:redis
                a:导包 spring-boot-starter-redis
                b:spring boot 自动创建RedisCacheManager以及RedisTemplate的bean
        
        七：NOSQL
            主要有文档存储型(MongoDB)、图片关系存储型(Neo4j)和键值对存储型(Redis)
            1:MongoDB
                Spring的支持：Spring Data MongoDB提供如下功能
                a：Object/Document映射注解支持(类似JPA提供一套Object/Relation映射的注解)
                    @Document:映射领域对象与MongoDB的一个文档
                    @Id:映射当前属性是ID
                    @DbRef：当前属性将参考其他的文档
                    @Field：为文档的属性定义名称
                    @Version：将当前属性作为版本
                b:MongoTemplate(类似JdbcTemplate)
                    数据访问方法，我们需要为MongoClient以及MongoDbFactory配置数据库连接属性
                    
                c:Repository的支持(类似Spring Data JPA的Repository)
                
                d:配置类开启@EnableMongoRepositories
                
                Spring Boot的支持
                需要导入包
                spring-boot-starter-data-mongodb
                配置文件位于:org.springframework.boot.autoconfiure.mongo
                2个自动配置类：
                    MongoAutoConfiguration
                    MongoDataAutoConfiguration
                配置文件:MongoProperties
                
                e:继承语法
                如果想创建一个数据库名称为 <mydb>, 那么 use DATABASE 语句应该如下
                use mydb
                
                要检查当前选择的数据库使用命令 db
                
                如果想查询数据库列表，那么使用命令 show dbs.
                
                所创建的数据库（mydb）不存在于列表中。要显示的数据库，需要至少插入一个文档进去
                db.movie.insert({"name":"yiibai tutorials"})
                
                删除数据库
                MongoDB db.dropDatabase() 命令用于删除现有的数据
                
                创建集合
                db.createCollection(name, options) 用于创建集合
                
                删除集合
                MongoDB 的 db.collection.drop() 用于从数据库中删除集合
                
                insert()命令的基本语法如下：
                db.COLLECTION_NAME.insert(document)
                
                查询文档
                要从集合查询MongoDB数据，需要使用MongoDB的 find()方法
                
                find() 方法将在非结构化的方式显示所有的文件。 如果显示结果是格式化的，那么可以用pretty() 方法。
                db.mycol.find().pretty()
                
day 21

        一、Redis
            Spring对Redis的支持
            Spring Data Redis
            为我们提供了RedisTemplate和StringRedisTemplate两个模板来进行数据操作
                其中StringRedisTemplate对键值都是字符型的数据进行操作
                
            常用方法 (对数据访问)
            opsForValue
            opsForList
            opsForSet
            opsForZSet
            opsForHash
            
            ****原理****
            当我们的数据存储到Redis的时候，我们的Key和Value都是通过Spring提供的Serializer序列化到数据库
            默认使用JdkSerializationRedisSerializer(二进制形式存储的数据)
            
        二、Spring Boot的支持
            包路径：org.springframework.boot.autoconfigure.redis
            自动配置类RedisAutoConfiguration
            默认为我们配置了(JedisConnectionFactory、RedisTemplate、StringRedisTemplate)
            属性配置类RedisProperites
            
            添加Jar包依赖
            spring-boot-starter-redis
            
            实体类必须实现序列化，并且有个空构造函数 Jackson做序列化需要一个空构造
            
            
        三、Spring boot 配置的数据存储序列不雅观 ，我们自定义序列存储
            采用value序列化 Jackson2JsonRedisSerializer
            设置键Key序列化采用StringRedisSerializer
            在配置文件中配置 重新配置bean RedisTemplate
            
            
day22
        
        一、Spring Security
            安全框架的两个重要概念：认证(Authentication)和授权(Authorization)
            认证 确认用户可以访问当前系统
            授权 确认用户在当前系统下拥有的权限
            
        二、配置
            1:Spring Security为我们提供了多个过滤器实现安全功能，我们只需之策DelegatingFilterProxy过滤器
            我们只需要继承AbstractWebApplicationInitializer抽象类即可，该类实现了WebApplicationinitializer接口
            它为我们注册了DelegatingFilterProxy
        
            2:开启安全监测 与 MVC类似 添加注解@EnableWebSecurity 并继承WebSecurityConfigurerAdapter
            
        三、用户认证
            重写configure(AuthenticationManagerBuilder auth)
                auth查询各种用户
                1:内存用户
                    inMemoryAuthentication()
                2:JDBC用户
                    auth.jdbcAuthentication().dataSource(source);
                3:通用用户 自定义一个service实现UserDetailService接口
                    并在configure注册 auth.userDetailService(上类的 bean);
                    
        四、请求授权
            重写configure(HttpSecurity http)
                1:antMatchers:使用Ant风格的路径匹配
                2:regexMatchers：使用正则表达式匹配路径
        
            
        五、Spring Boot的支持
            配置包:org.springframework.boot.autoconfigure.security
            自动配置类SecurityAutoConfiguration
            自配属性类SecurityProperties
            
            1、自动配置内存中用户 账号为user 密码程序启动出现
            2、忽略/css/、/images/、/**/favicon.ico等静态文件
            3、自动配置securityFilterChainRegistration的Bean
            
            自定义扩展的时候我们主需要继承WebSecurityConfigurerAdapter即可
            
            需要导入jar包spring-boot-starter-security
            
 
day 23
        
        一、异步消息
            概念：消息代理和目的地
            1：点对点式(一个发送者，一个接受者)
            2：发布/订阅
            
        二、企业级消息代理
            JMS即Java消息服务
            ActiveMQ、HornetQ是一个JMS消息代理的实现
            
            AMQP是消息代理的规范、不仅兼容JMS、还支持跨语言和平台。
            主要实现由RabbitMQ
            
        三、Spring的支持
            JMS：spring-jms
            AMQP:Spring-rabbit
            
            需要ConnectionFactory实现来连接消息代理
            分别体用了JmsTemplate和RabbitTemplate来发送消息
            
            提供了@JmsListener @RabbitListener注解在方法上监听消息代理发布的消息
            通过@EnableJms、@EnableRabbit开启支持
            
        四、Spring Boot的支持
            配置包路径：org.springframework.boot.autoconfigure.jms