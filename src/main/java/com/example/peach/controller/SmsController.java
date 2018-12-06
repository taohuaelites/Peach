package com.example.peach.controller;

/**
 * 手机验证码，注册接口
 * Created by Administrator on 2018/11/9.
 */

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.User;
import com.example.peach.service.UserService;
import com.example.peach.util.SmsSend;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/Sms")
public class SmsController {


    @Resource
    private UserService userService;

    SmsSend smsDemo = new SmsSend();
    /*
    阿里云短信发送接口
    传出参数{"PhoneNumber",PhoneNumber,
            "status":"true"or"false"//验证短信是否收到
            "Number":"Number",//验证码
            "sms":"false",//验证短信是否发送出去
            "Number":"Number"}//验证码

     */
    @RequestMapping(value = "/Send" , method = RequestMethod.POST)
    public ServiceResponse<Object> SmsSend(@RequestParam String userPhone) throws ClientException {


        User user=userService.selectByUserPhone(userPhone);
        if(user!=null){
            return ServiceResponse.createByError("该手机已注册！");
        }else {
            // /发送信息
            HashMap<String, String> map = smsDemo.sendSms(userPhone);

            ObjectMapper mapper = new ObjectMapper();
            QuerySendDetailsResponse querySendDetailsResponse =null;
            //检查信息是否成功
            if (map.get("BizId").equals("null")){
                return ServiceResponse.createByError("验证码发送失败，请重新发送！");
            }else {
                querySendDetailsResponse = smsDemo.querySendDetails(userPhone, map.get("BizId"));
                //存储短信验证结果
                if (querySendDetailsResponse.getCode().equals("OK")) {
                    return ServiceResponse.createBySuccess("验证码发送成功！");
                } else {
                    return ServiceResponse.createByError("验证码发送失败，请重新发送！");
                }
            }

        }

    }


    /**
     * 验证码验证
     */
    @RequestMapping(value = "/verification",method = RequestMethod.POST)
    public ServiceResponse<Object> SmsVerification(@ModelAttribute User user, @RequestParam String Number) throws ClientException {
        QuerySendDetailsResponse querySendDetailsResponse = smsDemo.querySendDetails(user.getUserPhone());
        //System.out.println(querySendDetailsResponse.getSmsSendDetailDTOs().get(0).getPhoneNum());
        //System.out.println(querySendDetailsResponse.getSmsSendDetailDTOs().get(0).getOutId());
        String userPhone= String.valueOf(querySendDetailsResponse.getSmsSendDetailDTOs().get(0).getPhoneNum());
        String outId= String.valueOf(querySendDetailsResponse.getSmsSendDetailDTOs().get(0).getOutId());
        if (user.getUserPhone().equals(userPhone) && Number.equals(outId)){
            int rs=userService.updateUserPhone(user);
            if (rs>0){
                return ServiceResponse.createBySuccess("手机绑定成功！");
            }else{
                return ServiceResponse.createByError("手机绑定失败!");
            }
        }else{
            return ServiceResponse.createByError("验证码错误！");
        }
    }
}