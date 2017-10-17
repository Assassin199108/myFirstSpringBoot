package com.spring.config.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangwei on 2017/10/17.
 * Servlet启动类
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.spring")
@EnableAutoConfiguration
public class MVCApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MVCApplication.class);
    }

    public static void main(String[] args){
        SpringApplication.run(MVCApplication.class,args);
    }

}
