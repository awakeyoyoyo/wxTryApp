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

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/User")
public class UserConroller {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login.do")
    @ResponseBody
    public ServerResponse login(HttpServletRequest request,String js_code, WxUserVo wxUserVo){
        String token=request.getHeader("token");
        return userService.login(js_code,wxUserVo,token);
    }

    @RequestMapping(value = "/information.do")
    @ResponseBody
    public ServerResponse information(HttpServletRequest request){

        String openId=(String) request.getAttribute("openId");
        return userService.getInformation(openId);
    }

    @RequestMapping(value = "/update.do")
    @ResponseBody
    public ServerResponse updateInformation(HttpServletRequest request,User user){
        String openId=(String) request.getAttribute("openId");
        user.setOpenId(openId);
        return userService.updateInformation(user);
    }

    //冻结用户

}
