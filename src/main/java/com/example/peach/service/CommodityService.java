package com.example.peach.service;

import com.example.peach.common.ServiceResponse;

import java.util.List;

public interface CommodityService {
    //显示所有会员卡信息
    ServiceResponse<List> selectCommodity();
}
