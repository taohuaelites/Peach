package com.example.peach.dao;

import com.example.peach.pojo.UserVip;
import com.example.peach.pojo.merge.UvipUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Mapper
@Repository
public interface UserVipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserVip record);
    //插入会员信息
    int insertSelective(UserVip record);

    UserVip selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserVip record);

    int updateByPrimaryKey(UserVip record);
    //根据userid查询用户会员信息
    UserVip selectByUserId(int userId);
    //修改会员信息
    int updateByUserId(UserVip userVip);
    //相减约见次数
    int updateAppiontmentByUserId(@Param(value = "vipAppointment") Integer vipAppointment, @Param(value = "userId") Integer userid);

    int updateUwalletByUserId(@Param(value = "userWallet") Double money,@Param(value = "userId") Integer userId);
    //查询会员信息,和user   id,openiid
    UvipUser selectUvipUser(Integer userId);
}