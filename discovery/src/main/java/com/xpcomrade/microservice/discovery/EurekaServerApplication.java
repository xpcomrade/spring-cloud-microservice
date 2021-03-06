package com.xpcomrade.microservice.discovery;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by xpcomrade on 2016/12/15.
 * Copyright (c) 2016, xpcomrade@gmail.com All Rights Reserved.
 * Description: (服务注册中心). <br/>
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
    }
}
