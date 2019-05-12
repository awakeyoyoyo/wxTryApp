package com.awakeyoyoyo.entity;

public class OrderItem {
    private Integer id;

    private Integer userId;

    private Long orderNo;

    private String expressSize;

    private String expressName;

    private String expressPwd;

    private String productMxg;

    public OrderItem(Integer id, Integer userId, Long orderNo, String expressSize, String expressName, String expressPwd, String productMxg) {
        this.id = id;
        this.userId = userId;
        this.orderNo = orderNo;
        this.expressSize = expressSize;
        this.expressName = expressName;
        this.expressPwd = expressPwd;
        this.productMxg = productMxg;
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

    public String getExpressSize() {
        return expressSize;
    }

    public void setExpressSize(String expressSize) {
        this.expressSize = expressSize == null ? null : expressSize.trim();
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    public String getExpressPwd() {
        return expressPwd;
    }

    public void setExpressPwd(String expressPwd) {
        this.expressPwd = expressPwd == null ? null : expressPwd.trim();
    }

    public String getProductMxg() {
        return productMxg;
    }

    public void setProductMxg(String productMxg) {
        this.productMxg = productMxg == null ? null : productMxg.trim();
    }
}