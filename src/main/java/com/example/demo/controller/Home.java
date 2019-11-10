package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class Home {

    @GetMapping
    public String getHome() {
        return "index";
    }

    @PostMapping(value = "")
    public String  getTIme(){
        return "index";
    }
}