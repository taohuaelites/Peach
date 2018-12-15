package com.example.peach.controller;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.Interest;
import com.example.peach.pojo.User;
import com.example.peach.service.InterestService;
import com.example.peach.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    public ServiceResponse selectById(@RequestParam Integer id) {

        if (id!=null){
            List<String> list = interestService.selectById(id);
            return ServiceResponse.createBySuccess(list);
        }else{
            return ServiceResponse.createByError("传入空值！");
        }
    }


    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ServiceResponse selectUserByInterest(@RequestParam Integer id){

        if (id!=null){
            ServiceResponse response=interestService.selectUserByInterest(id);
            return response;
        }else {
            return ServiceResponse.createByError("传入空值！");
        }
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ServiceResponse updateInterest(@RequestParam Integer id,@RequestParam(value = "data[]")String[] data){

        String str= StringUtils.join(data,",");
        Interest interest=new Interest();
        interest.setId(id);
        interest.setCategory(str);
        return interestService.updateInterest(interest);
    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ServiceResponse insertInerest(@ModelAttribute Interest interest){

        return interestService.insertInterest(interest);

    }

}
