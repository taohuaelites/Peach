package com.example.peach.pojo;

import java.util.Date;

public class Commodity {
    private Integer id;

    private String commodityName;

    private String commodityBody;

    private Integer commodityFrequency;

    private Double commodityPrice;

    private Double firstdiscount;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? null : commodityName.trim();
    }

    public String getCommodityBody() {
        return commodityBody;
    }

    public void setCommodityBody(String commodityBody) {
        this.commodityBody = commodityBody == null ? null : commodityBody.trim();
    }

    public Integer getCommodityFrequency() {
        return commodityFrequency;
    }

    public void setCommodityFrequency(Integer commodityFrequency) {
        this.commodityFrequency = commodityFrequency;
    }

    public Double getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(Double commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Double getFirstdiscount() {
        return firstdiscount;
    }

    public void setFirstdiscount(Double firstdiscount) {
        this.firstdiscount = firstdiscount;
    }
}