package com.awakeyoyoyo.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static  final  String STANDARD_FORMAT="yyyy-MM-dd HH:mm:ss";
    /**
     * 获得当前系统时间，格式为yyyyMMdd
     *
     * @return 格式化后的时间
     */
    public static Date StrToDate(String str) {
        SimpleDateFormat sdft=new SimpleDateFormat(STANDARD_FORMAT);
        Date date2=new Date();
        try {
            date2=sdft.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return  date2;
    }
    public static String DateToStr(Date date){
        SimpleDateFormat sdft=new SimpleDateFormat(STANDARD_FORMAT);
        String str=sdft.format(date);
        return str;

    }
//    public static void main(String[] args){
//        System.out.println(DateToStr(new Date()));
//       System.out.println(StrToDate("2019-3-19 17:35:20"));
//    }
}
