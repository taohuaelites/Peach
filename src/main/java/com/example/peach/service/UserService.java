package com.example.peach.service;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.User;

public interface UserService {
//    ServiceResponse<User> selectUserByid(int id);

    ServiceResponse<String> selectByOpenid(String str,String type);

    ServiceResponse<String> lognUser(User user);
<<<<<<< HEAD

    //绑定手机号
    ServiceResponse<String> updateUserPhone(String user_phone,int id);
=======
    ServiceResponse<String> selectPhone(String phone);
    ServiceResponse<String> updateUser(User user);
>>>>>>> df52ec428250523b049c5492f50177d8dbaccee9
}
