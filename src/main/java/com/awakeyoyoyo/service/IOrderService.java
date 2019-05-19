package com.awakeyoyoyo.service;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.vo.OrderVo;


public interface IOrderService {
    //新建订单
    ServerResponse add(OrderVo orderVo);
    //接单
    ServerResponse acceptOrder(Long orderNo,Integer dopenId);
    //取消订单
     ServerResponse cancelOrder(Long orderNo,Integer openId,Integer who);
     //订单列表
     ServerResponse lists(int pageNum,int pageSize,String type,String str);
     //产品信息
    ServerResponse orderItemlists(Integer openId,Long orderNo);

    ServerResponse orderFinish(Integer openId,Long orderNo);

}
