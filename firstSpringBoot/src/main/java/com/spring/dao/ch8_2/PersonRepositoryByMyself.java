package com.spring.dao.ch8_2;

import com.spring.dao.CustomRepository;
import com.spring.entity.ch8.Person;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wangwei on 2017/10/23.
 */
public interface PersonRepositoryByMyself extends CustomRepository<Person,Long> {

    List<Person> findByAddress(String address);

    //Person findByNameAndAddress(String name,String address);

    //Person withNameAndAddressQuery(@Param("name")String name, @Param("address")String address);

    //Person withNameAndAddressNamedQuery(String name,String address);
}
