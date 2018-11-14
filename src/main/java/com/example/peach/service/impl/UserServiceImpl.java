package com.example.peach.service.impl;

import com.example.peach.common.Conts;
import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.UserMapper;
import com.example.peach.pojo.User;
import com.example.peach.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;

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
<<<<<<< HEAD
            if (user!=null){
                return ServiceResponse.createByError("用户已经注册过");
            }
        }

        return  ServiceResponse.createBySuccess("用户需要注册");
=======
            if(user ==null){
                return  ServiceResponse.createBySuccess("用户需要注册");

            }
        }
        return ServiceResponse.createByError("用户已经注册过");
>>>>>>> b578bdac68c4bacddf0dd37591fabc5b013931c2
    }

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

    @Override
    public ServiceResponse<String> selectPhone(String phone) {
        return null;
    }

    @Override
    public ServiceResponse<String> updateUser(User user) {
        return null;
    }
//
//    //查询标识
//    @Override
//    public ServiceResponse<String> selectOpenid(String str, String type) {
////        User user = userJPA.findByOpenid(str);
////        if(type.equals(Conts.OPENID)){
////            if(user !=null){
////                return ServiceResponse.createByError("用户已经注册过");
////            }
////        }
////        return  ServiceResponse.createBySuccess("用户需要注册");
////    }
//
//    //录入授权信息
//    @Override
//    public ServiceResponse<String> lognUser(User user) {
////        ServiceResponse<String> response =  this.selectOpenid(user.getOpenid(),Conts.OPENID);
////        if(!response.isSuccess()){
////            return response;
////        }
////        User userlogn = userJPA.save(user);
////        if(userlogn==null){
////            return  ServiceResponse.createByError("授权失败!!");
////        }
////
////        return ServiceResponse.createBySuccess("授权成功");
//   }
//
//    /**
//     * 查询手机号
//     * @param phone
//     * @return user
//     */
//    @Override
//    public ServiceResponse<String> selectPhone( String phone) {
////        User user =userJPA.findByUserphone(phone);
////        if (user!=null){
////            return ServiceResponse.createBySuccess("该手机号已被绑定");
////        }
////        return ServiceResponse.createBySuccess();
//    }
//
//    /**
//     * 用户完善信息
//     * @return
//     */
//    @Override
//    public ServiceResponse<String> updateUser(User user) {
//
////        int users  =userJPA.updateUser(user);
////        if (users>0){
////            return ServiceResponse.createBySuccess("注册成功");
////        }
////        return ServiceResponse.createBySuccess();
////    }

}
