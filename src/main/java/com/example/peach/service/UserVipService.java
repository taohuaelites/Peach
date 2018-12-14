package com.example.peach.service;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.UserVip;
import com.example.peach.pojo.merge.UvipUser;

public interface UserVipService {
    //修改用户信息
    ServiceResponse<String> updateByUserId(UserVip userVip);
    //添加用户vip信息
    ServiceResponse<String> addUserVip(UserVip userVip);
    //约见成功相减zUserid:主约id,bUserid:被约id
    ServiceResponse<String> upateUappointmentByid(Integer zUserid, Integer bUserid);
    //钱包充值
    ServiceResponse<String> updateUwlletByUserId(Double money,Integer userId);
    //是否会员或会员过期
    ServiceResponse<UvipUser> selectCreatAndEndByUserId(Integer userId);
}
