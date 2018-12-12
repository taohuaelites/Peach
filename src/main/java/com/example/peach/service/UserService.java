package com.example.peach.service;

import com.example.peach.common.Pager;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.User;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {


    ServiceResponse<Map> selectByOpenid(String str, String type);

    ServiceResponse<Map> lognUser(User user);
    ServiceResponse<String> selectPhone(String phone);
    ServiceResponse<String> updateUser(User user);
    List<User> userList();


}
