package com.chaokunyang.shop.admin.web;

import com.chaokunyang.shop.admin.service.CarouselService;
import com.chaokunyang.shop.admin.service.CategoryService;
import com.chaokunyang.shop.model.Carousel;
import com.chaokunyang.shop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
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

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CarouselService carouselService;

    @RequestMapping(method = RequestMethod.GET)
    public String admin(Map<String, java.lang.Object> model) {
        Category category = categoryService.get(1L);
        List<Carousel> carousels = carouselService.carousels("home");
        model.put("category", category);
        model.put("carousels", carousels);
        return "admin";
    }

}
