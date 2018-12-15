package com.example.peach.controller;

import com.example.peach.common.Conts;
import com.example.peach.common.ServiceResponse;
import com.example.peach.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


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
