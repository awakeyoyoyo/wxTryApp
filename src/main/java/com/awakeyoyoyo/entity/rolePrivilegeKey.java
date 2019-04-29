package com.awakeyoyoyo.entity;

public class rolePrivilegeKey {
    private String roleId;

    private String privilegeId;

    public rolePrivilegeKey(String roleId, String privilegeId) {
        this.roleId = roleId;
        this.privilegeId = privilegeId;
    }

    public rolePrivilegeKey() {
        super();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(String privilegeId) {
        this.privilegeId = privilegeId == null ? null : privilegeId.trim();
    }
}