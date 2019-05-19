package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Long orderNo);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderNo);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    int checkOrderByOpenIdOrderNo(@Param("openId") Integer openId, @Param("orderNo") Long orderNo);
    int checkOrderByDOpenIdOrderNo(@Param("dopenId") Integer dopenId, @Param("orderNo") Long orderNo);

    List<Order> selectByStatus(Integer status);

    List<Order> selectByOpenId(Integer openId);

    List<Order> selectByDOpenId(Integer dopenId);

    List<Order>    selectByTypeStatus( @Param("type") Integer type, @Param("status") Integer status);
}