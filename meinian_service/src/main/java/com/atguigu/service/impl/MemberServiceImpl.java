package com.atguigu.service.impl;/*
 \* Created with HuaSheng.
 \* Date: 2021/5/26
 \* Description: 
*/

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.dao.MemeberDao;
import com.atguigu.pojo.Member;
import com.atguigu.service.MemberService;
import com.atguigu.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(interfaceClass = MemberService.class)
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemeberDao memeberDao;

    @Override
    public Member findByTelephone(String telephone) {
        Member member = memeberDao.findByTelephone(telephone);
        return member;
    }

    @Override
    public void add(Member member) {
        memeberDao.add(member);
    }

    @Override
    public List<Integer> findMemberCountByMonth(ArrayList<String> list) {
        List<Integer> memeberCountList = new ArrayList<Integer>();
        if (list != null && list.size() > 0) {
            for (String months : list) {
                //String regTime = months+"-31";
                // 获取指定月份的最后一天
                String regTime = DateUtils.getLastDayOfMonth(months);
                //  迭代过去12个月，每个月注册会员的数量，根据注册日期查询
                Integer memeberCount = memeberDao.findMemberCountBeforeDate(regTime);
                memeberCountList.add(memeberCount);
            }
        }
        return memeberCountList;
    }
}
