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
        
day11一：
        Thymeleaf的自动配置类
        ThymeleafProperties