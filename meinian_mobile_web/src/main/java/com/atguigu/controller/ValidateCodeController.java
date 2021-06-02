package com.atguigu.controller;/*
 \* Created with HuaSheng.
 \* Date: 2021/5/26
 \* Description: 
*/

import com.atguigu.constant.MessageConstant;
import com.atguigu.constant.RedisMessageConstant;
import com.atguigu.entity.Result;
import com.atguigu.utils.SMSUtils;
import com.atguigu.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/send4Order")
    public Result send4Order(String telephone) {
        Integer code = ValidateCodeUtils.generateValidateCode(4);

        jedisPool.getResource().setex(telephone + RedisMessageConstant.SENDTYPE_ORDER, 5 * 60, code.toString());

        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);

    }

    @RequestMapping("/send4Login")
    public Result send4Login(String telephone) {

        Integer code = ValidateCodeUtils.generateValidateCode(4);

        jedisPool.getResource().setex(telephone + RedisMessageConstant.SENDTYPE_LOGIN, 5 * 60, code + "");

        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }

}
