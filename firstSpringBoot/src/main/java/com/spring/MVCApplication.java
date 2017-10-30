package com.spring;

import com.spring.dao.CustomRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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

    /*public static void main(String[] args){
        SpringApplication.run(MVCApplication.class,args);
    }*/

}
