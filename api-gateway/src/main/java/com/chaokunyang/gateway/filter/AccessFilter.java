package com.chaokunyang.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * 访问权限管理
 *
 * @author yangck
 * @create 2017-02-16 14:15
 */
public class AccessFilter extends ZuulFilter {

    private final Logger logger = LogManager.getLogger(getClass());

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
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            logger.warn("access token is empty");
            context.setSendZuulResponse(false); // 令zuul过滤该请求，不对其进行路由
            context.setResponseStatusCode(401); // 未授权访问
        }

        logger.info("access token is authorized");
        return null;
    }
}
