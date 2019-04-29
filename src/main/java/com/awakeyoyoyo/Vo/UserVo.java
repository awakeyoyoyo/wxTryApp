package com.awakeyoyoyo.Vo;

import com.awakeyoyoyo.entity.Role;

import java.util.HashSet;
import java.util.Set;

public class UserVo {
    private String id;
    private String username;
    private String password;

    //记住角色
    private Set<Role> roles = new HashSet<>();

}
