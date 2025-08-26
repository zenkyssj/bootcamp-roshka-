package com.bootcamp.roshka.controller;


import com.bootcamp.roshka.model.IUserService;
import com.bootcamp.roshka.model.dto.UserDto;
import com.bootcamp.roshka.model.dto.UserInsertDto;
import com.bootcamp.roshka.model.dto.UserUpdateDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    private final IUserService<UserDto, UserInsertDto, UserUpdateDto> userService;

    public UserController(IUserService<UserDto, UserInsertDto, UserUpdateDto> userService){
        this.userService = userService;
    }

    @GetMapping("users")
    public List<UserDto> getAll (){
        System.out.println("llamando al servicio...");
        return userService.getAllUsers();

    }

    @GetMapping("user/{id}")
    public ResponseEntity getById(@PathVariable int id){
        System.out.println("llamando al servicio..."); // Para debug

        var user = userService.getById(id);
        return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
    }

    @PostMapping("add")
    public ResponseEntity<UserDto> add(@RequestBody UserInsertDto insertDto){
        System.out.println("llamando al servicio..."); // Para debug

        var user = userService.add(insertDto);


        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/usuarios/user/{id}")
                .buildAndExpand(user.getId_usuario())
                .toUri();

        return ResponseEntity.created(location).body(user);

    }

    @PutMapping("update/{id}")
    public ResponseEntity<UserDto> update(@PathVariable int id, @RequestBody UserUpdateDto updateDto){
        System.out.println("llamando al servicio..."); //Para debug

        var user = userService.update(updateDto, id);
        return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<UserDto> delete(@PathVariable int id){
        System.out.println("llamando al servicio...");

        var user = userService.delete(id);
        return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
    }

}
