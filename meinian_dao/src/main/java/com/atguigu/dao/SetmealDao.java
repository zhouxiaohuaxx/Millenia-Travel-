package com.atguigu.dao;

import com.atguigu.pojo.Setmeal;
import com.github.pagehelper.Page;

import java.util.List;

public interface SetmealDao {
    List<Setmeal> findAll();

    Setmeal findById(int id);


    Page<Setmeal> findPage(String queryString);
}
