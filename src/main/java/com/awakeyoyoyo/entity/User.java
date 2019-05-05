package com.awakeyoyoyo.entity;

public class User {
    private Integer id;

    private String userVx;

    private String userPhone;

    private String userName;

    private String userPassword;

    private Integer userType;

    private String userAvater;

    public User(Integer id, String userVx, String userPhone, String userName, String userPassword, Integer userType, String userAvater) {
        this.id = id;
        this.userVx = userVx;
        this.userPhone = userPhone;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userAvater = userAvater;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserVx() {
        return userVx;
    }

    public void setUserVx(String userVx) {
        this.userVx = userVx == null ? null : userVx.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserAvater() {
        return userAvater;
    }

    public void setUserAvater(String userAvater) {
        this.userAvater = userAvater == null ? null : userAvater.trim();
    }
}