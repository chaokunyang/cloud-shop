package com.chaokunyang.shop.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 轮播
 *
 * @author yangck
 * @create 2017-02-16 17:34
 */
@Controller
@RequestMapping("/")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String admin(Map<String, java.lang.Object> model) {
        // 获取数据并放入model
        return "admin";
    }

}
