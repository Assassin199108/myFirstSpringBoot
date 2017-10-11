package com.spring.entity.ch7;

/**
 * Created by wangwei on 2017/10/11.
 * 服务器端向浏览器发送的此类消息
 */
public class WangweiResponse {

    private String responseMessage;

    public WangweiResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
