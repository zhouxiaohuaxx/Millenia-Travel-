package com.atguigu.dao;/*
 \* Created with HuaSheng.
 \* Date: 2021/5/31
 \* Description: 
*/

import com.atguigu.pojo.User;
import org.springframework.stereotype.Repository;


public interface UserDao {
    User findUserByusername(String username);
}
