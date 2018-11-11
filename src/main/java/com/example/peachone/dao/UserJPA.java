package com.example.peachone.dao;

import com.example.peachone.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJPA extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

   User findByOpenid(String openid);
}
