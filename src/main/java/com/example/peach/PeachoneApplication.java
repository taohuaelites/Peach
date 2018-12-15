package com.example.peach;

import com.example.peach.util.RedisUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@Mapper
public class PeachoneApplication {




    public static void main(String[] args) {
        SpringApplication.run(PeachoneApplication.class, args);
        }
    }
