package com.example.peach.dao;

import com.example.peach.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface UserJPA extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

   User findByOpenid(String openid);

   @Transactional
   @Modifying
   @Query("update User u set u.nickname=?1 where u.id=?2")
   int updateUsersetNickname(String nickname,int id);
}
