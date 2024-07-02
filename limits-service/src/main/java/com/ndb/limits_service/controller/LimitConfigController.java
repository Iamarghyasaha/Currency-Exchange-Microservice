package com.ndb.limits_service.controller;

import com.ndb.limits_service.bean.LimitConfiguration;
import com.ndb.limits_service.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigController {

    @Autowired
    private Configuration configuration;
    @GetMapping("/limits")
    public LimitConfiguration retriveLimitConfiguration(){
        return  new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
    }
}
