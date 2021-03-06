package com.example.peach.service;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
   User selectByOpenid(String openid);

    //修改用户是否新老用户,用户vip等级
    ServiceResponse<Integer> updateUnewoldAndUIntegralByOpenid(User user);

    ServiceResponse<Map> selectByOpenid(String str, String type);

    ServiceResponse<Map> lognUser(User user);

    ServiceResponse<String> selectPhone(String phone);

    ServiceResponse<String> updateUser(User user);

    List<User> userList();

    int updateUserPhone(User user);

     User selectByPrimaryKey(Integer id);
}

