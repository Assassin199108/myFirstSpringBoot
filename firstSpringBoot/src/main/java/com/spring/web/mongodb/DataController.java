package com.spring.web.mongodb;

import com.spring.dao.ch8_6.MongoPersonRepository;
import com.spring.entity.mongodb.Location;
import com.spring.entity.mongodb.MongoPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by wangwei on 2017/10/31.
 * mongo测试
 */
@RestController(value = "mongoController")
@RequestMapping("/mongodb")
public class DataController {

    @Autowired
    private MongoPersonRepository mongoPersonRepository;

    //测试保存数据
    @RequestMapping("/save")
    public MongoPerson save(){
        MongoPerson p = new MongoPerson("wangwei",30);
        Collection<Location> locations = new LinkedHashSet<Location>();
        Location l1 = new Location("上海","2009");
        Location l2 = new Location("杭州","2010");
        locations.add(l1);
        locations.add(l2);

        p.setLocations(locations);
        return mongoPersonRepository.save(p);
    }

    //测试方法名查询
    @RequestMapping("/q1")
    public MongoPerson q1(String name){
        return mongoPersonRepository.findByName(name);
    }

    //测试@query查询
    @RequestMapping("/q2")
    public List<MongoPerson> q2(Integer age){
        return mongoPersonRepository.withQueryFindByAge(age);
    }

}
