package com.awakeyoyoyo.service.impl;

import com.awakeyoyoyo.dao.UserMapper;
import com.awakeyoyoyo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserServiceImplTest {
    @Autowired
    private UserMapper userMapper;
    @Test

    public void addUser() {
          User user=new User("001","lqhao","lqh666***");
          userMapper.insert(user);
    }

    @Test
    public void findUser() {
    }

    @Test
    public void getAllUser() {
    }
}