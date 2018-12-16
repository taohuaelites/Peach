package com.example.peach.controller;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.ActOrder;
import com.example.peach.service.ActOrderService;
import com.example.peach.service.ActivityService;
import com.example.peach.util.RandomStringGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/17.
 */
@RestController
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
     * 根据activityId查询
     */
    @RequestMapping(value = "/selectActOrderList",method = RequestMethod.GET)
    public Map<String,Object> selectActOrderList(@RequestParam Integer activityId){
        List<ActOrder> list= actOrderService.selectActOrderList(activityId);
        Map<String,Object> map=new HashMap<>();
        map.put("list",list);
        return map;
    }
    /**
     * 根据userId查询活动单
     */
    @RequestMapping(value = "/selectUserIdList",method = RequestMethod.GET)
    public Map<String,Object> selectUserId(@RequestParam Integer id) {
        List<ActOrder> list = actOrderService.selectUserId(id);
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        return map;
    }
    /**
     * 根据id查询
     */
    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    public Map<String,Object> selectById(@RequestParam Integer id) {
        ActOrder actOrder = actOrderService.selectById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("actOrder", actOrder);
        return map;
    }
    /**
     * 根据activityId查询用户和相册
     */
    @RequestMapping(value = "/selectActId",method = RequestMethod.GET)
    public Map<String,Object> selectActId(@RequestParam Integer activityId){
        List<ActOrder> list= actOrderService.selectByActId(activityId);
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
