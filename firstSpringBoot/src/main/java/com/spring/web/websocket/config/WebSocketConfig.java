package com.spring.web.websocket.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created by wangwei on 2017/10/11.
 * Spring Boot 对WebSocket的支持
 */
@Configuration
//@EnableWebSocketMessageBroker
public class WebSocketConfig{ //extends AbstractWebSocketMessageBrokerConfigurer {


    /**
     * 注册STOMP协议的节点，并映射指定的URL
     * @param stompEndpointRegistry
     */
    //@Override
    /*public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //注册一个STOMP的endpoint，并指定使用SocketJS协议
        stompEndpointRegistry.addEndpoint("/endpointTest").withSockJS();
    }

    *//**
     * 配置消息代理
     * @param registry
     *//*
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //广播式英配置一个/topic的消息代理
        registry.enableSimpleBroker("/topic");
    }*/
}
