package com.awakeyoyoyo.controller.protal;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.service.ICreditService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/credit")
public class CreditController {
    //信用的controller
    //获取所有一个人credit信息
    @Autowired
    private ICreditService creditService;

    @RequestMapping("/getPersonCredit")
    @ResponseBody
    public ServerResponse getPersonCredit(Integer openId){
        return creditService.getPersonCredit(openId);
    }
    //获取所有人所有credit信息
    @RequestMapping("/getAllCredit")
    @ResponseBody
    public ServerResponse<PageInfo> getAllCredit(
            @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "3")int pageSize){
        return creditService.getAllCredit(pageNum,pageSize);
    }
    //
}
