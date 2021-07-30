package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

 
//  //Controller Lecture

//    @GetMapping("/")
//    @ResponseBody
//    public String lander() {
//        return "<h1>This is the landing page!</h1>";
//    }
}


