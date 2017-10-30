package com.spring.service.ch8_4;

import com.spring.entity.ch8.Person;

/**
 * Created by wangwei on 2017/10/30.
 */
public interface DemoService {

    Person savePersonWithRollBack(Person person);

    Person savePersonWithOutRollBack(Person person);

}
