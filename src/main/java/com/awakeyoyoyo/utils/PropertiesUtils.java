package com.awakeyoyoyo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtils {
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

    private static Properties props;
    //静态代码块优于普通代码块优于构造代码块
    //静态代码块只执行一次，在类被加载得时候执行，通常用于类初始化
    static {
        String fileName = "wxTrpApp.properties";
        props = new Properties();
        try {
            props.load(new InputStreamReader(PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName),
                    "UTF-8"));
        } catch (IOException e) {
            logger.error("配置文件读取异常",e);
        }
    }

    public static String getProperty(String key){
        String value = props.getProperty(key.trim());
        if(value.isEmpty()){
            return null;
        }
        return value.trim();
    }

    public static String getProperty(String key,String defaultValue){
        String value = props.getProperty(key.trim());
        if(value.isEmpty()){
            value = defaultValue;
        }
        return value.trim();
    }
}
