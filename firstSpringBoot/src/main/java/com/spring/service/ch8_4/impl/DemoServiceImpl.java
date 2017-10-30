package com.spring.service.ch8_4.impl;

import com.spring.dao.ch8.PersonRepository;
import com.spring.entity.ch8.Person;
import com.spring.service.ch8_4.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangwei on 2017/10/30.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional(rollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);

        if (person.getName().equals("王伟")){
            throw new IllegalArgumentException("王伟已经存在，数据将回滚");
        }

        return p;
    }

    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithOutRollBack(Person person) {
        Person p = personRepository.save(person);

        if (person.getName().equals("王伟")){
            throw new IllegalArgumentException("王伟虽已经存在，数据不会回滚");
        }

        return null;
    }
}
