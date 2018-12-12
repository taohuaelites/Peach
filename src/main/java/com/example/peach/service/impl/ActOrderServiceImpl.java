package com.example.peach.service.impl;

import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.ActOrderMapper;
import com.example.peach.pojo.ActOrder;
import com.example.peach.service.ActOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/11/17.
 */
@Service
public class ActOrderServiceImpl implements ActOrderService {
    @Resource
    private ActOrderMapper actOrderMapper;

    /**
     * 根据id查询活动单
     * @param id
     * @return
     */
    @Override
    public ActOrder getActOrder(Integer id) {
        return actOrderMapper.getActOrder(id);
    }

    /**
     * 添加活动单
     * @param actOrder
     * @return
     */
    @Override
    public ServiceResponse<String> insertActOrder(ActOrder actOrder) {
       int insert= actOrderMapper.insertActOrder(actOrder);
        if (insert>0){
            return  ServiceResponse.createBySuccess("添加成功");
        }
        return ServiceResponse.createByError("添加失败");
    }

    @Override
    public List<ActOrder> selectActOrderList(String actnature) {
        return actOrderMapper.selectActOrderList(actnature);
    }
}
