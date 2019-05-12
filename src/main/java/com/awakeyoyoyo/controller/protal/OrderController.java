package com.awakeyoyoyo.controller.protal;

import com.awakeyoyoyo.common.OrderStatusCode;
import com.awakeyoyoyo.common.ServerResponse;


import com.awakeyoyoyo.service.IOrderService;

import com.awakeyoyoyo.vo.OrderVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    @RequestMapping("/create.do")
    @ResponseBody
    public ServerResponse createOrder(@RequestBody OrderVo orderVo){
        return iOrderService.add(orderVo);
    }

    @RequestMapping("/gogogo")
    public String sss(){
        return "Listcheck";
    }
    @RequestMapping("/accept.do")
    @ResponseBody
    public ServerResponse acceptOrder(Long orderNo,Integer duserId){
        return iOrderService.acceptOrder(orderNo, duserId);
    }

    @RequestMapping("/cancel.do")
    @ResponseBody
    public ServerResponse cancelOrder(Long orderNo,Integer userId){
        return iOrderService.cancelOrder(orderNo, userId);
    }

    @RequestMapping("/lists")
    @ResponseBody
    public ServerResponse<PageInfo> lists(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                          @RequestParam(value = "pageSize",defaultValue = "3")int pageSize,
                                          String type, String str){
        return iOrderService.lists(pageNum,pageSize,type,str);
    }
    @RequestMapping("/orderItems")
    @ResponseBody
    public ServerResponse orderItemlists(Integer userId,Long orderNo){
        return iOrderService.orderItemlists(userId,orderNo);
    }
}
