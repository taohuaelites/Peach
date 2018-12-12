package com.example.peach.service.impl;

import com.example.peach.common.Conts;
import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.UserMapper;
import com.example.peach.pojo.User;
import com.example.peach.service.UserService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ServiceResponse<Map> selectByOpenid(String openid, String type) {
        User user= userMapper.selectByOpenid(openid);
        Map<String,Object> map=new  HashMap<>();
        if(type.equals(Conts.OPENID)){

            if (user!=null){
                map.put("user",user);
                return ServiceResponse.createBySuccess("用户登录成功",map);
            }
        }
        return  ServiceResponse.createByError("用户需要注册");

}

    /**
     * 授权成功保存用户数据
     * @param user
     * @return
     */
    @Override
    public ServiceResponse<Map> lognUser( User user) {
        ServiceResponse<Map> response =  this.selectByOpenid(user.getOpenid(),Conts.OPENID);
        if(response.isSuccess()){
          return response;
       }
        int userlogn = userMapper.insertSelective(user);
        Map<String,Object> map=new  HashMap<>();
      if(userlogn>0){
          map.put("user",user);
          return ServiceResponse.createBySuccess("授权成功",map);

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
