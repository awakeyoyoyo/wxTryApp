package com.awakeyoyoyo.common;

public enum UserSexCode {
    NOSEE(0,"未知"),
    MAN(1,"男"),
    WOMEN(2,"女");

    private final int code;
    private final String desc;
    UserSexCode (int code,String desc){
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
