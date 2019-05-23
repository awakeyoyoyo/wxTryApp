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
    int deleteByOpenIdShippingId(@Param("openId") String openId, @Param("shippingId") int shippingId);
    List<Shipping> selectByOpenId(String shippingId);
    Shipping selectByOpenIdShippingId(@Param("openId")String openId,@Param("shippingId") int shippingId);
}