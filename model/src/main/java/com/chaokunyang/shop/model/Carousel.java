package com.chaokunyang.shop.model;

/**
 * 轮播
 *
 * @author yangck
 * @create 2017-02-16 10:27
 */
public class Carousel {

    private Long id;

    /**
     * 用于哪个应用
     */
    private String usedFor;

    /**
     * 排序数字
     */
    private Long orderNumber;

    /**
     * 图片url
     * 主要是获取其它域名的图片
     */
    private String pictureUrl;

    /**
     * 链接URI
     * 根据上下文拼接完整url
     */
    private String pictureUri;


    /**
     * 链接地址
     * 主要是跳到其它域名
     */
    private String hrefUrl;

    /**
     * 链接URI
     * 根据上下文拼接完整url
     */
    private String hrefUri;

    public Carousel() {
    }

    public Carousel(Long id, String usedFor, Long orderNumber, String pictureUrl, String pictureUri, String hrefUrl, String hrefUri) {
        this.id = id;
        this.usedFor = usedFor;
        this.orderNumber = orderNumber;
        this.pictureUrl = pictureUrl;
        this.pictureUri = pictureUri;
        this.hrefUrl = hrefUrl;
        this.hrefUri = hrefUri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsedFor() {
        return usedFor;
    }

    public void setUsedFor(String usedFor) {
        this.usedFor = usedFor;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(String pictureUri) {
        this.pictureUri = pictureUri;
    }

    public String getHrefUrl() {
        return hrefUrl;
    }

    public void setHrefUrl(String hrefUrl) {
        this.hrefUrl = hrefUrl;
    }

    public String getHrefUri() {
        return hrefUri;
    }

    public void setHrefUri(String hrefUri) {
        this.hrefUri = hrefUri;
    }
}
