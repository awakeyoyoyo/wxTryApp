package com.awakeyoyoyo.common;

public enum EstimateCode {
    GOOD(10,"好评"),
    BAD(20,"差评");

    private final int code;
    private final String desc;
    EstimateCode (int code,String desc){
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
