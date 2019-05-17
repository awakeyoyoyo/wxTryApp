package com.awakeyoyoyo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private Long orderNo;

    private Integer shippingId;

    private Integer status;

    private Date acceptTime;

    private Date endTime;

    private Date createTime;

    private Date successTime;

    private Integer openId;

    private Date overTime;

    private Integer duserId;

    private BigDecimal price;

    private String orderMxg;

    private String takeAddress;

    private String orderType;

    public Order(Integer id, Long orderNo, Integer shippingId, Integer status, Date acceptTime, Date endTime, Date createTime, Date successTime, Integer openId, Date overTime, Integer duserId, BigDecimal price, String orderMxg, String takeAddress, String orderType) {
        this.id = id;
        this.orderNo = orderNo;
        this.shippingId = shippingId;
        this.status = status;
        this.acceptTime = acceptTime;
        this.endTime = endTime;
        this.createTime = createTime;
        this.successTime = successTime;
        this.openId = openId;
        this.overTime = overTime;
        this.duserId = duserId;
        this.price = price;
        this.orderMxg = orderMxg;
        this.takeAddress = takeAddress;
        this.orderType = orderType;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public Integer getOpenId() {
        return openId;
    }

    public void setOpenId(Integer openId) {
        this.openId = openId;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
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

    public String getOrderMxg() {
        return orderMxg;
    }

    public void setOrderMxg(String orderMxg) {
        this.orderMxg = orderMxg == null ? null : orderMxg.trim();
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
}