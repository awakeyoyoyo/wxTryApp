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
    int checkOrderByOpenIdOrderNo(@Param("openId")String openId,@Param("orderNo")Long orderNo);
    int checkOrderByDOpenIdOrderNo(@Param("dopenId")String dopenId,@Param("orderNo")Long orderNo);
    List<Order> selectByStatus(int status);
    List<Order> selectByOpenId(String openId);
    List<Order> selectByDOpenId(String openId);
    List<Order> selectByTypeStatus(@Param("type")String type,@Param("status")int status);
    int  checkOrderByOpenIdOrderNoDopenId(@Param("openId") String openId, @Param("dopenId") String dopenId,@Param("orderNo") Long  orderNo);

}