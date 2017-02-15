package com.chaokunyang.shop.home.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 首页服务Service
 *
 * @author yangck
 * @create 2017-02-15 11:10
 */
@EnableDiscoveryClient
@SpringBootApplication
public class HomeServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HomeServiceApplication.class).web(true).run(args);
    }
}
