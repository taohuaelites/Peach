package com.example.peach.controller;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.Activity;
import com.example.peach.service.ActivityService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/15.
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Resource
    private ActivityService activityService;

    /**
     * 根据id查询Activity
     * @param id
     * @return
     */
    @RequestMapping(value = "/getActivity",method = RequestMethod.POST)
    public ServiceResponse<Map> getActivity(@RequestParam Integer id){

      return   activityService.selectById(id);
    }

    /**
     * 添加活动
     * @param activity
     * @return
     */
    @RequestMapping(value = "/insertActivity",method = RequestMethod.POST)
    public ServiceResponse<String> insertActivitys(@ModelAttribute Activity activity){

        return   activityService.insertActivity(activity);
    }
    /**
     * 根据id修改活动
     */
    @RequestMapping(value = "/updateActivitys",method = RequestMethod.POST)
    public ServiceResponse<String> updateActivitys(@ModelAttribute Activity activity){

        return   activityService.updateActivity(activity);
    }
    /**
     * 根据id删除
     */
    @RequestMapping(value = "/deleteActivitys",method = RequestMethod.POST)
    public ServiceResponse<String> deleteActivitys(@ModelAttribute Integer id){

        return   activityService.deleteActivity(id);
    }
    /**
     * 查询所有活动
     */
    @RequestMapping(value="/selectActivity",method = RequestMethod.GET)
    public Map<String,Object> selectActivity(){
      List<Activity> activity=  activityService.selectActivity();
      Map<String,Object> map=new HashMap<>();
        map.put("activity",activity);
        return  map;
    }
}
