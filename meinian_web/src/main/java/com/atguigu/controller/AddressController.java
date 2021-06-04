package com.atguigu.controller;/*
 \* Created with HuaSheng.
 \* Date: 2021/5/28
 \* Description: 
*/

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.PageResult;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.entity.Result;
import com.atguigu.pojo.Address;
import com.atguigu.service.AddressService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Reference
    private AddressService addressService;

    @RequestMapping("/findAllMaps")
    public Map findAll() {
        Map map = new HashMap<>();

        List<Address> addressList = addressService.findAll();

        ArrayList<Map> gridnMaps = new ArrayList<>();

        ArrayList<Map> nameMaps = new ArrayList<>();

        for (Address address : addressList) {
            Map gridnMap = new HashMap();
            gridnMap.put("lng", address.getLng());
            gridnMap.put("lat", address.getLat());
            gridnMaps.add(gridnMap);
            Map nameMap = new HashMap();
            // 获取地址的名字
            nameMap.put("addressName", address.getAddressName());
            nameMaps.add(nameMap);
        }
        // 存放经纬度
        map.put("gridnMaps", gridnMaps);
        // 存放名字
        map.put("nameMaps", nameMaps);
        return map;
    }


    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult=null;
        try{
            pageResult= addressService.findPage(queryPageBean);
        }catch (Exception e){
            e.printStackTrace();
        }
        return pageResult;
    }



    @RequestMapping("/addAddress")
    public Result addAddress(@RequestBody Address address){
        addressService.addAddress(address);
        return new Result(true,"地址保存成功");
    }

    @RequestMapping("/deleteById")
    public Result deleteById(Integer id){
        addressService.deleteById(id);
        return new Result(true,"已删除地址");
    }
}
