package com.example.peach;

import com.example.peach.dao.CommodityMapper;
import com.example.peach.dao.UserVipMapper;
import com.example.peach.pojo.Orderpay;
import com.example.peach.pojo.User;
import com.example.peach.service.OrderPayService;
import com.example.peach.service.UserService;
import com.example.peach.service.UserVipService;
import com.example.peach.service.WXPayService;
import com.example.peach.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
<<<<<<< HEAD
    private CommodityMapper commodityMapper;
=======
    private RedisUtil redisUtil;
>>>>>>> 0e2482c6f075569b83e0b9c76a85eab496290541
    @Test
    public void ppp(){
        Orderpay orderpay = new Orderpay();
        orderpay.setTradeStatus("CLOSED");
        orderpay.setOutTradeNo("vv20f2eyc3may186j8tp181213233314");
        int getrows = orderPayService.updateOrder_statusByout_trade_no(orderpay);
        System.out.println(getrows);
       User user= userService.selectByOpenid("o5ZMc5McBorI7lPHbbtVZThlqsz4");
    }
    @Test
    public  void demo(){


        Boolean lo=redisUtil.hasKey("name");
     Boolean boo=     redisUtil.set("name","xiaohe");
       Object str=   redisUtil.get("name");
        System.out.println(lo);

    }
}
