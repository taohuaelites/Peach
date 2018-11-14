package com.example.peach.dao;

import com.example.peach.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface UserJPA extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

   User findByOpenid(String openid);

//   @Modifying
//   @Query("update user u set u.nickname=?1 where u.id=?2")
//   int updateUsersetNickname(String nickname,Integer id);

   //绑定手机号
   @Modifying
   @Query("update user u set u.user_phone=?1 where u.id=?2")
   int updateUsersetPhone(String user_phone,int id);
}
