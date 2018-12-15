package com.example.peach;

import com.example.peach.dao.CommodityMapper;
import com.example.peach.dao.UserVipMapper;
import com.example.peach.pojo.Orderpay;
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
    @Resource
    private CommodityMapper commodityMapper;
    @Test
    public void ppp(){
        Orderpay orderpay = new Orderpay();
        orderpay.setTradeStatus("CLOSED");
        orderpay.setOutTradeNo("vv20f2eyc3may186j8tp181213233314");
        int getrows = orderPayService.updateOrder_statusByout_trade_no(orderpay);
        System.out.println(getrows);
       User user= userService.selectByOpenid("o5ZMc5McBorI7lPHbbtVZThlqsz4");
    }
}
