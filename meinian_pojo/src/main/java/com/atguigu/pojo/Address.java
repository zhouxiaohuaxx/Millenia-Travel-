package com.atguigu.pojo;/*
 \* Created with HuaSheng.
 \* Date: 2021/5/31
 \* Description: 
*/

import java.io.Serializable;

public class Address implements Serializable {
    private Integer id;
    private String addressName;
    private String lng;
    private String lat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
