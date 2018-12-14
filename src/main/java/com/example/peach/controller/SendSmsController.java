package com.example.peach.controller;

import com.example.peach.common.ServiceResponse;
import com.example.peach.util.SmsVerification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2018/12/7.
 */
@RestController
@RequestMapping(value = "/Send")
public class SendSmsController {

    @Resource
    private SmsVerification smsVerification;

    @RequestMapping(value = "/Sms")
    public ServiceResponse<Map> sendSms(@RequestParam String phoneNumber, @RequestParam Integer id) {

        ServiceResponse response = smsVerification.Send(phoneNumber,id);

        return response;
    }

    @RequestMapping(value = "/verification")
    public ServiceResponse SmsVerification(@RequestParam String phoneNumber, @RequestParam String number, @RequestParam Integer id) {

        ServiceResponse response=smsVerification.Verification(phoneNumber,number,id);
        return response;

    }

}
