package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    public HelloController() {

    }

    @GetMapping("/hello") //browser url
    @ResponseBody           // results
    public String hello(){
        return "<h1>Hello from Spring!</h1>";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "<h1>Hello " + name + "!</h1>";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        emailSvc.prepareAndSend("test@test.com", "Hello! Welcome to " + "!", "Thank you for attending our Web Development Program!");
        return "join";
    }

    @GetMapping("/number/{num}")
    @ResponseBody
    public int displayNumber(@PathVariable int num){
        return num;
    }

    @RequestMapping(path="/hello/in/{color}", method = RequestMethod.GET)
    @ResponseBody
    public String helloInColor(@PathVariable String color) {
        return "<h1 style=\"color: " + color + "\">Hello in " + color + "!</h1>";
    }
}
