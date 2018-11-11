package com.example.peachone.controller;

import com.example.peachone.common.Conts;
import com.example.peachone.common.ServiceResponse;
import com.example.peachone.pojo.User;
import com.example.peachone.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@MapperScan("com.example.peachone.mapper")
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

}