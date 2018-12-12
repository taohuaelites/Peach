package com.example.peach;

<<<<<<< HEAD

=======
import com.example.peach.pojo.Token;
import com.example.peach.service.TokenService;
import com.example.peach.service.UserService;
import com.example.peach.service.impl.TokenServiceImpl;
import com.example.peach.service.impl.UserServiceImpl;
>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("com.example.peach.mapper")
public class PeachoneApplication {


<<<<<<< HEAD
    public static void main(String[] args) {
        SpringApplication.run(PeachoneApplication.class, args);
=======

    public static void main(String[] args) {
        SpringApplication.run(PeachoneApplication.class, args);
        System.out.println("hellow,word");

        };
>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259
    }
