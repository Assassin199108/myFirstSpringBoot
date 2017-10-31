package com.spring.entity.ch8_6;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Created by wangwei on 2017/10/31.
 */
@Document//映射领域模型和MongoDB的文档
public class MongoPerson {

    @Id
    private String id;
    private String name;
    private Integer age;

    //此属性在文档中的名称为locs,locations属性将以数组形式存在当前数据记录中
    @Field(value = "locs")
    private Collection<Location> locations = new LinkedHashSet<Location>();

    public MongoPerson() {

    }

    public MongoPerson(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public MongoPerson(String id, String name, Integer age, Collection<Location> locations) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.locations = locations;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Collection<Location> getLocations() {
        return locations;
    }

    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }
}
