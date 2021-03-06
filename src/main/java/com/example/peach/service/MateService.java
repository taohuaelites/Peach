package com.example.peach.service;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.Mate;

/**
 * Created by Administrator on 2018/11/22.
 */
public interface MateService {
    Mate selectByuserId(Integer userId);

    ServiceResponse<String> insertMate(Mate mate);

    ServiceResponse<String> updateMate(Mate mate);

    Mate selectByOpenId(String openid );
}
