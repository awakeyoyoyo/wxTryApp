package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.OrderItem;

import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKeyWithBLOBs(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    List<OrderItem> selectByOrderNo(Long orderNo);
}