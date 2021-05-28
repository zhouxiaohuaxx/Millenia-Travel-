package com.atguigu.service.impl;/*
 \* Created with HuaSheng.
 \* Date: 2021/5/26
 \* Description: 
*/

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.constant.RedisConstant;
import com.atguigu.dao.SetmealDao;
import com.atguigu.entity.PageResult;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.pojo.Setmeal;
import com.atguigu.service.SetmealService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service(interfaceClass = SetmealService.class)
public class SetmealServiceImpl implements SetmealService {
    @Autowired
    private SetmealDao setmealDao;

    @Autowired
    private JedisPool jedisPool;


    @Override
    public List<Setmeal> findAll() {
        List<Setmeal> list = setmealDao.findAll();
        return list;
    }

    @Override
    public Setmeal findById(int id) {
        return setmealDao.findById(id);
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());

        Page<Setmeal> setmeals = setmealDao.findPage(queryPageBean.getQueryString());
        return new PageResult(setmeals.getTotal(), setmeals.getResult());
    }

    @Override
    public void add(Setmeal setmeal, Integer[] travelgroupIds) {
        setmealDao.add(setmeal);

        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES, setmeal.getImg());

        if (travelgroupIds != null && travelgroupIds.length != 0) {
            setSetmealAndTravelGroup(setmeal.getId(), travelgroupIds);
        }

    }

    private void setSetmealAndTravelGroup(Integer id, Integer[] travelgroupIds) {
        for (Integer travelgroupId : travelgroupIds) {
            Map map = new HashMap<>();
            map.put("setmealId",id);
            map.put("travelgroupId",travelgroupId);
            setmealDao.setSetmealAndTravelGroup(map);
        }
    }
}
