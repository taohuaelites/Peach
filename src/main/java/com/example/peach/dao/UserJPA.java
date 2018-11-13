package com.example.peach.dao;

import com.example.peach.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.Optional;

@Repository
public interface UserJPA extends JpaRepository<User,Integer>{

   User findByOpenid(String openid);


   
   @Transactional
   @Modifying
   @Query("update user set user_phone=:userphone where id=:id")
   int setFixedUserphoneFor(@Param("userphone") String user_phone, @Param("id")int id);

}
