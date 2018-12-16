package com.example.peach.service.impl;

import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.ActOrderMapper;

import com.example.peach.dao.ActivityMapper;
import com.example.peach.dao.UserMapper;
import com.example.peach.pojo.ActOrder;
import com.example.peach.pojo.Activity;
import com.example.peach.pojo.User;
import com.example.peach.service.ActOrderService;
import com.example.peach.util.DateSub;

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
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private UserMapper userMapper;
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
        Activity activity= activityMapper.selectById(actOrder.getActivityId());
        //当前时间与活动开始时间的天数差
        Long longs= DateSub.getDaySub(activity.getActtime());
        if (longs>=1){
            int insert= actOrderMapper.insertActOrder(actOrder);
            if (insert>0){
                return  ServiceResponse.createBySuccess("报名成功");
            }
        }
        return ServiceResponse.createByError("报名失败");
    }

    /**
     * 根据活动单id查询所有活动
     * @param activityId
     * @return
     */
    @Override
    public List<ActOrder> selectActOrderList(Integer activityId) {
        return actOrderMapper.selectActOrderList(activityId);
    }

    @Override
    public ServiceResponse<String> updateActOrder(ActOrder actOrder) {
        Activity activity= activityMapper.selectById(actOrder.getActivityId());
        Long longs=DateSub.getMinSub(activity.getActtime());
        if (longs<=30&longs>= -30){
            User user=userMapper.selectByPrimaryKey(actOrder.getUserId());
            int  update =actOrderMapper.updateActOrder(actOrder);
            if (update>0){
                User users=new User();
                users.setOpenid(user.getOpenid());
                users.setUserIntegral(user.getUserIntegral()+10);
                int updates =userMapper.updateByPrimaryKeySelective(users);
                return  ServiceResponse.createBySuccess("签到成功");
            }
        }

        return ServiceResponse.createByError("签到失败");
    }

    /**
     * 根据userId查询所有活动单
     * @param userId
     * @return
     */
    @Override
    public List<ActOrder> selectUserId(Integer userId) {
        return actOrderMapper.selectUserId(userId);
    }
}
