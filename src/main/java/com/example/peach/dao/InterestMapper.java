package com.example.peach.dao;

import com.example.peach.pojo.Interest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/12/4.
 */
@Component
@Mapper
public interface InterestMapper {

    Interest selectById(int id);

    int updateInterest(Interest interest);

    int insertInterest(Interest interest);
}
