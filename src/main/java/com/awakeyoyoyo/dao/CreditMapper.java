package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.Credit;

import java.util.List;

public interface CreditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Credit record);

    int insertSelective(Credit record);

    Credit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Credit record);

    int updateByPrimaryKey(Credit record);
    int ReduceUserCrediByuserId(String userId);
    int addUserCreditByuserId(String userId);
    int addCancelByuserId (String userId);
    int addChargeByuserId(String userId);
    int addOrderByuserId(String userId);
    Credit selectByOpenId(String openId);
    List<Credit> selectAll();
    int selectByOpenID(String openId);
}