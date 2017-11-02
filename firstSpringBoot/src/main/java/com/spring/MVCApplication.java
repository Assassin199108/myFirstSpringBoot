package com.spring;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.dao.CustomRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by wangwei on 2017/10/17.
 * Servlet启动类
 */
@Primary
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.spring.dao","com.spring.entity","com.spring.web","com.spring.service"})
@EnableAutoConfiguration
//对自定义的Repository生效
@EnableJpaRepositories(basePackages = {"com.spring.dao"},entityManagerFactoryRef = "entityManagerFactory2",repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
@Import({RepositoryRestMvcAutoConfiguration.class})
//开启缓存注解
@EnableCaching
public class MVCApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MVCApplication.class);
    }

    @Autowired
    private EntityManagerFactoryBuilder builder;

    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private JtaTransactionManager jtaTransactionManager;

    @Autowired
    private JpaProperties jpaProperties;

    @Bean(name = "entityManagerFactory2")
    @Primary
    //@ConditionalOnBean({EntityManagerFactoryBuilder.class,DataSource.class})
    public LocalContainerEntityManagerFactoryBean entityManagerFactory2() {
        return builder.dataSource(this.dataSource).properties(getVendorProperties(dataSource)).packages(getPackagesToScan()).jta(isJta()).build();
    }

    private Map<String, ?> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    protected final boolean isJta() {
        return (this.jtaTransactionManager != null);
    }

    private String[] getPackagesToScan(){
        return new String[]{"com.spring.entity"};
    }

    /**
     * 重新配置redisTemplate，修改序列化
     * @param redisConnectionFactory
     * @return
     * @throws Exception
     */
    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws Exception{
        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<Object,Object>();

        redisTemplate.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        return redisTemplate;
    }

    /*public static void main(String[] args){
        SpringApplication.run(MVCApplication.class,args);
    }*/

}
