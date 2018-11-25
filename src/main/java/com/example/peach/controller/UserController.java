package com.example.peach.controller;

import com.example.peach.common.Conts;
import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.User;
import com.example.peach.service.UserService;

import org.mybatis.spring.annotation.MapperScan;




import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

import javax.servlet.http.HttpSession;


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
    public ServiceResponse<String> lognUser(User user, HttpSession session){
        ServiceResponse<String> response = userService.lognUser(user);
        session.setAttribute("user",user);
        return response;
    }
    /**
     * 查询用户唯一标识
     * @param openid
     * @return
     */
    @RequestMapping(value = "/findUserByOpenid")
    public ServiceResponse<String> selectOpenid(String openid){

//        ServiceResponse<String> response = userService.selectOpenid(openid, Conts.OPENID);
        return null;
    }





    //绑定手机号
//    @RequestMapping(value="/registration/{user_phone}/{id}")
//    public ServiceResponse<String> updateUserPhone(@PathVariable("user_phone") String user_phone,@PathVariable("user_phone") int id) {
//
//        ServiceResponse<String> response=userService.updateUserPhone(user_phone,id);
//
//        return response;
//    }


    /*@RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public  ServiceResponse<String> SaveUser*/
    /**
     *
     */
    /**
     *  查询手机号是否已经绑定
     */
    @RequestMapping(value = "/selectPhone",method = RequestMethod.POST)
    public ServiceResponse<String> selectPhone(@RequestParam("userphone") String phone){
        ServiceResponse<String> response = userService.selectPhone(phone);
        return response;
    }
    /**
     * 用户信息完善
     */
    @RequestMapping(value = "/updatePhone",method = RequestMethod.POST)
    public ServiceResponse<String> updatePhone(@ModelAttribute User user, HttpSession session){
//         User getuser=(User) session.getAttribute("user");
//         user.setOpenid(getuser.getOpenid());
//        ServiceResponse<String> response = userService.updateUser(user);
        return null;
    }


}
