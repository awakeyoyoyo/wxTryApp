package com.awakeyoyoyo.entity;

import java.util.Date;

public class Advice {
    private Integer id;

    private Integer openId;

    private String adviceMxg;

    private Date createTime;

    public Advice(Integer id, Integer openId, String adviceMxg, Date createTime) {
        this.id = id;
        this.openId = openId;
        this.adviceMxg = adviceMxg;
        this.createTime = createTime;
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

    public Integer getOpenId() {
        return openId;
    }

    public void setOpenId(Integer openId) {
        this.openId = openId;
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
}