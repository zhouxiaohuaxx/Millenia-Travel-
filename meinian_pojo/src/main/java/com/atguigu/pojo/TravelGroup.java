package com.atguigu.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 报团进行分组
 */
public class TravelGroup implements Serializable {
    private Integer id;//主键
    private String code;//旅行团项目编号
    private String name;//旅行团名称
    private String helpCode;//旅行团项目缩写
    private String sex;//适用性别
    private String remark;//介绍
    private String attention;//注意事项
    private List<TravelItem> travelItems;//一个报团包含多个自由行

    public List<TravelItem> getTravelItems() {
        return travelItems;
    }

    public void setTravelItems(List<TravelItem> travelItems) {
        this.travelItems = travelItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHelpCode() {
        return helpCode;
    }

    public void setHelpCode(String helpCode) {
        this.helpCode = helpCode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }
}
