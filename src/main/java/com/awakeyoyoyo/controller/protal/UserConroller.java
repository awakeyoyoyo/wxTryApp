package com.awakeyoyoyo.controller.protal;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.entity.User;
import com.awakeyoyoyo.service.IUserService;
import com.awakeyoyoyo.service.IWxService;
import com.awakeyoyoyo.vo.WxUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/User")
//@Api(value = "restful", description = "测试")
public class UserConroller {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login.do")
    @ResponseBody
//    @ApiOperation(value = "测试专用")
    public ServerResponse login(String js_code, WxUserVo wxUserVo,HttpServletRequest request){
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
