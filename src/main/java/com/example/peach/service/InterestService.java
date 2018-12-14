package com.example.peach.service;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.Interest;

import java.util.List;

/**
 * Created by Administrator on 2018/12/4.
 */
public interface InterestService {

    List<String> selectById(Integer id);

    ServiceResponse updateInterest(Interest interest);

    ServiceResponse insertInterest(Interest interest);

    ServiceResponse selectUserByInterest(int id);
}
