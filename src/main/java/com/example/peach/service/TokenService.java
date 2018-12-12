package com.example.peach.service;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.Token;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2018/11/16.
 */

public interface TokenService {


    //查询
    Token selectById();

    //修改
    int updateById(String access_token);


}
