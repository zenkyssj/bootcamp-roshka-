package com.bootcamp.roshka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/usuarios")
    public String homeUsers1(){
        return "index";
    }

    @GetMapping("/usuarios/")
    public String homeUsers2(){
        return "index";
    }
}
