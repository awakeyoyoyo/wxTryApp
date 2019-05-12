package com.awakeyoyoyo.service;

import com.awakeyoyoyo.common.ServerResponse;
import com.awakeyoyoyo.vo.OrderVo;


public interface IOrderService {
    //新建订单
    ServerResponse add(OrderVo orderVo);
    //接单
    ServerResponse acceptOrder(Long orderNo,Integer duserId);
    //取消订单
     ServerResponse cancelOrder(Long orderNo,Integer userId);
     //订单列表
     ServerResponse lists(int pageNum,int pageSize,String type,String str);
     //产品信息
    ServerResponse orderItemlists(Integer userId,Long orderNo);

}
