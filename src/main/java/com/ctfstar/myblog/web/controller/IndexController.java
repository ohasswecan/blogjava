package com.ctfstar.myblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {



    @RequestMapping("/")
    public String Index(){

        return "index";
    }
}