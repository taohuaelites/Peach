package com.example.peach.controller;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.User;
import com.example.peach.service.InterestService;
import com.example.peach.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/12/4.
 */
@RestController
@RequestMapping(value = "/interest")
public class InterestController {

    @Resource
    private InterestService interestService;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/list")
    public List<String> selectById(@RequestParam int id) {
        List<String> list = interestService.selectById(id);
        return list;
    }


//    @RequestMapping(value = "/getUser")
//    public HashMap<String, Object> selectUserByInterest(@RequestParam int id) {
//
//        HashMap<String, Object> map = userService.selectUserByInterest(id);
//
//        return map;
//    }


    @RequestMapping(value = "update")
    public ServiceResponse updateInterest(@RequestParam int id, @RequestParam(value = "data[]") String[] data) {

        return null;

    }
}
