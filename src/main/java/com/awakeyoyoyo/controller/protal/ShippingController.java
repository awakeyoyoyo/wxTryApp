package com.awakeyoyoyo.controller.protal;


import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.entity.Shipping;
import com.awakeyoyoyo.service.IShippingService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/Shipping")
public class ShippingController {
    @Autowired
    private IShippingService shippingService;


    @RequestMapping(value = "/add.do",
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ServerResponse add( HttpServletRequest request, Shipping shipping){
        String openId=(String) request.getAttribute("openId");
        return shippingService.add(openId,shipping);
    }

    @RequestMapping(value = "/delete.do",
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ServerResponse delete(HttpServletRequest request, Integer shippingId){
        String openId=(String) request.getAttribute("openId");
        return shippingService.delete(openId,shippingId);
    }

    @RequestMapping(value = "/update.do",
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ServerResponse update( HttpServletRequest request,Shipping shipping){
        String openId=(String) request.getAttribute("openId");
        shipping.setOpenId(openId);
        return shippingService.update(shipping);
    }

    @RequestMapping(value = "/select.do",
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ServerResponse select(HttpServletRequest request, Integer shippingId)
    {   String openId=(String) request.getAttribute("openId");
        return shippingService.selectByOpenIdShippingId(openId, shippingId);
    }

    @RequestMapping(value = "/lists",
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ServerResponse<PageInfo> lists(HttpServletRequest request,
                                           @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                           @RequestParam(value = "pageSize",defaultValue = "3")int pageSize){
        String openId=(String) request.getAttribute("openId");
        return shippingService.selectByOpenId(openId,pageNum,pageSize);
    }

    @RequestMapping(value = "/getMainShipping",
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ServerResponse getMainShipping(HttpServletRequest request){
        String openId=(String) request.getAttribute("openId");

        return shippingService.selectMainShippingByopenId(openId);
    }

    @RequestMapping(value = "/setMainShipping",
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ServerResponse setMainShipping(HttpServletRequest request,Integer shippingId){
        String openId=(String) request.getAttribute("openId");
        return shippingService.upadateMainShippingByopenId(openId,shippingId);
    }
}
