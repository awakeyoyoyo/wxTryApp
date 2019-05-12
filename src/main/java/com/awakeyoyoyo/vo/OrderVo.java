package com.awakeyoyoyo.vo;

import com.awakeyoyoyo.entity.OrderItem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderVo {

    private List<OrderItem> orderItemList;

    private Long orderNo;

    private Integer shippingId;

    private Integer status;

    private Integer userId;

    private Integer duserId;

    private BigDecimal price;

    private String takeAddress;

    private String orderType;

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
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
        this.takeAddress = takeAddress;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }


    public String getOrderMxg() {
        return orderMxg;
    }

    public void setOrderMxg(String orderMxg) {
        this.orderMxg = orderMxg;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(String successTime) {
        this.successTime = successTime;
    }

    private String overTime;

    private String createTime;

    private String acceptTime;

    private String successTime;

    private String orderMxg;

}
