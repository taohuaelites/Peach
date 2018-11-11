package com.example.peach.service.impl;

import com.example.peach.common.Conts;
import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.UserJPA;
import com.example.peach.dao.UserMapper;
import com.example.peach.pojo.User;
import com.example.peach.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserJPA userJPA;
    //查询标识
    @Override
    public ServiceResponse<String> selectOpenid(String str, String type) {
        User user = userJPA.findByOpenid(str);
        if(type.equals(Conts.OPENID)){
            if(user ==null){
                return ServiceResponse.createByError("用户已经注册过");
            }
        }
        return  ServiceResponse.createBySuccess("用户需要注册");
    }

    //录入授权信息
    @Override
    public ServiceResponse<String> lognUser(User user) {
        ServiceResponse<String> response =  this.selectOpenid(user.getOpenid(),Conts.OPENID);
        if(!response.isSuccess()){
            return response;
        }
        User userlogn = userJPA.save(user);
        if(userlogn==null){
            return  ServiceResponse.createByError("授权失败!!");
        }
        return ServiceResponse.createBySuccess("授权成功");
    }

}
