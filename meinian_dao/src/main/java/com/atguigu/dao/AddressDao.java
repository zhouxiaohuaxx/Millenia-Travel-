package com.atguigu.dao;

import com.atguigu.entity.PageResult;
import com.atguigu.pojo.Address;
import com.atguigu.pojo.Member;
import com.github.pagehelper.Page;

import java.util.List;

public interface AddressDao {
    List<Address> findAll();

    void addAddress(Address address);

    void deleteById(Integer id);

    Page<Member> selectByCondition(String queryString);
}
