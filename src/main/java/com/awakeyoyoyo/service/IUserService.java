package com.awakeyoyoyo.service;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.entity.User;
import com.awakeyoyoyo.vo.WxUserVo;

public interface IUserService {
    ServerResponse login(String js_code, WxUserVo userVo,String token);
    ServerResponse getInformation(String openId);
    ServerResponse updateInformation(User user);

    ServerResponse ggUser(String openId);
}
