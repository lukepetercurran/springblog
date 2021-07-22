package com.codeup.springblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class RollDiceController {
    @GetMapping("/roll-dice")
    public String guess(){
        return guess();
    }
}
