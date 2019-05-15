package com.awakeyoyoyo.entity;

public class User {
    private Integer openId;

    private String userPhone;

    private String userName;

    private String userPassword;

    private Integer userType;

    private Integer userNumber;

    private String userSex;

    private String userCollege;

    private String userProfession;

    private String userBuilding;

    private String userDomitory;

    public User(Integer openId, String userPhone, String userName, String userPassword, Integer userType, Integer userNumber, String userSex, String userCollege, String userProfession, String userBuilding, String userDomitory) {
        this.openId = openId;
        this.userPhone = userPhone;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userNumber = userNumber;
        this.userSex = userSex;
        this.userCollege = userCollege;
        this.userProfession = userProfession;
        this.userBuilding = userBuilding;
        this.userDomitory = userDomitory;
    }

    public User() {
        super();
    }

    public Integer getOpenId() {
        return openId;
    }

    public void setOpenId(Integer openId) {
        this.openId = openId;
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

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserCollege() {
        return userCollege;
    }

    public void setUserCollege(String userCollege) {
        this.userCollege = userCollege == null ? null : userCollege.trim();
    }

    public String getUserProfession() {
        return userProfession;
    }

    public void setUserProfession(String userProfession) {
        this.userProfession = userProfession == null ? null : userProfession.trim();
    }

    public String getUserBuilding() {
        return userBuilding;
    }

    public void setUserBuilding(String userBuilding) {
        this.userBuilding = userBuilding == null ? null : userBuilding.trim();
    }

    public String getUserDomitory() {
        return userDomitory;
    }

    public void setUserDomitory(String userDomitory) {
        this.userDomitory = userDomitory == null ? null : userDomitory.trim();
    }
}