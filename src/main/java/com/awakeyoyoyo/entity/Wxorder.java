package com.awakeyoyoyo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Wxorder {
    private Long orderNo;

    private Integer shippingId;

    private Integer status;

    private Integer userId;

    private Integer duserId;

    private BigDecimal price;

    private String takeAddress;

    private String orderType;

    private Date overTime;

    private Date createTime;

    private Date acceptTime;

    private Date successTime;

    private String orderMxg;

    public Wxorder(Long orderNo, Integer shippingId, Integer status, Integer userId, Integer duserId, BigDecimal price, String takeAddress, String orderType, Date overTime, Date createTime, Date acceptTime, Date successTime, String orderMxg) {
        this.orderNo = orderNo;
        this.shippingId = shippingId;
        this.status = status;
        this.userId = userId;
        this.duserId = duserId;
        this.price = price;
        this.takeAddress = takeAddress;
        this.orderType = orderType;
        this.overTime = overTime;
        this.createTime = createTime;
        this.acceptTime = acceptTime;
        this.successTime = successTime;
        this.orderMxg = orderMxg;
    }

    public Wxorder() {
        super();
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getShippingId() {
        return shippingId;
    }

    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDuserId() {
        return duserId;
    }

    public void setDuserId(Integer duserId) {
        this.duserId = duserId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTakeAddress() {
        return takeAddress;
    }

    public void setTakeAddress(String takeAddress) {
        this.takeAddress = takeAddress == null ? null : takeAddress.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public String getOrderMxg() {
        return orderMxg;
    }

    public void setOrderMxg(String orderMxg) {
        this.orderMxg = orderMxg == null ? null : orderMxg.trim();
    }
}