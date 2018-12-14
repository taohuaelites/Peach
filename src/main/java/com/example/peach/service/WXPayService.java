package com.example.peach.service;

import com.example.peach.common.ServiceResponse;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Map;

public interface WXPayService {
    /**
     * 支付付款
     * @param mapinfo
     * @return
     * @throws IllegalAccessException
     */
    ServiceResponse<Map> paymettwe(Map mapinfo, HttpServletRequest request) throws IllegalAccessException;

    //回调逻辑
    void wxpayBackmysql(String openid, String out_trade_no, Double cash_fee) throws ParseException;

    /**
     *  微信查询订单
     * @param out_trade_no 商户订单号
     * @return
     */
    ServiceResponse<Object> orderQueryZT(String out_trade_no);
}
