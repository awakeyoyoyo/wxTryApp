package com.awakeyoyoyo.entity;

import java.util.Date;

public class Charge {
    private Integer id;

    private Integer openId;

    private Integer dpoenId;

    private String chargeMxg;

    private Date createTime;

    public Charge(Integer id, Integer openId, Integer dpoenId, String chargeMxg, Date createTime) {
        this.id = id;
        this.openId = openId;
        this.dpoenId = dpoenId;
        this.chargeMxg = chargeMxg;
        this.createTime = createTime;
    }

    public Charge() {
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

    public Integer getDpoenId() {
        return dpoenId;
    }

    public void setDpoenId(Integer dpoenId) {
        this.dpoenId = dpoenId;
    }

    public String getChargeMxg() {
        return chargeMxg;
    }

    public void setChargeMxg(String chargeMxg) {
        this.chargeMxg = chargeMxg == null ? null : chargeMxg.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}