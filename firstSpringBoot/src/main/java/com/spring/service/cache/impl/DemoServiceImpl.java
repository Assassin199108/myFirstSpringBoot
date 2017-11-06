package com.spring.service.cache.impl;

import com.spring.dao.ch8.PersonRepository;
import com.spring.entity.oracle.Person;
import com.spring.service.cache.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangwei on 2017/10/30.
 */
@Service
@Transactional
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

    //缓存新增的或更新的数据到缓存，其中缓存名称为people，数据的key是person的id
    @CachePut(value = "people",key = "#person.id")
    @Override
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id、key为"+p.getId()+"数据做了缓存");
        return p;
    }

    //从缓存people中删除key为id的数据
    @CacheEvict(value = "people")
    @Override
    public void remove(Long id) {
        System.out.println("删除了id、key为："+id+"的数据缓存");
        personRepository.delete(id);
    }

    //缓存key为person的id数据到缓存people
    @Override
    @Cacheable(value = "people",key = "#person.id")
    public Person findOne(Person person) {
        Person p = personRepository.findOne(person.getId());
        System.out.println("为id、key为："+p.getId()+"数据做了缓存");
        return p;
    }

    @Override
    @Caching(
            evict = {
            @CacheEvict(value = "person",key = "#person.id")
            },
            put ={
                    @CachePut(value = "person",key = "#person.id")
            } )
    public Person update(Person person) {
        Person p = personRepository.findOne(person.getId());
        System.out.println("开始更新，并清除缓存");
        p.setAddress(person.getAddress());
        p.setAge(person.getAge());
        p.setName(person.getName());
        Person save = personRepository.save(p);

        return save;
    }
}
