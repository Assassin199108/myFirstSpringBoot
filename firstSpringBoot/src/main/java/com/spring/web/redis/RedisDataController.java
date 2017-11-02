package com.spring.web.redis;

import com.spring.dao.redis.RedisPersonDao;
import com.spring.entity.redis.RedisPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangwei on 2017/11/2.
 */
@RestController
@RequestMapping("/redis")
public class RedisDataController {

    @Autowired
    RedisPersonDao redisPersonDao;

    /**
     * 演示设置字符及对象
     */
    @RequestMapping("/set")
    public void set(){
        RedisPerson person = new RedisPerson("1","wangwei",29);
        redisPersonDao.save(person);
        redisPersonDao.stringRedisTemplateDemo();
    }

    /**
     * 演示获得字符
     * @return
     */
    @RequestMapping("/getStr")
    public String getStr(){
        return redisPersonDao.getString();
    }

    /**
     * 演示获得对象
     * @return
     */
    @RequestMapping("/getPerson")
    public RedisPerson getPerson(){
        return redisPersonDao.getPerson();
    }

}
