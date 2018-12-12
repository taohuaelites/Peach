package com.example.peach.service;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
//    ServiceResponse<User> selectUserByid(int id);

    ServiceResponse<Map> selectByOpenid(String str, String type);

    ServiceResponse<Map> lognUser(User user);
    ServiceResponse<String> selectPhone(String phone);
    ServiceResponse<String> updateUser(User user);
    List<User> userList();
}
