package com.atguigu.service.impl;/*
 \* Created with HuaSheng.
 \* Date: 2021/5/26
 \* Description: 
*/

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.service.OrderService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(interfaceClass = OrderService.class)
public class OrderServiceImpl implements OrderService {
}
