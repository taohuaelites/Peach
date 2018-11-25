package com.example.peach.controller;

/**
 * 手机验证码，注册接口
 * Created by Administrator on 2018/11/9.
 */

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.example.peach.util.SmsSend;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value="/Sms")
public class SmsController {


    SmsSend smsDemo = new SmsSend();

    /*
    阿里云短信发送接口
    传出参数{"PhoneNumber",PhoneNumber,
            "status":"true"or"false"//验证短信是否收到
            "Number":"Number",//验证码
            "sms":"false",//验证短信是否发送出去
            "Number":"Number"}//验证码

     */
    @RequestMapping(value = "/Send/{PhoneNumber}")
    public HashMap<String, String> SmsSend(@PathVariable String PhoneNumber) throws ClientException {


        // /发送信息
        HashMap<String, String> map = smsDemo.sendSms(PhoneNumber);

        ObjectMapper mapper = new ObjectMapper();
        QuerySendDetailsResponse querySendDetailsResponse =null;
        //检查信息是否成功
        if (map.get("BizId").equals("null")){
            map.put("status","ERROR");
        }else {
            querySendDetailsResponse = smsDemo.querySendDetails(PhoneNumber, map.get("BizId"));

            map.remove("BizId");
            //存储短信验证结果
            if (querySendDetailsResponse.getCode().equals("OK")) {
                map.put("status", "SUCCESS");
            } else {
                map.remove("Number");
                map.put("status", "ERROR");
            }
        }


        return map;
    }


    /*
    阿里云短信验证接口

     */

}