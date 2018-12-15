package com.example.peach.dao;

import com.example.peach.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer id);

    User selectByOpenid(String openid);

    User selectByphone(String phone);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User record);

    List<User> userList();

    Boolean selectBynewolduser(String openid);

    //充值钱包
    int updateUnewoldAndUIntegralByOpenid(User user);

    List<User> selectUserByInterest(String interest);

    int updateUserPhone(User user);

}