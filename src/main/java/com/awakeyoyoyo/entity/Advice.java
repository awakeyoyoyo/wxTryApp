package com.awakeyoyoyo.entity;

import java.util.Date;

public class Advice {
    private Integer id;

    private String openId;

    private String adviceMxg;

    private Date createTime;

    private Integer status;

    public Advice(Integer id, String openId, String adviceMxg, Date createTime, Integer status) {
        this.id = id;
        this.openId = openId;
        this.adviceMxg = adviceMxg;
        this.createTime = createTime;
        this.status = status;
    }

    public Advice() {
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

    public String getAdviceMxg() {
        return adviceMxg;
    }

    public void setAdviceMxg(String adviceMxg) {
        this.adviceMxg = adviceMxg == null ? null : adviceMxg.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}