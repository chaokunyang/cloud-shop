package com.chaokunyang.shop.category.service;

import com.chaokunyang.shop.category.model.Category;
import org.springframework.stereotype.Service;

/**
 * @author chaokunyang
 * @create 2017/2/15
 */
public interface CategoryService {

    Category findOne(Long id);

    Category save(Category category);
}
