package com.atguigu.dao;

import com.atguigu.pojo.Setmeal;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface SetmealDao {
    List<Setmeal> findAll();

    Setmeal findById(int id);


    Page<Setmeal> findPage(String queryString);

    void add(Setmeal setmeal);

    void setSetmealAndTravelGroup(Map map);

    List<Map<String, Object>> findSetmealCount();
}
