package com.awakeyoyoyo.common;

public enum  OrderTypeCode {
    QUJIAN(0,"取件"),
    YAOPING(1,"药品"),
    PAOTUI(2,"跑腿"),
    CHAOSHI(3,"超市"),
    MEISHI(4,"美食"),
    YINPING(5,"饮品"),
    SHUIGUO(6,"水果"),
    GAODIAN(7,"糕点");

    private  final int code;
    private final String desc;
    OrderTypeCode(int code,String desc){
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
