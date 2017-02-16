package com.chaokunyang.gateway;

import com.chaokunyang.gateway.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * API网关
 *
 * @author yangck
 * @create 2017-02-16 14:06
 */
@SpringCloudApplication // 相当于@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker的组合
@EnableZuulProxy
public class ApiGatewayApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ApiGatewayApplication.class).web(true).run(args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
