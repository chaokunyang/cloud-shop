package com.chaokunyang.shop.category.service.impl;

import com.chaokunyang.shop.category.repository.CategoryRepository;
import com.chaokunyang.shop.category.model.Category;
import com.chaokunyang.shop.category.service.CategoryService;
import com.chaokunyang.shop.commons.api.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Category> findByLevelAndName(Integer level, String name) {
        return categoryRepository.findByLevelAndName(level, name);
    }

//    @Override
//    public List<Category> findByParentId(Long parentId) {
//        return categoryRepository.findByParentId(parentId);
//    }
//
//    @Override
//    public List<Category> findByLevel(Integer level) {
//        return categoryRepository.findByLevel(level);
//    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
