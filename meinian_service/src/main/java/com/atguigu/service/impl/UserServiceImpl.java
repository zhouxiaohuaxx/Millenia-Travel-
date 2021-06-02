package com.atguigu.service.impl;/*
 \* Created with HuaSheng.
 \* Date: 2021/6/1
 \* Description: 
*/

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findUserByUserName(String username) {
        return userDao.findUserByusername(username);
    }
}
