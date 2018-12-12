package com.example.peach.dao;

import com.example.peach.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateByPrimarynickname(@Param("nickname") String nickname, @Param("id") int id);

    User selectByOpenid(String openid);

    Boolean selectBynewolduser(String openid);
    //充值钱包
    int updateUnewoldAndUIntegralByOpenid(User user);

}