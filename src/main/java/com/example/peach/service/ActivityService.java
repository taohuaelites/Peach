package com.example.peach.service;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.Activity;

<<<<<<< HEAD
import java.util.List;
import java.util.Map;

=======
>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259
/**
 * Created by Administrator on 2018/11/15.
 */
public interface ActivityService {
<<<<<<< HEAD
    ServiceResponse<Map> selectById(Integer id);
=======
    ServiceResponse<String> selectById(Integer id);
>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259

    ServiceResponse<String> insertActivity(Activity activity);

    ServiceResponse<String> updateActivity(Activity activity);

    ServiceResponse<String> deleteActivity(Integer id);

<<<<<<< HEAD
    List<Activity > selectByActnature();
=======
    Activity selectByActnature(String actnature);
>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259
}
