package com.example.peach.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class Test {
    @RequestMapping(value = "/test")
    public String test() {
        return "<span>hellow word</span>";
    }

}
