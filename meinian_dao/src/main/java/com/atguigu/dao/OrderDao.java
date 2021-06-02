package com.atguigu.dao;

import com.atguigu.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {
    List<Order> findByCondition(Order order);

    void add(Order order);

    List<Map<String, Object>> findHotSetmeal();

    int getThisWeekAndMonthVisitsNumber(Map<String, Object> paramMonthVisit);

    int getThisWeekAndMonthOrderNumber(Map<String, Object> paramMonth);

    int getTodayVisitsNumber(String today);

    int getTodayOrderNumber(String today);

    Map findById(Integer id);
}
