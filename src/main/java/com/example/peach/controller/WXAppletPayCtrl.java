package com.example.peach.controller;


import com.example.peach.common.Conts;
import com.example.peach.common.ServiceResponse;
import com.example.peach.configuration.Configure;
import com.example.peach.pojo.Orderpay;
import com.example.peach.pojo.pay.OrderQueryParamsInfo;
import com.example.peach.pojo.pay.Transfers;
import com.example.peach.pojo.pay.TransfersInfo;
import com.example.peach.service.OrderPayService;
import com.example.peach.service.UserService;
import com.example.peach.service.WXPayService;
import com.example.peach.util.CertUtil;
import com.example.peach.util.PayUtil;
import com.example.peach.util.RandomStringGenerator;
import com.example.peach.util.Signature;
import com.thoughtworks.xstream.XStream;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 商户充值
 */
@RestController
@RequestMapping(value = "/api/pay")
public class WXAppletPayCtrl {
    @Resource
    private OrderPayService orderPayService;
    @Resource
    private WXPayService wxPayService;
    @Resource
    private UserService userService;
    private static final Logger L = Logger.getLogger(WXAppletPayCtrl.class);
    //交易类型

    /**
     * 购买vip
     *
     * @param request
     * @return
     * @throws ParseException
     * @throws IllegalAccessException
     */
    @RequestMapping(value = "/weixin/payvip", method = RequestMethod.POST)
    public ServiceResponse<Map> payVip(HttpServletRequest request) throws ParseException, IllegalAccessException {
        ServiceResponse openidresponse = userService.selectOpenid(request.getParameter("openid"), Conts.OPENID);
        if (openidresponse.isSuccess()) {
            ServiceResponse orderPayresponse = orderPayService.Pricerevision(request.getParameter("openid"), 2);
            if (orderPayresponse.isSuccess()) {
                ServiceResponse<Map> response1 = wxPayService.paymettwe((Map) orderPayresponse.getData(),request);
                if(response1.isSuccess()){
                    return response1;
                }else{
                    return response1;
                }

            } else {
                return orderPayresponse;
            }
        } else {
            return ServiceResponse.createByError("您还没有进行授权", null);
        }
    }

    /**
     * 充值
     *
     * @param request
     * @return
     * @throws IllegalAccessException
     */
    @RequestMapping(value = "/weixin/recharge", method = RequestMethod.POST)
    public ServiceResponse<Map> payRecharge(HttpServletRequest request) throws IllegalAccessException {
        Map map = new HashMap();
        map.put("money", Double.parseDouble(request.getParameter("money")));
        map.put("openid", request.getParameter("openid"));
        map.put("commodityId", 0);
        map.put("body", "他她派充值:" + request.getParameter("money") + "元");
        ServiceResponse<Map> response = wxPayService.paymettwe(map,request);
        return response;
    }

    /**
     * 支付成功回调函数
     *
     * @param response
     * @param request
     * @throws Exception
     */
    @RequestMapping(value = "/weixin/WXpayBack")
    public void PayNotify(HttpServletResponse response, HttpServletRequest request) throws Exception {
        System.out.println("已进入微信支付回调接口-----订单支付完成回调更新订单状态");
        //读取参数
        InputStream inputStream;
        StringBuffer sb = new StringBuffer();
        inputStream = request.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        bufferedReader.close();
        inputStream.close();

        String notify = sb.toString();
        String resXml = "";
        System.out.println("接受到的文件" + notify);
        Map map = PayUtil.doXMLParse(notify);

        String returnCode = (String) map.get("return_code");
        if ("SUCCESS".equals(returnCode)) {
            //验证签名是否正确
            Map<String, String> tonullmap = PayUtil.paraFilter(map);//回调验签时需要去除sign和空值参数
            String vailder = PayUtil.createLinkString(tonullmap);//把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
            String sign = PayUtil.sign(vailder, Configure.getKey(), "utf-8").toUpperCase();//拼装生成服务器端验证的签名
            //根据微信官网的介绍，此处不仅对回调的参数进行验签，还需要对返回的金额与系统订单的金额进行比对
            if (sign.equals(map.get("sign"))) {
                ServiceResponse orderqueryResponse = wxPayService.orderQueryZT((String) map.get("out_trade_no"));
                OrderQueryParamsInfo orderpayInfo = (OrderQueryParamsInfo) orderqueryResponse.getData();//查询订单状态
                if (orderpayInfo.getTotal_fee() == (int)map.get("total_fee")&&orderpayInfo.getTrade_state().equals("SUCCESS")) {
                    Orderpay orderpay = new Orderpay();
                    orderpay.setTransactionId((String) map.get("transaction_id"));
                    orderpay.setUpdateTime((String) map.get("time_end"));
                    orderpay.setTradeStatus("SUCCESS");
                    int getrows = orderPayService.updateOrder_statusByout_trade_no(orderpay);
                    if (getrows > 0) {
                        System.out.println("数据库订单状况更新成功");
                    } else {
                        L.warn("数据库订单状况更新失败");
                    }
                    wxPayService.wxpayBackmysql((String) map.get("openid"), (String) map.get("out_trade_no"), (Double) map.get("cash_fee"));
                    //通知微信服务器已经支付成功
                    resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                            + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
                    System.out.println("回调支付成功");
                } else {
                    L.warn("微信支付回调失败!金额不一致");

                }
            } else {
                L.warn("微信支付回调失败!签名不一致");
            }
        } else {
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        System.out.println("resXml:" + resXml);
        System.out.println("微信支付回调结束");

        BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        outputStream.write(resXml.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 订单查询
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/orderquery", method = RequestMethod.POST)
    public ServiceResponse<Object> orderQuery(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServiceResponse<Object> orderQueryZTresponse = wxPayService.orderQueryZT(request.getParameter("out_trade_no"));
        return orderQueryZTresponse;
    }

    /**
     * 订单关闭
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/closepay", method = RequestMethod.POST)
    public ServiceResponse<Object> ClosePay(HttpServletRequest request, HttpServletResponse response) {
        ServiceResponse closerequse = wxPayService.ClosePay(request.getParameter("out_trade_no"));
        return closerequse;
    }

    private final String Refund_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";

    /**
     * 微信申请退款
     *
     * @param out_trade_no 商户订单号
     * @param total_fee    订单金额  微信金额的单位是分 所以这里要X100 转成int是因为 退款的时候不能有小数点
     * @return
     */
    @RequestMapping(value = "/refunpay",method = RequestMethod.POST)
    public ServiceResponse<Map> RefundPay(String out_trade_no, double total_fee) {
        long money=Math.round(total_fee*100);
        String param = PayUtil.wxPayRefund(out_trade_no, String.valueOf(money));
        System.out.println("支付退款签名:" + param);
        String result = "";
        Map map = null;
        try {
            result = CertUtil.refund(param);
            System.out.println(result);
            Map paraminfo = PayUtil.doXMLParse(result);//xml转map
            if ("SUCCESS".equals(paraminfo.get("return_code"))) {
                if ("SUCCESS".equals(paraminfo.get("result_code"))) {
                    //退款成功的操作
                    String prepay_id = (String) paraminfo.get("prepay_id");//返回的预付单信息
                    System.out.println(prepay_id);
                    map.put("transaction_id", paraminfo.get("transaction_id"));//微信订单号
                    map.put("out_refund_no", paraminfo.get("out_refund_no"));//商户退款单号
                    map.put("out_trade_no", paraminfo.get("out_trade_no"));//商户订单号
                    map.put("refund_id", paraminfo.get("refund_id"));//微信退款单号
                    map.put("refund_fee", paraminfo.get("refund_fee"));//退款金额

                    return ServiceResponse.createBySuccess(map);
                } else {
                    System.out.println("退款失败:原因" + paraminfo.get("err_code_des"));
                    return ServiceResponse.createByError(paraminfo);
                }
            } else {
                System.out.println("退款失败:原因" + paraminfo.get("return_msg"));
                return ServiceResponse.createByError(paraminfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Pattern p = Pattern.compile("");
        return ServiceResponse.createByError(null);
    }

    /**
     * 订单历史
     * @param userId
     * @return
     */
    @RequestMapping(value = "/weixin/bill", method = RequestMethod.GET)
    public ServiceResponse<List> Billinghistory(Integer userId) {
        ServiceResponse<List> response = orderPayService.selectOrderByuserId(userId);
        return response;
    }

    // 获取需要发送的url地址
    private static final String TRANSFERS_PAY = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
    // 企业付款查询
    private static final String TRANSFERS_PAY_QUERY = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";

    /**
     * 企业转帐个人账户
     *
     * @param request
     * @return
     */
    public TransfersInfo weixinWithdraw(HttpServletRequest request) {
        Map map = new HashMap();
        String desc = "他她派提现" + request.getParameter("amount") + "元";
        try {
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("appid", Configure.getMch_appid());
            parameters.put("mch_id", Configure.getMch_id());
            parameters.put("partner_trade_no", RandomStringGenerator.getRandomStringtime(32));
            parameters.put("nonce_str", RandomStringGenerator.getRandomStringByLength(32));
            parameters.put("openId", request.getParameter("openId"));
            parameters.put("checkName", "NO_CHECK");
            parameters.put("amount", request.getParameter("amount"));
            parameters.put("spbill_create_ip", Configure.getSpbill_create_ip());
            parameters.put("desc", desc);
            //签名
            String sign = Signature.formatUrlMap(parameters, false, false);
            Transfers transfers = new Transfers();
            transfers.setAmount(Integer.parseInt(request.getParameter("amount")));
            transfers.setCheck_name("NO_CHECK");
            transfers.setDesc(desc);
            transfers.setMch_appid(Configure.getMch_appid());
            transfers.setMchid(Configure.getMch_id());
            transfers.setNonce_str(parameters.get("nonce_str"));
            transfers.setOpenid(request.getParameter("openId"));
            transfers.setPartner_trade_no(parameters.get("partner_trade_no"));
            transfers.setSign(sign);
            transfers.setSpbill_create_ip(Configure.getSpbill_create_ip());

            String restxml = CertUtil.posts(TRANSFERS_PAY, transfers);
//            String xmlInfo = HttpXmlUtils.transferXml(transfers);
            //xml转换对象
            XStream xStream = new XStream();
            xStream.alias("xml", TransfersInfo.class);

            TransfersInfo trainfo = (TransfersInfo) xStream.fromXML(restxml);
            System.out.println("trainfo+++++++++" + trainfo);
            if ("SUCCESS".equals(trainfo.getResult_code()) && trainfo.getResult_code().equals(trainfo.getReturn_code())) {
                L.info("转账成功:" + trainfo.getErr_code_des());
                return trainfo;
            } else {
                L.info("转账失败" + trainfo.getErr_code_des());
            }
        } catch (Exception e) {
            L.error("企业付款异常" + e.getMessage(), e);
        }
        return null;
    }

    //查询企业付款到个人url
    private static final String GETTRANSFERS_PAY = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";

    public Map getweixinWithdraw() {
        Map map = new HashMap();
        try {
            Map<String, String> params = new HashMap<String, String>();
        } catch (Exception e) {
            e.printStackTrace();
            L.error("企业付款异常" + e.getMessage(), e);
        }

        return null;
    }
}
