package com.awakeyoyoyo.common;

public enum UserStatusCode {
    NORMAL(0,"正常"),
    FREEZE(1,"冻结");

    private final int code;
    private final String desc;
    UserStatusCode (int code,String desc){
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
