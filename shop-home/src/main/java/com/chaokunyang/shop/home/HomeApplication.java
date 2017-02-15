package com.chaokunyang.shop.home;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 商城首页
 *
 * @author yangck
 * @create 2017-02-15 17:34
 */
@SpringBootApplication
public class HomeApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HomeApplication.class).web(true).run(args);
    }
}
