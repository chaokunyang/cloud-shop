package com.chaokunyang.shop.admin.service;

import com.chaokunyang.shop.admin.service.fallback.CategoryServiceFallback;
import com.chaokunyang.shop.model.Category;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 分类客户端
 *
 * @author yangck
 * @create 2017-02-16 17:14
 */
@FeignClient(value = "CATEGORY-SERVICE", fallback = CategoryServiceFallback.class)
public interface CategoryService {

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    Category get(@PathVariable("id") Long id);

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    Category save(@RequestParam Category category);
};
