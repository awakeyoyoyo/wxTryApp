package com.awakeyoyoyo.service;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.entity.User;
import com.awakeyoyoyo.vo.WxUserVo;

public interface IUserService {
    ServerResponse login(String js_code, WxUserVo userVo);
    ServerResponse getInformation(Integer openId);
    ServerResponse updateInformation(User user);

    ServerResponse ggUser(Integer openId);
}
