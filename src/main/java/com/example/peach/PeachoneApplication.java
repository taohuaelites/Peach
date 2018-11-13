package com.example.peach;

import com.example.peach.dao.UserJPA;
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
    }
}
