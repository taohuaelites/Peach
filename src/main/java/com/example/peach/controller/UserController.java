package com.example.peach.controller;

import com.example.peach.common.Conts;
import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.User;
import com.example.peach.service.UserService;
import org.apache.ibatis.jdbc.Null;
import org.mybatis.spring.annotation.MapperScan;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 3b6aa3d79371f2c648dc57e4fbbfcba963361f62

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@MapperScan("com.example.peach.mapper")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 微信授权
     * @param user
     * @return
     */
    @RequestMapping(value = "/lognUser",method = RequestMethod.POST)
    public ServiceResponse<String> lognUser(User user){
        ServiceResponse<String> response = userService.lognUser(user);
        System.out.println();
        return response;
    }

    /**
     * 查询用户唯一标识
     * @param openid
     * @return
     */
    @RequestMapping(value = "/findUserByOpenid",method = RequestMethod.POST)
    public ServiceResponse<String> selectOpenid(String openid){
        ServiceResponse<String> response = userService.selectOpenid(openid, Conts.OPENID);
        return response;
    }

    /*@RequestMapping(value = "/registerUser",method = RequestMethod.POST)
<<<<<<< HEAD
    public  ServiceResponse<String> SaveUser*/



    //绑定手机号
    @RequestMapping(value="/Registration/{user_phone}/{id}")
    public String  RegistrationController(@PathVariable("user_phone") String  user_phone,@PathVariable("id")int id){
        int rs=userService.updateUserPhone(user_phone,id);
        if(rs>0){
            return "hellow,word";
        }else{
            return "hellow,word";
        }
    }

=======
    public  ServiceResponse<String> re*/
>>>>>>> 3b6aa3d79371f2c648dc57e4fbbfcba963361f62
}
