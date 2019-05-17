package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.Credit;

public interface CreditMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Credit record);

    int insertSelective(Credit record);

    Credit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Credit record);

    int updateByPrimaryKey(Credit record);
}