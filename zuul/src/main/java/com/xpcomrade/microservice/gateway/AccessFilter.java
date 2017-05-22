package com.xpcomrade.microservice.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xpcomrade on 2016/12/19.
 * Copyright (c) 2016, xpcomrade@gmail.com All Rights Reserved.
 * Description: TODO(这里用一句话描述这个类的作用). <br/>
 */
public class AccessFilter extends ZuulFilter {


    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /*
    * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
      pre：可以在请求被路由之前调用
      routing：在路由请求时候被调用
      post：在routing和error过滤器之后被调用
      error：处理请求时发生错误时被调用
    */

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("accessToken");

        if (accessToken == null) {
            logger.warn("access token is empty");
            ctx.setSendZuulResponse(true);
            ctx.setResponseBody("access token is empty");
            ctx.setResponseStatusCode(401);

            return null;
        }

        logger.info("access token ok");
        return null;

    }
}
