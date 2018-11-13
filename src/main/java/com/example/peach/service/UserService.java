package com.example.peach.service;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.User;

public interface UserService {
//    ServiceResponse<User> selectUserByid(int id);

    ServiceResponse<String> selectOpenid(String str,String type);

    ServiceResponse<String> lognUser(User user);

    int updateUserPhone(String user_phone,int id);
}
