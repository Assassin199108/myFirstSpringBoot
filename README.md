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
            
            