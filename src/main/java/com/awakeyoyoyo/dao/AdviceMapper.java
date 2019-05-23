package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.Advice;

import java.util.List;

public interface AdviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Advice record);

    int insertSelective(Advice record);

    Advice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Advice record);

    int updateByPrimaryKey(Advice record);
    List<Advice> selectByOpenId(String openId);
}