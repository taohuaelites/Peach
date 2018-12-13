package com.example.peach.service;

import com.example.peach.common.Pager;
import com.example.peach.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

public interface ExcelService {


    HashMap<String,Object> selectUserByInterest(int id);

    int updateUserPhone(User user);

    User selectByUserPhone(String userPhone);

    int insert(User user);

    String batchImport(String fileName, MultipartFile mfile);

}
