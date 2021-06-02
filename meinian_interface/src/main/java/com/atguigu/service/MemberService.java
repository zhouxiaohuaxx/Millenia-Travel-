package com.atguigu.service;

import com.atguigu.pojo.Member;

import java.util.ArrayList;
import java.util.List;

public interface MemberService {
    Member findByTelephone(String telephone);

    void add(Member member);

    List<Integer> findMemberCountByMonth(ArrayList<String> list);
}
