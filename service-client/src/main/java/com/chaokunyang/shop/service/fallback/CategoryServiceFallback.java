package com.chaokunyang.shop.service.fallback;

import com.chaokunyang.shop.model.Category;
import com.chaokunyang.shop.service.CategoryService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangck
 * @create 2017-02-16 17:25
 */
public class CategoryServiceFallback implements CategoryService {

    private Logger logger = LogManager.getLogger(getClass());

    @Override
    public Category get(@PathVariable("id") Long id) {
        logger.error("CATEGORY-SERVICE unavailable");
        return null;
    }

    @Override
    public Category save(@RequestParam Category category) {
        logger.error("CATEGORY-SERVICE unavailable");
        return null;
    }
}
