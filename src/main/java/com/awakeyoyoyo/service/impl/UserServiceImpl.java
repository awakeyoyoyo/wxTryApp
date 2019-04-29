package com.awakeyoyoyo.service.impl;

import com.awakeyoyoyo.dao.*;
import com.awakeyoyoyo.entity.Privilege;
import com.awakeyoyoyo.entity.Role;
import com.awakeyoyoyo.entity.User;
import com.awakeyoyoyo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PrivilegeMapper privilegeMapper;
    @Autowired
    private userRoleMapper userroleMapper;
    @Autowired
    private rolePrivilegeMapper roleprivilegeMapper;
    /*User*/
    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User findUser(String id) {
      return  userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getAllUser() {
      return userMapper.getAllUsers();
    }




    /*Role*/
    @Override
    public List<Role> getUserRole(String user_id) {
        return null;
    }

    @Override
    public void updateUserRole(User user, List<Role> roles) {

    }

    @Override
    public void addRole(Role role) {

    }

    @Override
    public Role findRole(String id) {
        return null;
    }

    @Override
    public List<Role> getAllRole() {
        return null;
    }

    @Override
    public List<Privilege> getRolePrivilege(String role_id) {
        return null;
    }

    @Override
    public void updateRolePrivilege(Role role, List<Privilege> privileges) {

    }



    /*Privilege*/
    @Override
    public void addPrivilege(Privilege privilege) {

    }

    @Override
    public Privilege findPrivilege(String id) {
        return null;
    }

    @Override
    public List<Privilege> getAllPrivileges() {
        return null;
    }
}
