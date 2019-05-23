package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String openId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String openId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    Integer selectMainShippingIdByopenId(String openId);
    int checkByPrimaryKey(String openId);
}