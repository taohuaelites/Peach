package com.example.peach;

import com.example.peach.dao.UserVipMapper;
import com.example.peach.pojo.User;
import com.example.peach.service.OrderPayService;
import com.example.peach.service.UserService;
import com.example.peach.service.UserVipService;
import com.example.peach.service.WXPayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PeachoneApplicationTests {
    @Resource
    private UserVipMapper userVipMapper;
    @Resource
    private OrderPayService orderPayService;
    @Resource
    private UserVipService userVipService;
    @Resource
    private UserService userService;
    @Resource
    private WXPayService wxPayService;
    @Test
    public void ppp(){
       User user= userService.selectByOpenid("o5ZMc5McBorI7lPHbbtVZThlqsz4");
        System.out.println(user.getNickname());
    }
}
