package com.awakeyoyoyo.entity;

public class OrderItem {
    private Integer id;

    private Integer userId;

    private Long orderNo;

    private String productName;

    private Integer productQuantity;

    private Integer productTitle;

    private Integer productNo;

    private String productSize;

    private String expressName;

    private String expressPhone;

    private String expressPwd;

    public OrderItem(Integer id, Integer userId, Long orderNo, String productName, Integer productQuantity, Integer productTitle, Integer productNo, String productSize, String expressName, String expressPhone, String expressPwd) {
        this.id = id;
        this.userId = userId;
        this.orderNo = orderNo;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productTitle = productTitle;
        this.productNo = productNo;
        this.productSize = productSize;
        this.expressName = expressName;
        this.expressPhone = expressPhone;
        this.expressPwd = expressPwd;
    }

    public OrderItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Integer getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(Integer productTitle) {
        this.productTitle = productTitle;
    }

    public Integer getProductNo() {
        return productNo;
    }

    public void setProductNo(Integer productNo) {
        this.productNo = productNo;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize == null ? null : productSize.trim();
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    public String getExpressPhone() {
        return expressPhone;
    }

    public void setExpressPhone(String expressPhone) {
        this.expressPhone = expressPhone == null ? null : expressPhone.trim();
    }

    public String getExpressPwd() {
        return expressPwd;
    }

    public void setExpressPwd(String expressPwd) {
        this.expressPwd = expressPwd == null ? null : expressPwd.trim();
    }
}