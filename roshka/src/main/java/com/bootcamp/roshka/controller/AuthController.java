package com.bootcamp.roshka.controller;


import com.bootcamp.roshka.model.dto.UserInsertDto;
import com.bootcamp.roshka.model.entity.auth.AuthRequest;
import com.bootcamp.roshka.model.entity.auth.AuthResponse;
import com.bootcamp.roshka.model.service.auth.ILoginService;
import com.bootcamp.roshka.model.service.auth.IRegisterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final ILoginService loginService;
    private final IRegisterService registerService;

    public AuthController(ILoginService loginService,
                          IRegisterService registerService){
        this.loginService = loginService;
        this.registerService = registerService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(@RequestBody AuthRequest request){

        var user = loginService.Auth(request);

        if (user == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserInsertDto insertDto) throws NoSuchAlgorithmException {

        Boolean createUser = registerService.registerUser(insertDto);

        return createUser == null ? ResponseEntity.badRequest().body("Error al crear el usuario") : ResponseEntity.ok("Usuario registrado");
    }

}
