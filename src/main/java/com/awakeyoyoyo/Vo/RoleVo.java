package com.awakeyoyoyo.Vo;

import com.awakeyoyoyo.entity.Privilege;

import java.util.HashSet;
import java.util.Set;

public class RoleVo {
    private String id;
    private String name;
    private String description;

    //记住所有的权限
    private Set<Privilege> privileges = new HashSet<>();

}
