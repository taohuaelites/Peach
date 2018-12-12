package com.example.peach.service.impl;

import com.example.peach.common.Conts;
import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.UserMapper;
import com.example.peach.pojo.User;
import com.example.peach.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    //查询标识
    @Override
    public ServiceResponse<String> selectOpenid(String str, String type) {
        User user = userMapper.selectByOpenid(str);
        if(type.equals(Conts.OPENID)){
            if(user !=null){
                return  ServiceResponse.createBySuccess("用户存在");

            }else{
                return ServiceResponse.createByError("用户还没有进行授权");
            }
        }
        if (type.equals(Conts.NEWOLD)){
            if(user.getUserNewold()==1) {
                return ServiceResponse.createBySuccess("用户是新用户");
            }else{
                return ServiceResponse.createByError("用户是老用户");
            }
        }
    return ServiceResponse.createByError("错误");
    }

    @Override
    public User selectByOpenid(String openid) {
        User user = userMapper.selectByOpenid(openid);
        if(user!=null){
            System.out.println("openid:查询成功");
            return user;
        }else{
            System.out.println("没有次用户");
            return user;
        }
    }

    //录入授权信息
    @Override
    public ServiceResponse<String> lognUser(User user) {
        ServiceResponse<String> response =  this.selectOpenid(user.getOpenid(),Conts.OPENID);
        if(!response.isSuccess()){
            return response;
        }
        int getrows= userMapper.insert(user);
        if(getrows>0){
            return ServiceResponse.createBySuccess("授权成功");

        }
        return  ServiceResponse.createByError("授权失败!!");
    }

    /**
     * 该买会员修改积分,如果是新用户修改成老用户
     * @param user
     * @return
     */
    @Override
    public ServiceResponse<Integer> updateUnewoldAndUIntegralByOpenid(User user) {
        int getrows = userMapper.updateUnewoldAndUIntegralByOpenid(user);
        if(getrows>0){
            return ServiceResponse.createBySuccess("用户信息修改成功");
        }else{
            return  ServiceResponse.createByError("用户信息修改失败");
        }
    }


}
