package com.spring.web.ch5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangwei on 2017/10/9.
 */
@RestController
@SpringBootApplication//SpringApplication是Spring Boot的项目核心注解主要母的是开启自动配置
public class Ch522Application {

    @Value("${book.author}")
    private String bookAuthor;

    @Value("${book.name}")
    private String bookName;

    @RequestMapping("/")
    String index(){
        return "Hello Spring Boot!wang";
    }

    @RequestMapping("/book")
    String bookName(){
        return "book name is "+bookName+"and book author is:"+bookAuthor;
    }

    public static void main(String[] args){
        //
        //SpringApplication.run(Ch522Application.class,args);

        new SpringApplicationBuilder(Ch522Application.class).showBanner(false).run(args);
    }

}
