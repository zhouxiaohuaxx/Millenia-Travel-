package com.atguigu.controller;/*
 \* Created with HuaSheng.
 \* Date: 2021/5/25
 \* Description: 
*/

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.constant.MessageConstant;
import com.atguigu.entity.PageResult;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.entity.Result;
import com.atguigu.pojo.TravelGroup;
import com.atguigu.service.TravelGroupService;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/travelgroup")
public class TravelGroupController {

    @Reference
    private TravelGroupService travelGroupService;

    @RequestMapping("/add")
    public Result add(@RequestBody TravelGroup travelGroup, Integer[] travelItemIds) {
        travelGroupService.add(travelGroup, travelItemIds);
        return new Result(true, MessageConstant.ADD_TRAVELGROUP_SUCCESS);
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = travelGroupService.findPage(queryPageBean.getPageSize(),
                queryPageBean.getQueryString(),
                queryPageBean.getCurrentPage());
        return pageResult;
    }

    @RequestMapping("/findById")
    public Result findById(@RequestParam("id") Integer id) {
        TravelGroup travelGroup = travelGroupService.findById(id);
        return new Result(true, MessageConstant.QUERY_TRAVELGROUP_SUCCESS, travelGroup);
    }

    @RequestMapping("/edit")
    public Result edit(@RequestBody TravelGroup travelGroup, Integer[] travelItemIds) {
        travelGroupService.edit(travelGroup, travelItemIds);
        return new Result(true, MessageConstant.EDIT_TRAVELGROUP_SUCCESS);
    }

    @RequestMapping("/findTravelItemIdByTravelgroupId")
    public List<Integer> findTravelItemIdByTravelgroupId(Integer id) {
        List<Integer> list = travelGroupService.findTravelItemIdByTravelgroupId(id);
        return list;
    }

    @RequestMapping("/findAll")
    public Result findAll() {
        List<TravelGroup> travelGroupList = travelGroupService.findAll();
        if (travelGroupList!=null && travelGroupList.size()>0){
            return new Result(true, MessageConstant.QUERY_SETMEAL_SUCCESS, travelGroupList);
        }
        return new Result(false, MessageConstant.QUERY_SETMEAL_FAIL);
    }

}
