package com.chaokunyang.shop.category;

import com.chaokunyang.shop.category.data.CategoryRepository;
import com.chaokunyang.shop.category.model.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yangck on 2017/2/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CategoryServiceApplication.class)
public class CategoryServiceApplicationTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void test() {
        categoryRepository.save(new Category(null, null, "testCategory1", 1L));
        categoryRepository.save(new Category(null, null, "testCategory2", 100L));
        categoryRepository.save(new Category(null, null, "testCategory3", 200L));
        categoryRepository.save(new Category(null, null, "testCategory4", 300L));

        Assert.assertEquals(4, categoryRepository.findAll().size());

        Assert.assertEquals("testCategory1", categoryRepository.findByName("testCategory1").getName());
    }

    @Test
    public void testData() {
        categoryRepository.save(new Category(null, null, "testCategory1", 1L));
        categoryRepository.save(new Category(null, null, "testCategory2", 100L));
        categoryRepository.save(new Category(null, null, "testCategory3", 200L));
        categoryRepository.save(new Category(null, null, "testCategory4", 300L));

    }

    @Test
    public void testFind() {
        Category category = categoryRepository.findOne(1L);
        System.out.println(category);
        System.out.println(category.getName());
    }
}