package com.example.peach.controller;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.ActOrder;
import com.example.peach.pojo.Activity;
import com.example.peach.service.ActOrderService;
import com.example.peach.service.ActivityService;
import com.example.peach.util.DateSub;
import com.example.peach.util.RandomStringGenerator;
import org.hibernate.validator.constraints.URL;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/17.
 */
@RestController
@MapperScan("com.example.peach.mapper")
@RequestMapping("/actorder")
public class ActOrderController {
    @Resource
     private ActOrderService actOrderService;
    @Resource
     private ActivityService activityService;
    /**
     * 查询活动单
     * @param id
     * @return
     */
    @RequestMapping(value = "/getActOrder",method = RequestMethod.POST)
    public Map<String,Object> getActOrder(@RequestParam Integer id){
        ActOrder actOrder = actOrderService.getActOrder(id);
        Map<String,Object> map=new HashMap<>();
        map.put("actOrder",actOrder);
        return map;
    }
    /**
     * 添加活动单
     */
    @RequestMapping(value = "/insertActOrder",method = RequestMethod.POST)
    public ServiceResponse<String> insertActOrder(@ModelAttribute ActOrder actOrder){
        actOrder.setOrderNumber(RandomStringGenerator.getRandomStringtime(20));
        return actOrderService.insertActOrder(actOrder);
    }
    /**
     * 根据activityId活动性质查询所有
     */
    @RequestMapping(value = "/selectActOrderList",method = RequestMethod.GET)
    public Map<String,Object> selectActOrderList(@RequestParam Integer activityId){
        List<ActOrder> list= actOrderService.selectActOrderList(activityId);
        Map<String,Object> map=new HashMap<>();
        map.put("list",list);
        return map;
    }
    /**
     *  活动签到
     */
    @RequestMapping(value = "/updateSignIn",method = RequestMethod.POST)
    public ServiceResponse<String> updateSignIn(@ModelAttribute ActOrder actOrder){
        actOrder.setSignIn(1);
        return actOrderService.updateActOrder(actOrder);
    }
}
