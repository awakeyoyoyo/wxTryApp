package com.awakeyoyoyo.controller.protal;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.entity.User;
import com.awakeyoyoyo.service.IUserService;
import com.awakeyoyoyo.service.IWxService;
import com.awakeyoyoyo.vo.WxUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/User")
public class UserConroller {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login.do")
    @ResponseBody
    public ServerResponse login(String js_code, WxUserVo wxUserVo){
        return userService.login(js_code,wxUserVo);
    }

    @RequestMapping(value = "/information.do")
    @ResponseBody
    public ServerResponse information(Integer openId){
        return userService.getInformation(openId);
    }

    @RequestMapping(value = "/update.do")
    @ResponseBody
    public ServerResponse updateInformation(User user){
        return userService.updateInformation(user);
    }
}
