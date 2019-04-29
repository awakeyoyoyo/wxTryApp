package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.Privilege;

import java.util.List;

public interface PrivilegeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Privilege record);

    int insertSelective(Privilege record);

    Privilege selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Privilege record);

    int updateByPrimaryKey(Privilege record);

    List<Privilege> getAllPrivileges();

    List<Privilege> getAllPrivilegesByRole(String role_id);
}