package com.awakeyoyoyo.entity;

public class Credit {
    private Integer id;

    private String openId;

    private Integer userCredit;

    private Integer orderTimes;

    private Integer cencalTimes;

    private Integer chargeTimes;

    public Credit(Integer id, String openId, Integer userCredit, Integer orderTimes, Integer cencalTimes, Integer chargeTimes) {
        this.id = id;
        this.openId = openId;
        this.userCredit = userCredit;
        this.orderTimes = orderTimes;
        this.cencalTimes = cencalTimes;
        this.chargeTimes = chargeTimes;
    }

    public Credit() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Integer getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(Integer userCredit) {
        this.userCredit = userCredit;
    }

    public Integer getOrderTimes() {
        return orderTimes;
    }

    public void setOrderTimes(Integer orderTimes) {
        this.orderTimes = orderTimes;
    }

    public Integer getCencalTimes() {
        return cencalTimes;
    }

    public void setCencalTimes(Integer cencalTimes) {
        this.cencalTimes = cencalTimes;
    }

    public Integer getChargeTimes() {
        return chargeTimes;
    }

    public void setChargeTimes(Integer chargeTimes) {
        this.chargeTimes = chargeTimes;
    }
}