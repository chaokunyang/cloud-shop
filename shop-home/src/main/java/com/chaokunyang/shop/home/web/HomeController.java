package com.chaokunyang.shop.home.web;

import com.chaokunyang.shop.home.service.CategoryService;
import com.chaokunyang.shop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangck
 * @create 2017-02-15 17:41
 */
@RestController
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    public Category getCategory() {
        return null;
    }
}
