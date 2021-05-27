package com.atguigu.service;

import com.atguigu.entity.PageResult;
import com.atguigu.pojo.TravelGroup;
import com.github.pagehelper.Page;

import java.util.List;

public interface TravelGroupService {
    void add(TravelGroup travelGroup, Integer[] travelItemIds);


    PageResult findPage(Integer pageSize, String queryString, Integer currentPage);

    TravelGroup findById(Integer id);

    void edit(TravelGroup travelGroup, Integer[] travelItemIds);

    List<Integer> findTravelItemIdByTravelgroupId(Integer id);

    List<TravelGroup> findAll();

}
