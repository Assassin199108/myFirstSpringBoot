package com.spring.config.properties.endpoint;

import com.spring.service.endpoint.StatusService;
import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by wangwei on 2017/11/6.
 * 继承AbstractEndpoint重写invoke方法。实现ApplicationContextAware，可访问容器的资源
 */
//通过下面设置，我们可以在application.properties中通过endpoint.status配置我们的端点
@ConfigurationProperties(prefix = "endpoint.status",ignoreUnknownFields = false)
public class StatusEndPoint extends AbstractEndpoint<String> implements ApplicationContextAware {

    ApplicationContext context;

    public StatusEndPoint() {
        super("status");
    }

    /**
     * 返回我们要监考的内容
     * @return
     */
    @Override
    public String invoke() {
        StatusService statusService = context.getBean(StatusService.class);

        return "The Current Status is :"+statusService.getStatus();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
