package com.chaokunyang.shop.category.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * 分类
 *
 * @author yangck
 * @create 2017-02-15 14:41
 */
@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parent_id")
    private Long parentId; // childs建立映射时默认使用的是主键id，而主键是Long，对应bigint，parentId如果是String则对应VARCHAR(255)，两个类型不一样，因此无法建立外键约束成功

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_id")
    @OrderBy(value = "order_number ASC")
    private List<Category> childs;

    /**
     * 分类名字
     */
    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    /**
     * 排序数字
     */
    @Column(name = "order_number")
    private Long orderNumber;

    public Category() {
    }

    public Category(Long parentId, List<Category> childs, String name, Long orderNumber) {
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", childs=" + childs +
                ", name='" + name + '\'' +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
