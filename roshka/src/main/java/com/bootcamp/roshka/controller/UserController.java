package com.bootcamp.roshka.controller;

import com.bootcamp.roshka.model.dto.UserDto;
import com.bootcamp.roshka.model.dto.UserInsertDto;
import com.bootcamp.roshka.model.dto.UserUpdateDto;
import com.bootcamp.roshka.model.service.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UserController {
    private final IUserService<UserDto, UserInsertDto, UserUpdateDto> userService;

    public UserController(IUserService<UserDto, UserInsertDto, UserUpdateDto> userService) {
        this.userService = userService;
    }



    @GetMapping("/listar")
    public String getAll(
            @RequestParam(value = "rol", required = false) Integer idRol,
            @RequestParam(value = "equipo", required = false) Integer idEquipo,
            @RequestParam(value = "cargo", required = false) Integer idCargo,
            Model model) {

        List<UserDto> users;

        if (idRol != null && idEquipo != null && idCargo != null) {
            users = userService.getAllUsersFiltered(idRol, idEquipo, idCargo);
        } else if (idRol != null && idEquipo != null) {
            users = userService.getAllUsersByRolAndEquipo(idRol, idEquipo);
        } else if (idRol != null && idCargo != null) {
            users = userService.getAllUsersByRolAndCargo(idRol, idCargo);
        } else if (idEquipo != null && idCargo != null) {
            users = userService.getAllUsersByEquipoAndCargo(idEquipo, idCargo);
        } else if (idRol != null) {
            users = userService.getAllUsersByRol(idRol);
        } else if (idEquipo != null) {
            users = userService.getAllUsersByEquipo(idEquipo);
        } else if (idCargo != null) {
            users = userService.getAllUsersByCargo(idCargo);
        } else {
            users = userService.getAllUsers();
        }

        model.addAttribute("usuarios", users);
        return "usuarios/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("usuario", new UserInsertDto());
        return "usuarios/formulario";
    }


    @PostMapping("/nuevo")
    public String addUser(@Valid @ModelAttribute("usuario") UserInsertDto usuario,
                          BindingResult result) {
        if (result.hasErrors()) {
            return "usuarios/formulario";
        }

        userService.add(usuario);
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/{id}")
    public String verDetalle(@PathVariable int id, Model model) {
        var usuario = userService.getById(id);
        if (usuario == null) {
            return "redirect:/usuarios/listar";
        }

        model.addAttribute("usuario", usuario);
        return "usuarios/detalle";
    }

    @GetMapping("/{id}/editar")
    public String showEditForm(@PathVariable int id, Model model) {
        var usuarioDto = userService.getById(id);
        if (usuarioDto == null) {
            return "redirect:/usuarios/listar";
        }

        UserUpdateDto usuarioUpdate = new UserUpdateDto();
        usuarioUpdate.setNombre(usuarioDto.getNombre());
        usuarioUpdate.setApellido(usuarioDto.getApellido());
        usuarioUpdate.setNro_cedula(usuarioDto.getNro_cedula());
        usuarioUpdate.setCorreo(usuarioDto.getCorreo());
        usuarioUpdate.setId_rol(usuarioDto.getId_rol());
        usuarioUpdate.setFecha_ingreso(usuarioDto.getFecha_ingreso());
        usuarioUpdate.setDias_vacaciones(usuarioDto.getDias_vacaciones());
        usuarioUpdate.setEstado(usuarioDto.isEstado());
        usuarioUpdate.setContrasena(usuarioDto.getContrasena());
        usuarioUpdate.setTelefono(usuarioDto.getTelefono());
        usuarioUpdate.setId_equipo(usuarioDto.getId_equipo());
        usuarioUpdate.setId_cargo(usuarioDto.getId_cargo());
        usuarioUpdate.setFecha_nacimiento(usuarioDto.getFecha_nacimiento());
        usuarioUpdate.setDias_vacaciones_restante(usuarioDto.getDias_vacaciones_restante());
        usuarioUpdate.setRequiere_cambio_contrasena(usuarioDto.isRequiere_cambio_contrasena());

        model.addAttribute("usuario", usuarioUpdate);
        model.addAttribute("userId", id);
        return "usuarios/editar";
    }

    @PostMapping("/{id}/editar")
    public String actualizarUsuario(@PathVariable int id,
                                    @Valid @ModelAttribute("usuario") UserUpdateDto usuario,
                                    BindingResult result,
                                    Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userId", id);
            return "usuarios/editar";

        }

        userService.update(usuario, id);
        return "redirect:/usuarios/" + id;
    }

    @GetMapping("/{id}/eliminar")
    public String confirmDelete(@PathVariable int id, Model model) {
        var usuario = userService.getById(id);
        if (usuario == null) {
            return "redirect:/usuarios";
        }
        model.addAttribute("usuario", usuario);
        return "usuarios/eliminar";
    }

    @PostMapping("/{id}/eliminar")
    public String deleteUser(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/usuarios/listar";
    }
}
