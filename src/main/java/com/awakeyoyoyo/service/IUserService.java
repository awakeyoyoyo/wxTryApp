package com.awakeyoyoyo.service;

import com.awakeyoyoyo.entity.Privilege;
import com.awakeyoyoyo.entity.Role;
import com.awakeyoyoyo.entity.User;

import java.util.List;

public interface IUserService {
    /*user*/
    void addUser(User user);
    User findUser(String id);
    List<User> getAllUser();
    List<Role> getUserRole(String user_id);
    void updateUserRole(User user, List<Role> roles);
    /*role*/
    void addRole(Role role);
    Role findRole(String id);
    List<Role> getAllRole();
    List<Privilege> getRolePrivilege(String role_id);
    void updateRolePrivilege(Role role, List<Privilege> privileges);
    /*privilegeService*/
    void addPrivilege(Privilege privilege);
    Privilege findPrivilege(String id);
    List<Privilege> getAllPrivileges();
}
