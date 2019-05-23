package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.Charge;

import java.util.List;

public interface ChargeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Charge record);

    int insertSelective(Charge record);

    Charge selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Charge record);

    int updateByPrimaryKey(Charge record);

    List<Charge> selectByOpenId(String openId);
}