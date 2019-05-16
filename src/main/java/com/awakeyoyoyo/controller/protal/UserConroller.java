package com.awakeyoyoyo.controller.protal;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.service.IUserService;
import com.awakeyoyoyo.service.IWxService;
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
    public ServerResponse login(String js_code){
        return ServerResponse.createBySuccess(userService.login(js_code));
    }
}
