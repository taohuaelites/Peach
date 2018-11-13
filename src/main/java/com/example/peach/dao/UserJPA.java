package com.example.peach.dao;

import com.example.peach.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
<<<<<<< HEAD
import java.beans.Transient;
import java.util.Optional;
=======

>>>>>>> 3b6aa3d79371f2c648dc57e4fbbfcba963361f62

@Repository
public interface UserJPA extends JpaRepository<User,Integer>{

   User findByOpenid(String openid);

<<<<<<< HEAD

   
   @Transactional
   @Modifying
   @Query("update user set user_phone=:userphone where id=:id")
   int setFixedUserphoneFor(@Param("userphone") String user_phone, @Param("id")int id);

=======
   @Transactional
   @Modifying
   @Query("update User u set u.nickname=?1 where u.id=?2")
   int updateUsersetNickname(String nickname,int id);
>>>>>>> 3b6aa3d79371f2c648dc57e4fbbfcba963361f62
}
