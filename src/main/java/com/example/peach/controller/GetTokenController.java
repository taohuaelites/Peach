package com.example.peach.controller;

import com.example.peach.pojo.Token;
import com.example.peach.service.TokenService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by Administrator on 2018/11/16.
 */
@RestController
@RequestMapping(value = "/get")
public class GetTokenController {

    @Resource
    private TokenService tokenService;

    @RequestMapping(value = "/token")
    public HashMap<String,String> GetToken(){

        Token token=tokenService.selectById();
        ObjectMapper mapper=new ObjectMapper();
        HashMap<String,String> map=new HashMap<>();
        if (token.getAccess_token()!=null){
            String access_token=token.getAccess_token();
            map.put("access_token",access_token);

        }else {
            map.put("access_token",null);
        }
        return map;
    }

}
