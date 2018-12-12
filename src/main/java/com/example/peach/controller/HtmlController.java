package com.example.peach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/11/29.
 */
@Controller
@RequestMapping(value = "/htt")
public class HtmlController {

    @RequestMapping(value = "index")
    public String getHtml(){
        return "index";
    }
}
