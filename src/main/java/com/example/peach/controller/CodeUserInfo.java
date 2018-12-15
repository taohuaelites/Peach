package com.example.peach.controller;


import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.User;
import com.example.peach.service.UserService;
import com.example.peach.util.HttpRequest;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/15.
 */
@RestController
public class CodeUserInfo {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/decodeUserInfo", method = RequestMethod.GET)
    public ServiceResponse<Map> decodeUserInfo(String code, @ModelAttribute User user) throws JSONException {

//        Map map = new HashMap();
        //登录凭证不能为空
        if (code == null || code.length() == 0) {
//            map.put("status", 0);
//            map.put("msg", "code 不能为空");
            return ServiceResponse.createByError("code不能为空");
        }

        //小程序唯一标识   (在微信小程序管理后台获取)
        String wxspAppid = "wxd472817c47fa123a";//wxid_9ctl7c98zkc21 wx8fbfb3afbb0cc35a
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "9108525c9fcaa6a42fb79fb8f79270b2";
        //授权（必填）
        String grant_type = "authorization_code";

        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid ////////////////
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.fromObject(sr);
        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        user.setOpenid(openid);


//        //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
//        try {
//            String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
//            if (null != result && result.length() > 0) {
//                map.put("status", 1);
//                map.put("msg", "解密成功");
//
//                JSONObject userInfoJSON = JSONObject.fromObject(result);
//                Map userInfo = new HashMap();
//                userInfo.put("openId", userInfoJSON.get("openId"));
//                userInfo.put("nickName", userInfoJSON.get("nickName"));
//                userInfo.put("gender", userInfoJSON.get("gender"));
//                userInfo.put("city", userInfoJSON.get("city"));
//                userInfo.put("province", userInfoJSON.get("province"));
//                userInfo.put("country", userInfoJSON.get("country"));
//                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
//                userInfo.put("unionId", userInfoJSON.get("unionId"));
//                map.put("userInfo", userInfo);
//                return map;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        map.put("status", 0);
//        map.put("msg", "解密失败");
        ServiceResponse<Map> response = userService.lognUser(user);
        return response;
    }
}