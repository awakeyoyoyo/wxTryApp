package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int deleteByPrimaryKey(Long orderNo);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderNo);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    int checkOrderByOpenIdOrderNo(@Param("openId") Integer openId, @Param("orderNo") Long orderNo);
}