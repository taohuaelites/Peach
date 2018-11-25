package com.example.peach.service;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.Activity;

/**
 * Created by Administrator on 2018/11/15.
 */
public interface ActivityService {
    ServiceResponse<String> selectById(Integer id);

    ServiceResponse<String> insertActivity(Activity activity);

    ServiceResponse<String> updateActivity(Activity activity);

    ServiceResponse<String> deleteActivity(Integer id);

    Activity selectByActnature(String actnature);
}
