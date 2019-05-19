package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer openId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer openId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer selectMainShippingIdByopenId(Integer openId);

    int checkByPrimaryKey(Integer openId);


}