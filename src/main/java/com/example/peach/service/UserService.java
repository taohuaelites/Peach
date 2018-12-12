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
<<<<<<< HEAD
//    ServiceResponse<User> selectUserByid(int id);
    //查询是否有该用户
    ServiceResponse<String> selectOpenid(String str,String type);
    //根据查询openid返回user信息
    User selectByOpenid(String openid);

    ServiceResponse<String> lognUser(User user);
    //修改用户是否新老用户,用户vip等级
    ServiceResponse<Integer> updateUnewoldAndUIntegralByOpenid(User user);
}
=======


    HashMap<String,Object> selectUserByInterest(int id);

    int updateUserPhone(User user);

    List<User> getUser();

    Pager<User> getPager(int pageIndex, int pageSize);

    User selectByUserPhone(String userPhone);

    int insert(User user);

    String batchImport(String fileName, MultipartFile mfile);

}
>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259
