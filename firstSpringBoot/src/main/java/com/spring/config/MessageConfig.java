package com.spring.config;

import com.spring.message.Msg;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.integration.feed.inbound.FeedEntryMessageSource;
import org.springframework.jms.core.JmsTemplate;

/**
 * Created by wangwei on 2017/11/3.
 * Spring Boot为我们提供了CommandLineRunner接口，用于程序启动后执行的代码，通过重写其run方法执行
 */
@Configuration
@ComponentScan({"com.spring.message"})
public class MessageConfig implements CommandLineRunner {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 资源文件访问
     */
    @Value("https://spring.io/blog.atom")
    Resource resource;

    /**
     * 定义队列的目的地，队列名称为my-queue
     * @return
     */
    @Bean
    public Queue testQueue(){
        return new Queue("my-queue");
    }

    /**
     * 构造feed的入站通道适配器作为数据输入
     * @return
     * @throws Exception
     */
    @Bean
    public FeedEntryMessageSource feedEntryMessageSource() throws Exception{

        FeedEntryMessageSource news = new FeedEntryMessageSource(resource.getURL(), "news");

        return news;
    }



    @Override
    public void run(String... strings) throws Exception {
        //通过jmsTemplate的send方法向my-destination目的第发送Msg消息，这里等于在消息代理上定义一个目的地
        jmsTemplate.send("my-destination",new Msg());

        //向队列发送消息
        rabbitTemplate.convertAndSend("my-queue","来自RabbitM的问候");
    }

}
