package com.atguigu.dao;

import com.atguigu.pojo.TravelGroup;
import com.github.pagehelper.Page;

import java.util.HashMap;
import java.util.List;

public interface TravelGroupDao {
    void add(TravelGroup travelGroup);

    void setCheckGroupAndCheckItem(HashMap<String, Integer> map);

    Page<TravelGroup> findPage(String queryString);

    TravelGroup findById(Integer id);

    void edit(TravelGroup travelGroup);

    void deleteTravelGroupAndTravelItemByTravelGroupId(Integer id);

    List<Integer> findTravelItemIdByTravelgroupId(Integer id);

    List<TravelGroup> findTravelGroupListById(Integer id);

    List<TravelGroup> findAll();

}
