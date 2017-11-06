package com.spring.web.endpoint;

import com.spring.service.endpoint.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangwei on 2017/11/6.
 */
@RestController
@RequestMapping("/endpoint")
public class StatusController {

    @Autowired
    StatusService statusService;

    @RequestMapping("/change")
    public String changeStatus(String status){

        statusService.setStatus(status);
        return "ok";
    }

}
