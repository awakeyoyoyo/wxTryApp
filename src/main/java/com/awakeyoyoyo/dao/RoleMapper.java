package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    List<Role> getAllRoles();
    List<Role> getUserRoles(String user_id);
}