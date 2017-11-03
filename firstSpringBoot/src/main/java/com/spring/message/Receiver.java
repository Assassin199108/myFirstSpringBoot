package com.spring.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by wangwei on 2017/11/3.
 */
@Component
public class Receiver {

    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message){
        System.out.println("接收到：<"+ message +">");
    }

    @RabbitListener
    public void receiveRabbitMQ(String message){
        System.out.println("接收到：<"+ message +">");
    }

}
