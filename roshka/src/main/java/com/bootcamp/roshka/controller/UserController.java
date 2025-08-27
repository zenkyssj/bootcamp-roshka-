package com.bootcamp.roshka.controller;


import com.bootcamp.roshka.model.service.IUserService;
import com.bootcamp.roshka.model.dto.UserDto;
import com.bootcamp.roshka.model.dto.UserInsertDto;
import com.bootcamp.roshka.model.dto.UserUpdateDto;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    private final IUserService<UserDto, UserInsertDto, UserUpdateDto> userService;

    public UserController(IUserService<UserDto, UserInsertDto, UserUpdateDto> userService){
        this.userService = userService;
    }

    @GetMapping
    public RepresentationModel<?> root(){
        RepresentationModel<?> model = new RepresentationModel<>();
        model.add(linkTo(methodOn(UserController.class).getAll()).withRel("all-users"));
        model.add(linkTo(methodOn(UserController.class).getById(0)).withRel("usuario-por-id"));
        model.add(linkTo(methodOn(UserController.class).add(null)).withRel("añadir-usuario"));
        model.add(linkTo(methodOn(UserController.class).update(0, null)).withRel("actualizar-usuario"));
        model.add(linkTo(methodOn(UserController.class).delete(0)).withRel("eliminar-usuario"));

        return model;
    }

    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getAll() {
        var users = userService.getAllUsers();

        List<UserDto> list = users.stream().map(user -> {
            user.add(linkTo(methodOn(UserController.class).getById(user.getId_usuario())).withSelfRel());
            user.add(linkTo(methodOn(UserController.class).update(user.getId_usuario(), null)).withRel("actualizar"));
            user.add(linkTo(methodOn(UserController.class).delete(user.getId_usuario())).withRel("eliminar"));
            return user;
        }).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id){
        System.out.println("llamando al servicio..."); // Para debug

        var user = userService.getById(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }

        user.add(linkTo(methodOn(UserController.class).getById(id)).withSelfRel());
        user.add(linkTo(methodOn(UserController.class).update(id, null)).withRel("actualizar"));
        user.add(linkTo(methodOn(UserController.class).delete(id)).withRel("eliminar"));
        user.add(linkTo(methodOn(UserController.class).getAll()).withRel("todos-usuarios"));

        return ResponseEntity.ok(user);
    }

    @PostMapping("add")
    public ResponseEntity<UserDto> add(@RequestBody UserInsertDto insertDto){
        System.out.println("llamando al servicio..."); // Para debug

        var user = userService.add(insertDto);

        user.add(linkTo(methodOn(UserController.class).getById(user.getId_usuario())).withSelfRel());
        user.add(linkTo(methodOn(UserController.class).update(user.getId_usuario(), null)).withRel("actualizar"));
        user.add(linkTo(methodOn(UserController.class).delete(user.getId_usuario())).withRel("eliminar"));
        user.add(linkTo(methodOn(UserController.class).getAll()).withRel("todos-usuarios"));
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

        if (user == null){
            return ResponseEntity.notFound().build();
        }

        user.add(linkTo(methodOn(UserController.class).getById(user.getId_usuario())).withSelfRel());
        user.add(linkTo(methodOn(UserController.class).update(user.getId_usuario(), null)).withRel("actualizar"));
        user.add(linkTo(methodOn(UserController.class).delete(user.getId_usuario())).withRel("eliminar"));
        user.add(linkTo(methodOn(UserController.class).getAll()).withRel("todos-usuarios"));

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<UserDto> delete(@PathVariable int id){
        System.out.println("llamando al servicio...");

        var user = userService.delete(id);

        if (user == null){
            return ResponseEntity.notFound().build();
        }

        user.add(linkTo(methodOn(UserController.class).getAll()).withRel("todos-usuarios"));

        return ResponseEntity.ok(user);
    }

}
