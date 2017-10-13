package com.spring.web.ch7;

import com.spring.entity.ch7.WangweiMessage;
import com.spring.entity.ch7.WangweiResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by wangwei on 2017/10/11.
 */
@Controller
public class MessageController {

    @MessageMapping("/welcome")//当浏览器向服务器发送请求时通过该映射地址，类似requestMapping
    @SendTo("/topic/getResponse")//打个服务器端有消息时，会对订阅了该路径中的浏览器发送消息
    public WangweiResponse say(WangweiMessage message) throws Exception{
        Thread.sleep(3000);
        return new WangweiResponse("Welcome, "+ message.getName()+"!");
    }

    public static void main(String[] args){
        SpringApplication.run(MessageController.class,args);
    }
}
