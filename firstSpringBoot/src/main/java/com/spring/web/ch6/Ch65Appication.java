package com.spring.web.ch6;

import com.wangwei.spring_boot_starter_hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangwei on 2017/10/10.
 */
@RestController
@SpringBootApplication
public class Ch65Appication {

    @Autowired
    public HelloService helloService;


    @RequestMapping("/myHello")
    public String index(){
        return helloService.sayHello();
    }
    
    public static void main(String[] args){
        SpringApplication.run(Ch65Appication.class,args);
    }

}
