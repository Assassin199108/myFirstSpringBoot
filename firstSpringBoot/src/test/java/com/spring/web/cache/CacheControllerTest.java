package com.spring.web.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.MVCApplication;
import com.spring.entity.oracle.Person;
import com.spring.service.cache.DemoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by wangwei on 2017/11/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MVCApplication.class)
@WebAppConfiguration//指定加载 ApplicationContext是一个WebApplicationContext
@Transactional//使用@Transactional注解，确保每次测试后的数据将会被回滚
public class CacheControllerTest {

    @Autowired
    DemoService demoService;

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    String expectedJson;

    /**
     * 初始化mockMvc
     * @throws JsonProcessingException
     */
    @Before
    public void startUp() throws JsonProcessingException{

        Person person = new Person();
        person.setId(1l);

        expectedJson = Obj2Json(demoService.findOne(person));
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * 将对象转换成json字符串
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    protected String Obj2Json(Object obj) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    @Test
    public void testPersonController() throws Exception{

        String url = "/cache/able";
        //获得一个request的执行结果
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON).param("id","1")).andReturn();

        //获得request执行结果的状态
        int status = result.getResponse().getStatus();

        //获得request执行结果的内容
        String content = result.getResponse().getContentAsString();

        //将预期字符串和返回字符串比较
        Assert.assertEquals("错误，正确的返回值为200",200,status);
        Assert.assertEquals("错误，返回值和预期返回值不一致",expectedJson,content);
    }

}