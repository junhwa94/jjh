package com.project.jjh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String Home(){

        System.out.println("============Home 진입================");

        return "home";

    }
}
