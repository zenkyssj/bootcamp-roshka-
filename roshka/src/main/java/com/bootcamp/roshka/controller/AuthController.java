package com.bootcamp.roshka.controller;


import com.bootcamp.roshka.model.dto.UserInsertDto;
import com.bootcamp.roshka.model.entity.auth.AuthRequest;
import com.bootcamp.roshka.model.entity.auth.AuthResponse;
import com.bootcamp.roshka.model.service.login.ILoginService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private ILoginService loginService;

    public AuthController(ILoginService loginService){
        this.loginService = loginService;
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
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserInsertDto insertDto){

        return ResponseEntity.ok("Usuario registrado");
    }

}
