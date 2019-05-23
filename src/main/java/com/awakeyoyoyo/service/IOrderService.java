package com.awakeyoyoyo.service;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.vo.OrderVo;


public interface IOrderService {
    //新建订单
    ServerResponse add(OrderVo orderVo);
    //接单
    ServerResponse acceptOrder(Long orderNo,String dopenId);
    //取消订单
     ServerResponse cancelOrder(Long orderNo,String openId,Integer who);
     //订单列表
     ServerResponse lists(int pageNum,int pageSize,String type,String str,String openId);
     //产品信息
    ServerResponse orderItemlists(String openId,Long orderNo);

    ServerResponse orderFinish(String openId,Long orderNo);

}
