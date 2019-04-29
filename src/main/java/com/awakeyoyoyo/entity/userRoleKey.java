package com.awakeyoyoyo.entity;

public class userRoleKey {
    private String userId;

    private String roleId;

    public userRoleKey(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public userRoleKey() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}