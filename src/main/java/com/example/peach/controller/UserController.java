package com.example.peach.controller;


import com.example.peach.common.Conts;
import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.User;
import com.example.peach.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.annotation.MapperScan;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@MapperScan("com.example.peach.mapper")
public class UserController {
    @Resource
    private UserService userService;

//    /**
//     * 微信授权
//     * @param user
//     * @return
//     */
//    @RequestMapping(value = "/lognUser",method = RequestMethod.POST)
//    public ServiceResponse<Map> lognUser(@ModelAttribute User user, HttpSession session){
//        ServiceResponse<Map> response = userService.lognUser(user);
////        session.setAttribute("user",user);
//        return response;
//    }
    /**
     * 查询用户唯一标识
     * @param openid
     * @return
     */
    @RequestMapping(value = "/selectOpenid",method = RequestMethod.GET)
    public ServiceResponse<Map> selectOpenid(@RequestParam String openid){
        ServiceResponse<Map> response = userService.selectByOpenid(openid, Conts.OPENID);
        return response;
    }
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
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public ServiceResponse<String> updateUser(@ModelAttribute User user){
        ServiceResponse<String> response = userService.updateUser(user);
        return response;
    }
    /**
     *
     * 查询所有用户
     */
        @RequestMapping(value = "/userList",method = RequestMethod.POST)
        public Map<String,Object> userList(){
             List<User> users= userService.userList();
            Map<String,Object> map =new HashMap<>();
            map.put("userlist",users);
            return  map;
        }
    /**
     * 更新兴趣爱好
     * @param
     * @return
     */
    @RequestMapping(value = "/updateInterest",method = RequestMethod.POST)
    public  ServiceResponse<String> updateInterest(@RequestParam("datas[]")String[] string , User user){
        String str= StringUtils.join(string,",");
        user.setUserInterest(str);
        return userService.updateUser(user);
    }

    /**
     * 用户认证 是：true
     * @param
     * @return
     */
    @RequestMapping(value = "/updateRealName",method = RequestMethod.POST)
    public ServiceResponse<String> updateRealName(@ModelAttribute User user){
        user.setIsrealname(true);
        return userService.updateUser(user);
    }
    @RequestMapping(value = "/test")
        public String test(Model model){
            model.addAttribute("name","saa");
            return "demo";
        }

}
