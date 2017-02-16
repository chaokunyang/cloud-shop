package com.chaokunyang.shop.category;

import com.chaokunyang.shop.category.repository.CategoryRepository;
import com.chaokunyang.shop.category.model.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Random;

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
        categoryRepository.save( new Category(1L, 0, null, new ArrayList<>(), "testCategory1", -1L));
        categoryRepository.save( new Category(null, 0, null, new ArrayList<>(), "testCategory2", -1L));
        categoryRepository.save( new Category(null, 0, null, new ArrayList<>(), "testCategory3", -1L));
        categoryRepository.save( new Category(null, 0, null, new ArrayList<>(), "testCategory4", -1L));

        Assert.assertEquals(4, categoryRepository.findAll().size());

        Assert.assertEquals("testCategory1", categoryRepository.findByName("testCategory1").getName());
    }

    @Test
    public void testData() {
        Category top = new Category(null, 0, null, new ArrayList<>(), "top", -1L);

        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            Category level1 = new Category(null, 1, null, new ArrayList<>(), "level1," + i, i * 100L);
            top.getChilds().add(level1);

            int level2Count = 5 + random.nextInt(3);
            for(int j = 0; j < level2Count; j++) {
                Category level2 = new Category(null, 2, null, new ArrayList<>(), "level2," + j, j * 100L);
                level1.getChilds().add(level2);

                int level3Count = 10 + random.nextInt(5);
                for(int k = 0; k < level3Count; k++) {
                    Category level3 = new Category(null, 3, null, new ArrayList<>(), "level3," + k, k * 100L);
                    level2.getChilds().add(level3);
                }
            }
        }

        categoryRepository.save(top);

    }

    @Test
    public void getTestData() {
        Category category = categoryRepository.findOne(-1L);
    }

    @Test
    public void testFind() {
        Category category = categoryRepository.findOne(1L);
        System.out.println(category);
        System.out.println(category.getName());
    }
}