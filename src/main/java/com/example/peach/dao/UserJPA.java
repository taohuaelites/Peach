package com.example.peach.dao;

import com.example.peach.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJPA extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

   User findByOpenid(String openid);
}
