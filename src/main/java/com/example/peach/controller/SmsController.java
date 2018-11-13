package com.example.peach.controller;

/**
 * 手机验证码，注册接口
 * Created by Administrator on 2018/11/9.
 */

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.example.peach.common.SmsDemo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value="/Sms")
public class SmsController {


    SmsDemo smsDemo = new SmsDemo();

    /*
    阿里云短信发送接口
    传出参数{"PhoneNumber",PhoneNumber,
            "status":"true"or"false"//验证短信是否收到
            "Number":"Number",//验证码
            "sms":"false",//验证短信是否发送出去
            "Number":"Number"}//验证码

     */
    @RequestMapping(value = "/Send/{PhoneNumber}")
    public String SmsSend(@PathVariable String PhoneNumber) throws ClientException {

        HashMap<String, String> map = new HashMap<String, String>();
        // /发送信息
        map = smsDemo.sendSms(PhoneNumber);

        ObjectMapper mapper = new ObjectMapper();
        QuerySendDetailsResponse querySendDetailsResponse =null;
        //检查信息是否成功
        if (map.get("BizId").equals("null")){
            map.put("sms","false");
        }else {
            querySendDetailsResponse = smsDemo.querySendDetails(PhoneNumber, map.get("BizId"));


            map.remove("BizId");

            //存储短信验证结果
            if (querySendDetailsResponse.getCode().equals("OK")) {
                map.put("status", "true");
            } else {
                map.remove("Number");
                map.put("status", "false");
            }
        }

        //map转化成josn字符串
        String josn = null;
        try {
            josn = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return josn;
    }


    /*
    阿里云短信验证接口

     */

}