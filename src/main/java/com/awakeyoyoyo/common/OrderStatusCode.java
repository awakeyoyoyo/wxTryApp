package com.awakeyoyoyo.common;

public enum OrderStatusCode {
    UnAccept(0,"未被接单"),
    IsAccept(1,"已被接单"),
    Canceled(2,"已取消订单"),
    ObverLate(3,"订单超过时间");

    private final int code;
    private final String desc;
    OrderStatusCode (int code,String desc){
        this.code=code;
        this.desc=desc;
    }
    public  int getCode(){
        return code;
    }
    public String getDesc() {
        return desc;
    }
}
