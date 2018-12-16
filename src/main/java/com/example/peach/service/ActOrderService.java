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

    List<ActOrder> selectActOrderList(Integer activityId);

    ServiceResponse<String> updateActOrder(ActOrder actOrder);

    List<ActOrder> selectUserId(Integer userId);

    ActOrder selectById(Integer id);

    List<ActOrder> selectByActId(Integer activityId);

}
