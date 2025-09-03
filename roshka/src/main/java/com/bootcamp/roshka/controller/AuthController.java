package com.bootcamp.roshka.controller;


import com.bootcamp.roshka.model.dto.UserInsertDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    public AuthController(){

    }

    @GetMapping("/login")
    public String loginUser(){

        return "logueando...";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @RequestBody UserInsertDto insertDto){

        return "registrando usuario";
    }

}
