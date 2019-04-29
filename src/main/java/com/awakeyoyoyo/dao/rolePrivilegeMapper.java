package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.rolePrivilegeKey;

public interface rolePrivilegeMapper {
    int deleteByPrimaryKey(rolePrivilegeKey key);

    int insert(rolePrivilegeKey record);

    int insertSelective(rolePrivilegeKey record);

    int deleteAll(String role_id);
}