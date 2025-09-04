package com.bootcamp.roshka.controller;


import com.bootcamp.roshka.model.service.user.IUserService;
import com.bootcamp.roshka.model.dto.UserDto;
import com.bootcamp.roshka.model.dto.UserInsertDto;
import com.bootcamp.roshka.model.dto.UserUpdateDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private final IUserService<UserDto, UserInsertDto, UserUpdateDto> userService;

    @Autowired
    public UserRestController(IUserService<UserDto, UserInsertDto, UserUpdateDto> userService){
        this.userService = userService;
    }

    @GetMapping
    public RepresentationModel<?> root(){
        RepresentationModel<?> model = new RepresentationModel<>();
        model.add(linkTo(methodOn(UserRestController.class).getAll(null, null, null)).withRel("all-users"));
        model.add(linkTo(methodOn(UserRestController.class).getById(0)).withRel("usuario-por-id"));
        model.add(linkTo(methodOn(UserRestController.class).add(null)).withRel("añadir-usuario"));
        model.add(linkTo(methodOn(UserRestController.class).update(0, null)).withRel("actualizar-usuario"));
        model.add(linkTo(methodOn(UserRestController.class).delete(0)).withRel("eliminar-usuario"));

        return model;
    }


    @GetMapping("/usuarios")
    @PreAuthorize("hasAnyAuthority('ROLE_1', 'ROLE_4')")
    public ResponseEntity<List<UserDto>> getAll(
            @RequestParam(value = "rol", required = false) Integer idRol,
            @RequestParam(value = "equipo", required = false) Integer idEquipo,
            @RequestParam(value = "cargo", required = false) Integer idCargo) {
        List<UserDto> users;


        if (idRol != null && idEquipo != null && idCargo != null) {
            users = userService.getAllUsersFiltered(idRol, idEquipo, idCargo);

        } else if (idRol != null && idEquipo != null ){
            users = userService.getAllUsersByRolAndEquipo(idRol, idEquipo);

        } else if (idRol != null && idCargo != null){
            users = userService.getAllUsersByRolAndCargo(idRol, idCargo);

        } else if (idEquipo != null && idCargo != null){
            users = userService.getAllUsersByEquipoAndCargo(idEquipo, idCargo);

        } else if (idRol != null){
            users = userService.getAllUsersByRol(idRol);

        } else if (idEquipo != null){
            users = userService.getAllUsersByEquipo(idEquipo);

        } else if (idCargo != null){
            users = userService.getAllUsersByCargo(idCargo);

        } else {
            users = userService.getAllUsers();

        }



        List<UserDto> usersList = users.stream().map(user -> {
            user.add(linkTo(methodOn(UserRestController.class).getById(user.getId_usuario())).withSelfRel());
            user.add(linkTo(methodOn(UserRestController.class).update(user.getId_usuario(), null)).withRel("actualizar"));
            user.add(linkTo(methodOn(UserRestController.class).delete(user.getId_usuario())).withRel("eliminar"));
            return user;
        }).toList();

        return ResponseEntity.ok(usersList);
    }

    @GetMapping("/usuarios/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_1', 'ROLE_4')")
    public ResponseEntity<UserDto> getById(@PathVariable int id){
        System.out.println("llamando al servicio..."); // Para debug

        var user = userService.getById(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }

        user.add(linkTo(methodOn(UserRestController.class).getById(id)).withSelfRel());
        user.add(linkTo(methodOn(UserRestController.class).update(id, null)).withRel("actualizar"));
        user.add(linkTo(methodOn(UserRestController.class).delete(id)).withRel("eliminar"));
        user.add(linkTo(methodOn(UserRestController.class).getAll(null, null, null)).withRel("todos-usuarios"));

        return ResponseEntity.ok(user);
    }

    @PostMapping("/usuarios")
    @PreAuthorize("hasAnyAuthority('ROLE_1', 'ROLE_4')")
    public ResponseEntity<UserDto> add(@Valid @RequestBody UserInsertDto insertDto){
        System.out.println("llamando al servicio..."); // Para debug

        var user = userService.add(insertDto);

        user.add(linkTo(methodOn(UserRestController.class).getById(user.getId_usuario())).withSelfRel());
        user.add(linkTo(methodOn(UserRestController.class).update(user.getId_usuario(), null)).withRel("actualizar"));
        user.add(linkTo(methodOn(UserRestController.class).delete(user.getId_usuario())).withRel("eliminar"));
        user.add(linkTo(methodOn(UserRestController.class).getAll(null, null, null)).withRel("todos-usuarios"));
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/usuarios/user/{id}")
                .buildAndExpand(user.getId_usuario())
                .toUri();

        return ResponseEntity.created(location).body(user);

    }

    @PutMapping("usuarios/{id}")
    public ResponseEntity<UserDto> update(@PathVariable int id, @Valid @RequestBody UserUpdateDto updateDto){
        System.out.println("llamando al servicio..."); //Para debug

        var user = userService.update(updateDto, id);

        if (user == null){
            return ResponseEntity.notFound().build();
        }

        user.add(linkTo(methodOn(UserRestController.class).getById(user.getId_usuario())).withSelfRel());
        user.add(linkTo(methodOn(UserRestController.class).update(user.getId_usuario(), null)).withRel("actualizar"));
        user.add(linkTo(methodOn(UserRestController.class).delete(user.getId_usuario())).withRel("eliminar"));
        user.add(linkTo(methodOn(UserRestController.class).getAll(null, null, null)).withRel("todos-usuarios"));

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("usuarios/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_1', 'ROLE_4')")
    public ResponseEntity<UserDto> delete(@PathVariable int id){
        System.out.println("llamando al servicio...");

        var user = userService.delete(id);

        if (user == null){
            return ResponseEntity.notFound().build();
        }

        user.add(linkTo(methodOn(UserRestController.class).getAll(null, null, null)).withRel("todos-usuarios"));

        return ResponseEntity.ok(user);
    }

}
