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