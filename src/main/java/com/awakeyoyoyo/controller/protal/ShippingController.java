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

@Controller
@RequestMapping("/Shipping")
public class ShippingController {
    @Autowired
    private IShippingService shippingService;


    @RequestMapping(value = "/add.do",
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ServerResponse add(Integer userId, Shipping shipping){
        return shippingService.add(userId,shipping);
    }

    @RequestMapping(value = "/delete.do",
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ServerResponse delete(Integer userId, Integer shippingId){
        return shippingService.delete(userId,shippingId);
    }

    @RequestMapping(value = "/update.do",
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ServerResponse update( Shipping shipping){
        return shippingService.update(shipping);
    }

    @RequestMapping(value = "/select.do",
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ServerResponse select(Integer userId, Integer shippingId)
    {
        return shippingService.selectByUserIdShippingId(userId, shippingId);
    }

    @RequestMapping(value = "/lists",
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ServerResponse<PageInfo> select(Integer userId,
                                           @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                           @RequestParam(value = "pageSize",defaultValue = "3")int pageSize){
        return shippingService.selectByUserId(userId,pageNum,pageSize);
    }
}
