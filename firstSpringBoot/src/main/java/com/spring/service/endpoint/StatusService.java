package com.spring.service.endpoint;

import org.springframework.stereotype.Service;

/**
 * Created by wangwei on 2017/11/6.
 */
@Service
public class StatusService {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
