package com.spring.web.ch6;

import com.spring.web.ch6.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangwei on 2017/10/9.
 */
@RestController
@SpringBootApplication
public class Ch623Application {

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/ch623")
    public String index(){
        return "author name is: "+authorSettings.getName()+" and author age is:"+authorSettings.getAge();
    }

    public static void main(String[] args){
        SpringApplication.run(Ch623Application.class,args);
    }
}
