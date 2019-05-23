package com.awakeyoyoyo.entity;

import java.util.Date;

public class Charge {
    private Integer id;

    private String openId;

    private String dpoenId;

    private String chargeMxg;

    private Date createTime;

    private Integer status;

    public Charge(Integer id, String openId, String dpoenId, String chargeMxg, Date createTime, Integer status) {
        this.id = id;
        this.openId = openId;
        this.dpoenId = dpoenId;
        this.chargeMxg = chargeMxg;
        this.createTime = createTime;
        this.status = status;
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getDpoenId() {
        return dpoenId;
    }

    public void setDpoenId(String dpoenId) {
        this.dpoenId = dpoenId == null ? null : dpoenId.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}