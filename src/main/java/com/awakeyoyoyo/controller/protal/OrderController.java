package com.awakeyoyoyo.controller.protal;

import com.awakeyoyoyo.common.OrderStatusCode;
import com.awakeyoyoyo.common.ServerResponse;


import com.awakeyoyoyo.service.IOrderService;

import com.awakeyoyoyo.vo.OrderVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    @RequestMapping(value = "/create.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse createOrder(@RequestBody OrderVo orderVo,HttpServletRequest request){
        String openId=(String) request.getAttribute("openId");
        orderVo.setUserId(openId);
        if (orderVo==null){
            return ServerResponse.createByErrorMessage("没有传入参数");
        }
        return iOrderService.add(orderVo);
    }

//    @RequestMapping(value = "/gogogo")
//    public String sss(){
//        return "Listcheck";
//    }
    @RequestMapping(value = "/accept.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse acceptOrder(Long orderNo,HttpServletRequest request){
        String dopenId=(String) request.getAttribute("openId");
        return iOrderService.acceptOrder(orderNo, dopenId);
    }

    @RequestMapping(value = "/cancel.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse cancelOrder(Long orderNo, HttpServletRequest request, Integer who){
        String openId=(String) request.getAttribute("openId");
        return iOrderService.cancelOrder(orderNo,openId,who);
    }

    @RequestMapping(value = "/lists",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse lists(
                                          String type, String str,HttpServletRequest request){
        String openId=(String) request.getAttribute("openId");
        return iOrderService.lists(type,str,openId);
    }

    @RequestMapping(value = "/alllists",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse allllists(Integer type_code){
        return iOrderService.alllists(type_code);
    }

    @RequestMapping(value = "/orderItems",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse orderItemlists(HttpServletRequest request,Long orderNo){
        String openId=(String) request.getAttribute("openId");
        return iOrderService.orderItemlists(openId,orderNo);
    }
    @RequestMapping(value = "/finish",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse orderFinish(HttpServletRequest request,Long orderNo){
        String openId=(String) request.getAttribute("openId");
        return iOrderService.orderFinish(openId,orderNo);
    }
    @RequestMapping(value = "/orderAddTime",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse orderAddTime(HttpServletRequest request,Long orderNo){
        String openId=(String) request.getAttribute("openId");
        return iOrderService.orderAddTime(openId,orderNo);
    }
}
