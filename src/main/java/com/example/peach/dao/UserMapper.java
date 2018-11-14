package com.example.peach.dao;

import com.example.peach.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface UserMapper  {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer id);
    User selectByOpenid(String openid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}