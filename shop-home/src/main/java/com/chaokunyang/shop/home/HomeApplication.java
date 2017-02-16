package com.chaokunyang.shop.home;

import com.chaokunyang.shop.home.config.RootConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * 商城首页
 *
 * @author yangck
 * @create 2017-02-15 17:34
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker // 开启断路器功能
@Import(RootConfig.class)
public class HomeApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HomeApplication.class).web(true).run(args);
    }
}
