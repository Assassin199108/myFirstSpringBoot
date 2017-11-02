package com.spring.web.repository;

import com.spring.dao.ch8.PersonRepository;
import com.spring.entity.oracle.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangwei on 2017/10/17.
 */
@RestController
@RequestMapping("/repository")
public class DataController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(String name,String address,Integer age){
        Person p = personRepository.save(new Person(null,name,age,address));

        return p;
    }

    /**
     * 测试findByAddress
     * @param address
     * @return
     */
    @RequestMapping("/q1")
    public List<Person> q1(String address){
        return personRepository.findByAddress(address);
    }

    /**
     * 测试 findByNameAndAddress
     * @param name
     * @param address
     * @return
     */
    @RequestMapping("/q2")
    public Person q2(String name,String address){
        return personRepository.findByNameAndAddress(name,address);
    }

    /**
     * 测试withNameAndAddressQuery
     * @param name
     * @param address
     * @return
     */
    @RequestMapping("/q3")
    public Person q3(String name,String address){
        return personRepository.withNameAndAddressQuery(name, address);
    }

    /**
     * 测试withNameAndAddressNamedQuery
     * @param name
     * @param address
     * @return
     */
    @RequestMapping("/q4")
    public Person q4(String name,String address){
        return personRepository.withNameAndAddressNamedQuery(name,address);
    }

    /**
     * 测试排序
     * @return
     */
    @RequestMapping("/sort")
    public List<Person> sort(){
        return personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
    }

    /**
     * 测试分页
     * @return
     */
    @RequestMapping("/page")
    public Page<Person> page(){
        return personRepository.findAll(new PageRequest(1,2));
    }
}
