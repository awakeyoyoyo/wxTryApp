package com.awakeyoyoyo.common;

public enum UserTypeCode {
    USER(0,"用户"),
    DUSER(1,"拿手"),
    ADMIN(2,"管理员");

    private final int code;
    private final String desc;
    UserTypeCode (int code,String desc){
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
