package com.example.peach.service;

import com.example.peach.common.Pager;

import com.example.peach.pojo.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import java.util.List;
import java.util.Map;

public interface UserService {

<<<<<<< HEAD
    ServiceResponse<Map> selectByOpenid(String str, String type);

    ServiceResponse<Map> lognUser(User user);
    ServiceResponse<String> selectPhone(String phone);
    ServiceResponse<String> updateUser(User user);
    List<User> userList();
=======

    HashMap<String,Object> selectUserByInterest(int id);

    int updateUserPhone(User user);

    List<User> getUser();

    Pager<User> getPager(int pageIndex, int pageSize);

    User selectByUserPhone(String userPhone);

    int insert(User user);

    String batchImport(String fileName, MultipartFile mfile);

>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259
}
