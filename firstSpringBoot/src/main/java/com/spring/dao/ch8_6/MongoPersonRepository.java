package com.spring.dao.ch8_6;

import com.spring.entity.ch8_6.MongoPerson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by wangwei on 2017/10/31.
 */
public interface MongoPersonRepository extends MongoRepository<MongoPerson,String> {

    //支持方法名查询
    MongoPerson findByName(String name);

    //支持@Query查询,查询参数构造JSON字符串即可
    @Query("{'age' : ?0}")
    List<MongoPerson> withQueryFindByAge(Integer age);

}
