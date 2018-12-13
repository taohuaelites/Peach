package com.example.peach.pojo;

import java.util.Date;

public class UserVip {
    private Integer id;

    private Integer vipGrade;

    private Integer vipAppointment;

    private Date vipCreatetime;

    private Date vipEndtime;

    private Integer userId;

    private Double userWallet;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVipGrade() {
        return vipGrade;
    }

    public void setVipGrade(Integer vipGrade) {
        this.vipGrade = vipGrade;
    }

    public Integer getVipAppointment() {
        return vipAppointment;
    }

    public void setVipAppointment(Integer vipAppointment) {
        this.vipAppointment = vipAppointment;
    }

    public Date getVipCreatetime() {
        return vipCreatetime;
    }

    public void setVipCreatetime(Date vipCreatetime) {
        this.vipCreatetime = vipCreatetime;
    }

    public Date getVipEndtime() {
        return vipEndtime;
    }

    public void setVipEndtime(Date vipEndtime) {
        this.vipEndtime = vipEndtime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getUserWallet() {
        return userWallet;
    }

    public void setUserWallet(Double userWallet) {
        this.userWallet = userWallet;
    }
}