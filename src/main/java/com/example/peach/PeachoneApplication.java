package com.example.peach;

import com.example.peach.pojo.Token;
import com.example.peach.service.TokenService;
import com.example.peach.service.UserService;
import com.example.peach.service.impl.TokenServiceImpl;
import com.example.peach.service.impl.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("com.example.peach.mapper")
public class PeachoneApplication {



    public static void main(String[] args) {
        SpringApplication.run(PeachoneApplication.class, args);
        System.out.println("hellow,word");

        };
    }
