package com.spring.web.myrepository;

import com.spring.dao.ch8_2.PersonRepositoryByMyself;
import com.spring.entity.oracle.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangwei on 2017/10/23.
 */
@RestController(value = "dataController8_2")
@RequestMapping("/myrepository")
public class DataController {

    @Autowired
    private PersonRepositoryByMyself personRepository;

    @RequestMapping(value = "/auto")
    public Page<Person> auto(Person person){

        Page<Person> pagePeople = personRepository.findByAuto(person,new PageRequest(0,10));

        return pagePeople;
    }

}
