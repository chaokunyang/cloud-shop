package com.chaokunyang.shop.model;

import java.io.Serializable;
import java.util.List;

/**
 * 分类
 *
 * @author yangck
 * @create 2017-02-15 14:41
 */
public class Category implements Serializable {

    private Long id;

    private Category parentId;

    private List<Category> childs;

    /**
     * 分类名字
     */
    private String name;

    /**
     * 排序数字
     */
    private Long orderNumber;

    public Category() {
    }

    public Category(Category parentId, List<Category> childs, String name, Long orderNumber) {
        this.parentId = parentId;
        this.childs = childs;
        this.name = name;
        this.orderNumber = orderNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getParentId() {
        return parentId;
    }

    public void setParentId(Category parentId) {
        this.parentId = parentId;
    }

    public List<Category> getChilds() {
        return childs;
    }

    public void setChilds(List<Category> childs) {
        this.childs = childs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }
}
