package com.spring.web.transaction;

import com.spring.entity.oracle.Person;
import com.spring.service.cache.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangwei on 2017/10/30.
 */
@RestController
@RequestMapping("/transaction")
public class MyController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/rollback")
    public Person rollback(Person person){

        return demoService.savePersonWithRollBack(person);
    }

    @RequestMapping("/norollback")
    public Person noRollback(Person person){

        return demoService.savePersonWithOutRollBack(person);
    }

}
