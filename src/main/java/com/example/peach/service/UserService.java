package com.example.peach.service;

import com.example.peach.common.Pager;

import com.example.peach.pojo.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public interface UserService {


    HashMap<String,Object> selectUserByInterest(int id);

    int updateUserPhone(User user);

    List<User> getUser();

    Pager<User> getPager(int pageIndex, int pageSize);

    User selectByUserPhone(String userPhone);

    int insert(User user);

    String batchImport(String fileName, MultipartFile mfile);

}
