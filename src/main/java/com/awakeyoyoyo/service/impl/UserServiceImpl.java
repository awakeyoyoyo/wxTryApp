package com.awakeyoyoyo.service.impl;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.service.IUserService;
import org.springframework.stereotype.Service;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Override
    public ServerResponse login(String js_code) {
        //http请求去wx后台


        //返回一个openid

        //表头搞一手token

        return  null;
    }
}
