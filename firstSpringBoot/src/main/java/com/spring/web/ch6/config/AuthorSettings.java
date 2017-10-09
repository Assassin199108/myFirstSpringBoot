package com.spring.web.ch6.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wangwei on 2017/10/9.
 * 配置与bean相结合
 */
@Component
@ConfigurationProperties(prefix = "author",locations = {"classpath:author.properties"})
public class AuthorSettings {

    private String name;

    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
