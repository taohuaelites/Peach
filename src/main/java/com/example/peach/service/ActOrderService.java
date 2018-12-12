package com.example.peach.service;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.ActOrder;

import java.util.List;

/**
 * Created by Administrator on 2018/11/17.
 */
public interface ActOrderService {
    ActOrder getActOrder(Integer id);

    ServiceResponse<String> insertActOrder(ActOrder actOrder);

    List<ActOrder> selectActOrderList(String actnature);
}
