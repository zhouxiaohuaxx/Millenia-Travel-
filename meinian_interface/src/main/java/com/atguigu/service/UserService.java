package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {
    User findUserByUserName(String username);
}
