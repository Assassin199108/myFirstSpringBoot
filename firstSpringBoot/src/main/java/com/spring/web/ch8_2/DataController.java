package com.spring.web.ch8_2;

import com.spring.dao.ch8_2.PersonRepository;
import com.spring.entity.ch8.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangwei on 2017/10/23.
 */
@RestController
public class DataController {

    @Autowired
    private PersonRepository personRepository;

    public Page<Person> auto(Person person){

        Page<Person> pagePeople = personRepository.findByAuto(person,new PageRequest(0,10));

        return pagePeople;
    }

}
