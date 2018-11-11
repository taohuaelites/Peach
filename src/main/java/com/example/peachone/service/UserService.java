package com.example.peachone.service;

import com.example.peachone.common.ServiceResponse;
import com.example.peachone.pojo.User;

public interface UserService {
//    ServiceResponse<User> selectUserByid(int id);

    ServiceResponse<String> selectOpenid(String str,String type);

    ServiceResponse<String> lognUser(User user);
}
