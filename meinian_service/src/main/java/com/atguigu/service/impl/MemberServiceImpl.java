package com.atguigu.service.impl;/*
 \* Created with HuaSheng.
 \* Date: 2021/5/26
 \* Description: 
*/

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.dao.MemeberDao;
import com.atguigu.pojo.Member;
import com.atguigu.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(interfaceClass = MemberService.class)
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemeberDao memeberDao;

    @Override
    public Member findByTelephone(String telephone) {
        Member member=  memeberDao.findByTelephone(telephone);
        return member;
    }

    @Override
    public void add(Member member) {
        memeberDao.add(member);
    }
}
