package com.awakeyoyoyo.service.impl;

import com.awakeyoyoyo.service.IWxService;
import com.awakeyoyoyo.utils.HttpUtils;

import java.util.Map;

public class WxServiceImpl implements IWxService {
    private static final String APPID = "wx3081dfc3c34a811a";
    private static final String SECRET = "a8b785bacb2f3d66a9d4427d9f673ecd";
    private static final String LOGINURL="https://api.weixin.qq.com/sns/jscode2session";


    @Override
    public Map<String, String> Wxlogin(String js_code) {
        // ?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
        String params="?appid="+APPID+"&secret="+SECRET+"&js_code="+js_code+"&grant_type=authorization_code";
        String jsonResult=HttpUtils.SendGet(LOGINURL,params);
        //GSON处理一哈
        /// TODO: 2019/5/15  
    }
}
