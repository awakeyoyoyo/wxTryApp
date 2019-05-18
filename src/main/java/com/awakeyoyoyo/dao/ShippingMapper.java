package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    int deleteByOpenIdShippingId(@Param("openId") Integer openId,@Param("shippingId") Integer shippingId);

    List<Shipping> selectByOpenId(Integer openId);

    Shipping selectByOpenIdShippingId (@Param("openId") Integer openId,@Param("shippingId") Integer shippingId);
}