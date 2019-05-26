package com.awakeyoyoyo.controller.protal;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.service.ICreditService;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/credit")
public class CreditController {
    //信用的controller
    //获取所有一个人credit信息
    @Autowired
    private ICreditService creditService;

    @RequestMapping(value = "/getPersonCredit",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getPersonCredit(HttpServletRequest request){
        String openId=(String) request.getAttribute("openId");
        if (openId==null){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return creditService.getPersonCredit(openId);
    }
    //获取所有人所有credit信息
    @RequestMapping(value = "/getAllCredit",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> getAllCredit(
            @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "3")int pageSize){
        return creditService.getAllCredit(pageNum,pageSize);
    }
    //好评
    @RequestMapping(value = "/estimate",method =RequestMethod.POST)
    @ResponseBody
    public ServerResponse estimatedo(HttpServletRequest request,String dopenId,String estimatedo_code,Long orderNo,String mxg){
        String openId=(String) request.getAttribute("openId");
        if (openId==null||dopenId==null||estimatedo_code==null||orderNo==null){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return creditService.doEstimate(openId,dopenId,estimatedo_code,orderNo,mxg);
    }

}
