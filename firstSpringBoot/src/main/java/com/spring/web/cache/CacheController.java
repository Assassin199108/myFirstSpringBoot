package com.spring.web.cache;

import com.spring.entity.oracle.Person;
import com.spring.service.ch8_4.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangwei on 2017/10/31.
 * 缓存控制器测试
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/put")
    public Person put(Person person){
        return demoService.save(person);
    }

    @RequestMapping("/able")
    public Person cacheable(Person person){
        return demoService.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id){
        demoService.remove(id);
        return "ok";
    }

    @RequestMapping("update")
    public Person update(Person person){
        return demoService.update(person);
    }

}
