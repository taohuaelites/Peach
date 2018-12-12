package com.example.peach.service.impl;

import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.ActivityMapper;
import com.example.peach.pojo.Activity;
import com.example.peach.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
 * Created by Administrator on 2018/11/15.
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityMapper activityMapper;

    /**
     * 根据活动id查询
     * @param id
     * @return
     */
    @Override
    public ServiceResponse<Map> selectById(Integer id) {
        Activity activity=activityMapper.selectById(id);
        if (activity!=null){
            Map<String,Object> map=new HashMap<>();
            map.put("activity",activity);
            return ServiceResponse.createBySuccess("有活动",map);
        }
        return ServiceResponse.createByError("没活动");
    }

    /**
     * 添加活动对象
     * @param activity
     * @return
     */
    @Override
    public ServiceResponse<String> insertActivity(Activity activity) {
        int insert=  activityMapper.insertActivity(activity);
        if (insert>0){
            return  ServiceResponse.createBySuccess("添加成功");
        }
        return ServiceResponse.createByError("添加失败");
    }

    /**
     * 根据id修改
     * @param activity
     * @return
     */
    @Override
    public ServiceResponse<String> updateActivity(Activity activity) {
        int update=  activityMapper.updateActivity(activity);
        if (update>0){
            return  ServiceResponse.createBySuccess("修改成功");
        }
        return ServiceResponse.createByError("修改失败");
    }

    @Override
    public ServiceResponse<String> deleteActivity(Integer id) {
        int delete=activityMapper.deleteActivity(id);
        if (delete>0){
            return  ServiceResponse.createBySuccess("删除成功");
        }
        return ServiceResponse.createByError("删除失败");
    }

    /**
     * 查询所有活动
     * @return
     */
    @Override
    public List<Activity> selectActivity() {
        return activityMapper.selectActivity();
    }
}