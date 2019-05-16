package com.awakeyoyoyo.service.impl;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.service.IUserService;
import com.awakeyoyoyo.service.IWxService;
import com.awakeyoyoyo.utils.Constant;
import com.awakeyoyoyo.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("iUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IWxService wxService;
    @Override
    public ServerResponse login(String js_code) {
        //http请求去wx后台
        Map<String,String> result=wxService.Wxlogin(js_code);
        if (result.get("openid")==null||result.get("openid").isEmpty()){
            ServerResponse.createByErrorMessage("登陆失败重新打开");
        }
        //返回一个openid
        System.out.println(result.get("openid"));
        //token
        String token="";
        try {
            token=JWTUtils.createJWT(result.get("openid"), Constant.JWT_TTL);
        } catch (Exception e) {
            ServerResponse.createByErrorMessage("生成Token失败");
            e.printStackTrace();
        }
        //返回token
        return  ServerResponse.createBySuccess(token);
    }
}
