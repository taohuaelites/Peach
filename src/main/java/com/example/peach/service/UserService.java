package com.example.peach.service;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.User;

public interface UserService {
//    ServiceResponse<User> selectUserByid(int id);

    ServiceResponse<String> selectOpenid(String str,String type);

    ServiceResponse<String> lognUser(User user);

    //绑定手机号
    ServiceResponse<String> updateUserPhone(String user_phone,int id);
}
