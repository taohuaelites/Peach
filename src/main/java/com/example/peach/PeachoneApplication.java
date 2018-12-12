package com.example.peach;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@MapperScan("com.example.peach.mapper")
public class PeachoneApplication {


    public static void main(String[] args) {
        SpringApplication.run(PeachoneApplication.class, args);
    }
}
