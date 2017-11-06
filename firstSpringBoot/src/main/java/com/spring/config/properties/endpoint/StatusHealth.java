package com.spring.config.properties.endpoint;

import com.spring.service.endpoint.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by wangwei on 2017/11/6.
 */
public class StatusHealth implements HealthIndicator {

    @Autowired
    StatusService statusService;

    @Override
    public Health health() {
        String status = statusService.getStatus();
        if (status==null||!status.equals("running")){
            //当status的值为非running时构造失败
            return Health.down().withDetail("Error","Not Running").build();
        }
        //取余情况运行成功
        return Health.up().build();
    }
}
