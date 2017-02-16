package com.chaokunyang.shop.category.service;

import com.chaokunyang.shop.category.model.Category;

import java.util.List;

/**
 * @author chaokunyang
 * @create 2017/2/15
 */
public interface CategoryService {

    Category findOne(Long id);

    List<Category>  findByLevelAndName(Integer level, String name);

    Category save(Category category);
}
