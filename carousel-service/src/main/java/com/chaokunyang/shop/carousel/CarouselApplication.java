package com.chaokunyang.shop.carousel;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 轮播服务
 *
 * @author yangck
 * @create 2017-02-16 10:14
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CarouselApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CarouselApplication.class).web(true).run(args);
    }
}
