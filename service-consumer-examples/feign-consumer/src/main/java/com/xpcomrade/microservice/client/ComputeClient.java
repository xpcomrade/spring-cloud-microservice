package com.xpcomrade.microservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xpcomrade on 2016/12/16.
 * Copyright (c) 2016, xpcomrade@gmail.com All Rights Reserved.
 * Description: (定义compute-service服务的接口). <br/>
 */
@FeignClient(value = "compute-service", fallback = ComputeClientHystrix.class)
//使用@FeignClient("compute-service")注解来绑定该接口对应compute-service服务
public interface ComputeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
