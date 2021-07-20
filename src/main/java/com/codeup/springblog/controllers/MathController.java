package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    // Addition
    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public String adding(@PathVariable int x, @PathVariable int y) {
        return x + " + " + y + " is " + (x + y);
    }

    // Subtraction
    @GetMapping("/subtract/{x}/from/{y}")
    @ResponseBody
    public String subtracting(@PathVariable int x, @PathVariable int y) {
        return x + " + " + y + " is " + (x - y);
    }

    // Multiplication
    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public String multiply(@PathVariable int x, @PathVariable int y){
        return x + " * " + y + " is " + (x * y);
    }

    // Division
    @GetMapping(path = "/divide/{x}/by/{y}")
    @ResponseBody
    public String divide(@PathVariable int x, @PathVariable int y){
        return x + " * " + y + " is " + (x / y);
    }
}
