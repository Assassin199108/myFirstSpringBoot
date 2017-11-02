package com.spring.dao.ch8;

import com.spring.entity.oracle.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by wangwei on 2017/10/17.
 * Person的dao层JPA接口
 */
//定制节点路径
@RepositoryRestResource(path = "people")
public interface PersonRepository extends JpaRepository<Person,Long> {

    //使用方法名查询,结束一个name参数，返回值为列表
    List<Person> findByAddress(String name);

    //使用方法名查询,接受name和address，返回值为单个对象
    Person findByNameAndAddress(String name,String address);

    //使用Query查询，参数安装名称绑定
    @Query("select p from  Person p where p.name=:name and p.address=:address")
    Person withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);

    //使用@NamedQuery查询，请注意我们在实体类中做的@NamedQuery定义
    Person withNameAndAddressNamedQuery(String name,String address);

    @RestResource(path = "nameStartsWith",rel = "nameStartsWith")
    Person findByNameStartsWith(@Param("name")String name);
}
