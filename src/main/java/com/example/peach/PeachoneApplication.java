package com.example.peach;

<<<<<<< HEAD
import org.apache.ibatis.annotations.Mapper;
=======
import com.example.peach.pojo.Token;
import com.example.peach.service.TokenService;
import com.example.peach.service.UserService;
import com.example.peach.service.impl.TokenServiceImpl;
import com.example.peach.service.impl.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
@Mapper
public class PeachoneApplication {



    public static void main(String[] args) {
        SpringApplication.run(PeachoneApplication.class, args);
<<<<<<< HEAD
=======
        System.out.println("hellow,word");

        };
>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259
    }
