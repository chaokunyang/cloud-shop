package com.chaokunyang.shop.cms;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * CMS 内容管理服务
 *
 * @author chaokunyang
 * @create 2017/2/17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CmsApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CmsApplication.class).web(true).run(args);
    }
}
