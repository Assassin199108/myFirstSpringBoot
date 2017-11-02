package com.spring.dao.redis;

import com.spring.entity.redis.RedisPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by wangwei on 2017/11/2.
 */
@Repository
public class RedisPersonDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valOps;

    /**
     *存储字符串类型
     */
    public void stringRedisTemplateDemo(){
        valOpsStr.set("xx","yy");
    }

    /**
     * 存储对象
     * @param person
     */
    public void save(RedisPerson person){
        valOps.set(person.getId(),person);
    }

    public String getString(){
        return  valOpsStr.get("xx");
    }

    public RedisPerson getPerson(){
        return (RedisPerson) valOps.get("1");
    }

}
