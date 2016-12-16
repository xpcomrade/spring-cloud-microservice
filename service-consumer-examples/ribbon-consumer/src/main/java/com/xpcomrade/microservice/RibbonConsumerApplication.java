package com.xpcomrade.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xpcomrade on 2016/12/15.
 * Copyright (c) 2016, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
@SpringBootApplication
@EnableDiscoveryClient //通过@EnableDiscoveryClient注解来添加发现服务能力
public class RibbonConsumerApplication {

    @Bean
    @LoadBalanced //通过@LoadBalanced注解开启均衡负载能力
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main( String[] args ) {
        SpringApplication.run(RibbonConsumerApplication.class, args);
    }
}
