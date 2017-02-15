package com.chaokunyang.shop.category.service.impl;

import com.chaokunyang.shop.category.data.CategoryRepository;
import com.chaokunyang.shop.category.model.Category;
import com.chaokunyang.shop.category.service.CategoryService;
import com.chaokunyang.shop.commons.api.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chaokunyang
 * @create 2017/2/15
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findOne(Long id) {
        Category category = categoryRepository.findOne(id);
        if (category == null)
            throw new ResourceNotFoundException(id);
        return category;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
