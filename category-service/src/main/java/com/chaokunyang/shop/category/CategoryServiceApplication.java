package com.chaokunyang.shop.category;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 分类服务
 * @author yangck
 * @create 2017-02-15 14:37
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CategoryServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CategoryServiceApplication.class).web(true).run(args);
    }
}
