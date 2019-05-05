package com.awakeyoyoyo.entity;

public class Shipping {
    private Integer id;

    private Integer userId;

    private String receiverName;

    private String receiverPhone;

    private String receiverPlace;

    private String receiverDormitory;

    public Shipping(Integer id, Integer userId, String receiverName, String receiverPhone, String receiverPlace, String receiverDormitory) {
        this.id = id;
        this.userId = userId;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.receiverPlace = receiverPlace;
        this.receiverDormitory = receiverDormitory;
    }

    public Shipping() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    public String getReceiverPlace() {
        return receiverPlace;
    }

    public void setReceiverPlace(String receiverPlace) {
        this.receiverPlace = receiverPlace == null ? null : receiverPlace.trim();
    }

    public String getReceiverDormitory() {
        return receiverDormitory;
    }

    public void setReceiverDormitory(String receiverDormitory) {
        this.receiverDormitory = receiverDormitory == null ? null : receiverDormitory.trim();
    }
}