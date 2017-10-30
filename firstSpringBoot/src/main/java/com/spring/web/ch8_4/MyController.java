package com.spring.web.ch8_4;

import com.spring.entity.ch8.Person;
import com.spring.service.ch8_4.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangwei on 2017/10/30.
 */
@RestController
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
