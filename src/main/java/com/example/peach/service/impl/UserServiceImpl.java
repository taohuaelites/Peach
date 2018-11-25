package com.example.peach.service.impl;

import com.example.peach.common.Conts;
import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.UserMapper;
import com.example.peach.pojo.User;
import com.example.peach.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据openid查询用户
     * @param openid
     * @param type
     * @return
     */
    @Override
    public ServiceResponse<String> selectByOpenid(String openid, String type) {
        User user= userMapper.selectByOpenid(openid);
        if(type.equals(Conts.OPENID)){

            if (user!=null){
                return ServiceResponse.createByError("用户已经注册过");
            }
        }
        return  ServiceResponse.createBySuccess("用户需要注册");

}

    /**
     * 授权成功保存用户数据
     * @param user
     * @return
     */
    @Override
    public ServiceResponse<String> lognUser(@ModelAttribute User user) {
        ServiceResponse<String> response =  this.selectByOpenid(user.getOpenid(),Conts.OPENID);
        if(!response.isSuccess()){
          return response;
       }
        int userlogn = userMapper.insertSelective(user);
      if(userlogn>0){
          return ServiceResponse.createBySuccess("授权成功");

        }

        return  ServiceResponse.createByError("授权失败!!");
    }

    /**
     * 根据phone查询user
     * @param phone
     * @return
     */
    @Override
    public ServiceResponse<String> selectPhone(String phone) {
        User user=  userMapper.selectByphone(phone);
        if (user!=null){
            return ServiceResponse.createByError("该手机号已经绑定了");
        }
        return ServiceResponse.createBySuccess("√");
    }

    @Override
    public ServiceResponse<String> updateUser(User user) {
       int users= userMapper.updateByPrimaryKeySelective(user);
       if (users>0){
           return ServiceResponse.createBySuccess("修改成功");
       }
        return  ServiceResponse.createByError("修改失败");

    }

    @Override
    public List<User> userList() {
        return userMapper.userList();
    }

}
