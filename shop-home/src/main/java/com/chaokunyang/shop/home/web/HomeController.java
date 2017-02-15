package com.chaokunyang.shop.home.web;

import com.chaokunyang.shop.home.service.CategoryService;
import com.chaokunyang.shop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yangck
 * @create 2017-02-15 17:41
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        Category category = categoryService.getCategory(1L);
        // 轮播
        // 楼层
        model.put("category", category);
        // 轮播
        // 楼层
        return "home";
    }
}
