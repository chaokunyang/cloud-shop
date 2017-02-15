package com.chaokunyang.shop.category.data;

import com.chaokunyang.shop.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 分类仓库
 *
 * @author yangck
 * @create 2017-02-15 15:10
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
