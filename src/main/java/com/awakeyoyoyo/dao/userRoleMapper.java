package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.Role;
import com.awakeyoyoyo.entity.userRoleKey;

import java.util.List;

public interface userRoleMapper {
    int deleteByPrimaryKey(userRoleKey key);

    int insert(userRoleKey record);

    int insertSelective(userRoleKey record);
    int deleteAll(String user_id);
}