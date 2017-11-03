package com.spring.message;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by wangwei on 2017/11/3.
 * 消息定义类
 */
public class Msg implements MessageCreator{

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("测试消息");
    }

}
