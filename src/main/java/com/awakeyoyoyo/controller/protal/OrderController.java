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

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    @RequestMapping("/create.do")
    @ResponseBody
    public ServerResponse createOrder(@RequestBody OrderVo orderVo,HttpServletRequest request){
        String openId=(String) request.getAttribute("openId");
        orderVo.setUserId(openId);
        return iOrderService.add(orderVo);
    }

    @RequestMapping("/gogogo")
    public String sss(){
        return "Listcheck";
    }
    @RequestMapping("/accept.do")
    @ResponseBody
    public ServerResponse acceptOrder(Long orderNo,HttpServletRequest request){
        String dopenId=(String) request.getAttribute("openId");
        return iOrderService.acceptOrder(orderNo, dopenId);
    }

    @RequestMapping("/cancel.do")
    @ResponseBody
    public ServerResponse cancelOrder(Long orderNo, HttpServletRequest request, Integer who){
        String openId=(String) request.getAttribute("openId");
        return iOrderService.cancelOrder(orderNo,openId,who);
    }

    @RequestMapping("/lists")
    @ResponseBody
    public ServerResponse<PageInfo> lists(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                          @RequestParam(value = "pageSize",defaultValue = "3")int pageSize,
                                          String type, String str,HttpServletRequest request){
        String openId=(String) request.getAttribute("openId");
        return iOrderService.lists(pageNum,pageSize,type,str,openId);
    }
    @RequestMapping("/orderItems")
    @ResponseBody
    public ServerResponse orderItemlists(HttpServletRequest request,Long orderNo){
        String openId=(String) request.getAttribute("openId");
        return iOrderService.orderItemlists(openId,orderNo);
    }
    @RequestMapping("/finish")
    @ResponseBody
    public ServerResponse orderFinish(HttpServletRequest request,Long orderNo){
        String openId=(String) request.getAttribute("openId");
        return iOrderService.orderFinish(openId,orderNo);
    }
    @RequestMapping("/orderAddTime")
    @ResponseBody
    public ServerResponse orderAddTime(HttpServletRequest request,Long orderNo){
        String openId=(String) request.getAttribute("openId");
        return iOrderService.orderAddTime(openId,orderNo);
    }
}
