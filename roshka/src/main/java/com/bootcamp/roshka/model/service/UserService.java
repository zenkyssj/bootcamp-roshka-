package com.bootcamp.roshka.model.service;

import com.bootcamp.roshka.model.database.UserRepository;
import com.bootcamp.roshka.model.dto.UserDto;
import com.bootcamp.roshka.model.dto.UserInsertDto;
import com.bootcamp.roshka.model.dto.UserUpdateDto;
import com.bootcamp.roshka.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService<UserDto, UserInsertDto, UserUpdateDto>{

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public List<UserDto> getAllUsers() {
        System.out.println("Desde el userRepository");
        var users = userRepository.findAll();

        return users.stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setId_usuario(user.getId_usuario());
            userDto.setNombre(user.getNombre());
            userDto.setApellido(user.getApellido());
            userDto.setNro_cedula(user.getNro_cedula());
            userDto.setCorreo(user.getCorreo());
            userDto.setId_rol(user.getId_rol());
            userDto.setFecha_ingreso(user.getFecha_ingreso());

            userDto.setAntiguedad(user.getAntiguedad());

            userDto.setDias_vacaciones(user.getDias_vacaciones());
            userDto.setEstado(user.isEstado());
            userDto.setContrasena(user.getContrasena());
            userDto.setTelefono(user.getTelefono());
            userDto.setId_equipo(user.getId_equipo());
            userDto.setId_cargo(user.getId_cargo());
            userDto.setFecha_nacimiento(user.getFecha_nacimiento());
            userDto.setDias_vacaciones_restante(user.getDias_vacaciones_restante());
            userDto.setRequiere_cambio_contrasena(user.isRequiere_cambio_contrasena());

            return userDto;
        }).toList();
    }

    @Override
    public List<UserDto> getAllUsersByRol(int idRol) {
        System.out.println("Desde el userRepository");
        var users = userRepository.findByIdRol(idRol);

        return users.stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setId_usuario(user.getId_usuario());
            userDto.setNombre(user.getNombre());
            userDto.setApellido(user.getApellido());
            userDto.setNro_cedula(user.getNro_cedula());
            userDto.setCorreo(user.getCorreo());
            userDto.setId_rol(user.getId_rol());
            userDto.setFecha_ingreso(user.getFecha_ingreso());

            userDto.setAntiguedad(user.getAntiguedad());

            userDto.setDias_vacaciones(user.getDias_vacaciones());
            userDto.setEstado(user.isEstado());
            userDto.setContrasena(user.getContrasena());
            userDto.setTelefono(user.getTelefono());
            userDto.setId_equipo(user.getId_equipo());
            userDto.setId_cargo(user.getId_cargo());
            userDto.setFecha_nacimiento(user.getFecha_nacimiento());
            userDto.setDias_vacaciones_restante(user.getDias_vacaciones_restante());
            userDto.setRequiere_cambio_contrasena(user.isRequiere_cambio_contrasena());

            return userDto;
        }).toList();
    }

    @Override
    public List<UserDto> getAllUsersByEquipo(int idEquipo) {
        System.out.println("Desde el userRepository");
        var users = userRepository.findByIdEquipo(idEquipo);
        return users.stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setId_usuario(user.getId_usuario());
            userDto.setNombre(user.getNombre());
            userDto.setApellido(user.getApellido());
            userDto.setNro_cedula(user.getNro_cedula());
            userDto.setCorreo(user.getCorreo());
            userDto.setId_rol(user.getId_rol());
            userDto.setFecha_ingreso(user.getFecha_ingreso());

            userDto.setAntiguedad(user.getAntiguedad());

            userDto.setDias_vacaciones(user.getDias_vacaciones());
            userDto.setEstado(user.isEstado());
            userDto.setContrasena(user.getContrasena());
            userDto.setTelefono(user.getTelefono());
            userDto.setId_equipo(user.getId_equipo());
            userDto.setId_cargo(user.getId_cargo());
            userDto.setFecha_nacimiento(user.getFecha_nacimiento());
            userDto.setDias_vacaciones_restante(user.getDias_vacaciones_restante());
            userDto.setRequiere_cambio_contrasena(user.isRequiere_cambio_contrasena());

            return userDto;
        }).toList();

    }

    @Override
    public List<UserDto> getAllUsersByCargo(int idCargo) {
        System.out.println("Desde el userRepository");
        var users = userRepository.findByIdCargo(idCargo);

        return users.stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setId_usuario(user.getId_usuario());
            userDto.setNombre(user.getNombre());
            userDto.setApellido(user.getApellido());
            userDto.setNro_cedula(user.getNro_cedula());
            userDto.setCorreo(user.getCorreo());
            userDto.setId_rol(user.getId_rol());
            userDto.setFecha_ingreso(user.getFecha_ingreso());

            userDto.setAntiguedad(user.getAntiguedad());

            userDto.setDias_vacaciones(user.getDias_vacaciones());
            userDto.setEstado(user.isEstado());
            userDto.setContrasena(user.getContrasena());
            userDto.setTelefono(user.getTelefono());
            userDto.setId_equipo(user.getId_equipo());
            userDto.setId_cargo(user.getId_cargo());
            userDto.setFecha_nacimiento(user.getFecha_nacimiento());
            userDto.setDias_vacaciones_restante(user.getDias_vacaciones_restante());
            userDto.setRequiere_cambio_contrasena(user.isRequiere_cambio_contrasena());

            return userDto;
        }).toList();
    }

    @Override
    public List<UserDto> getAllUsersByRolAndEquipo(int idRol, int idEquipo) {
        System.out.println("Desde el userRepository");
        var users = userRepository.findByIdRolAndIdEquipo(idRol, idEquipo);

        return users.stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setId_usuario(user.getId_usuario());
            userDto.setNombre(user.getNombre());
            userDto.setApellido(user.getApellido());
            userDto.setNro_cedula(user.getNro_cedula());
            userDto.setCorreo(user.getCorreo());
            userDto.setId_rol(user.getId_rol());
            userDto.setFecha_ingreso(user.getFecha_ingreso());

            userDto.setAntiguedad(user.getAntiguedad());

            userDto.setDias_vacaciones(user.getDias_vacaciones());
            userDto.setEstado(user.isEstado());
            userDto.setContrasena(user.getContrasena());
            userDto.setTelefono(user.getTelefono());
            userDto.setId_equipo(user.getId_equipo());
            userDto.setId_cargo(user.getId_cargo());
            userDto.setFecha_nacimiento(user.getFecha_nacimiento());
            userDto.setDias_vacaciones_restante(user.getDias_vacaciones_restante());
            userDto.setRequiere_cambio_contrasena(user.isRequiere_cambio_contrasena());

            return userDto;
        }).toList();
    }

    @Override
    public List<UserDto> getAllUsersByRolAndCargo(int idRol, int idCargo) {
        System.out.println("Desde el userRepository");
        var users = userRepository.findByIdRolAndIdCargo(idRol, idCargo);

        return users.stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setId_usuario(user.getId_usuario());
            userDto.setNombre(user.getNombre());
            userDto.setApellido(user.getApellido());
            userDto.setNro_cedula(user.getNro_cedula());
            userDto.setCorreo(user.getCorreo());
            userDto.setId_rol(user.getId_rol());
            userDto.setFecha_ingreso(user.getFecha_ingreso());

            userDto.setAntiguedad(user.getAntiguedad());

            userDto.setDias_vacaciones(user.getDias_vacaciones());
            userDto.setEstado(user.isEstado());
            userDto.setContrasena(user.getContrasena());
            userDto.setTelefono(user.getTelefono());
            userDto.setId_equipo(user.getId_equipo());
            userDto.setId_cargo(user.getId_cargo());
            userDto.setFecha_nacimiento(user.getFecha_nacimiento());
            userDto.setDias_vacaciones_restante(user.getDias_vacaciones_restante());
            userDto.setRequiere_cambio_contrasena(user.isRequiere_cambio_contrasena());

            return userDto;
        }).toList();
    }

    @Override
    public List<UserDto> getAllUsersByEquipoAndCargo(int idEquipo, int idCargo) {
        System.out.println("Desde el userRepository");
        var users = userRepository.findByIdEquipoAndIdCargo(idEquipo, idCargo);

        return users.stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setId_usuario(user.getId_usuario());
            userDto.setNombre(user.getNombre());
            userDto.setApellido(user.getApellido());
            userDto.setNro_cedula(user.getNro_cedula());
            userDto.setCorreo(user.getCorreo());
            userDto.setId_rol(user.getId_rol());
            userDto.setFecha_ingreso(user.getFecha_ingreso());

            userDto.setAntiguedad(user.getAntiguedad());

            userDto.setDias_vacaciones(user.getDias_vacaciones());
            userDto.setEstado(user.isEstado());
            userDto.setContrasena(user.getContrasena());
            userDto.setTelefono(user.getTelefono());
            userDto.setId_equipo(user.getId_equipo());
            userDto.setId_cargo(user.getId_cargo());
            userDto.setFecha_nacimiento(user.getFecha_nacimiento());
            userDto.setDias_vacaciones_restante(user.getDias_vacaciones_restante());
            userDto.setRequiere_cambio_contrasena(user.isRequiere_cambio_contrasena());

            return userDto;
        }).toList();
    }

    @Override
    public List<UserDto> getAllUsersFiltered(int idRol, int idEquipo, int idCargo) {
        System.out.println("Desde el userRepository");
        var users = userRepository.findByIdRolAndIdEquipoAndIdCargo(idRol, idEquipo, idCargo);

        return users.stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setId_usuario(user.getId_usuario());
            userDto.setNombre(user.getNombre());
            userDto.setApellido(user.getApellido());
            userDto.setNro_cedula(user.getNro_cedula());
            userDto.setCorreo(user.getCorreo());
            userDto.setId_rol(user.getId_rol());
            userDto.setFecha_ingreso(user.getFecha_ingreso());

            userDto.setAntiguedad(user.getAntiguedad());

            userDto.setDias_vacaciones(user.getDias_vacaciones());
            userDto.setEstado(user.isEstado());
            userDto.setContrasena(user.getContrasena());
            userDto.setTelefono(user.getTelefono());
            userDto.setId_equipo(user.getId_equipo());
            userDto.setId_cargo(user.getId_cargo());
            userDto.setFecha_nacimiento(user.getFecha_nacimiento());
            userDto.setDias_vacaciones_restante(user.getDias_vacaciones_restante());
            userDto.setRequiere_cambio_contrasena(user.isRequiere_cambio_contrasena());

            return userDto;
        }).toList();
    }

    @Override
    public UserDto getById(int id) {
        System.out.println("Desde el userRepository");
        Optional<Usuario> user = userRepository.findById(id);

        if (user.isEmpty()){
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setId_usuario(user.get().getId_usuario());
        userDto.setNombre(user.get().getNombre());
        userDto.setApellido(user.get().getApellido());
        userDto.setNro_cedula(user.get().getNro_cedula());
        userDto.setCorreo(user.get().getCorreo());
        userDto.setId_rol(user.get().getId_rol());
        userDto.setFecha_ingreso(user.get().getFecha_ingreso());

        userDto.setAntiguedad(user.get().getAntiguedad());

        userDto.setDias_vacaciones(user.get().getDias_vacaciones());
        userDto.setEstado(user.get().isEstado());
        userDto.setContrasena(user.get().getContrasena());
        userDto.setTelefono(user.get().getTelefono());
        userDto.setId_equipo(user.get().getId_equipo());
        userDto.setId_cargo(user.get().getId_cargo());
        userDto.setFecha_nacimiento(user.get().getFecha_nacimiento());
        userDto.setDias_vacaciones_restante(user.get().getDias_vacaciones_restante());
        userDto.setRequiere_cambio_contrasena(user.get().isRequiere_cambio_contrasena());

        return userDto;
    }

    @Override
    public UserDto add(UserInsertDto insert) {
        Usuario user = new Usuario();

        user.setNombre(insert.getNombre());
        user.setApellido(insert.getApellido());
        user.setNro_cedula(insert.getNro_cedula());
        user.setCorreo(insert.getCorreo());
        user.setId_rol(insert.getId_rol());
        user.setFecha_ingreso(insert.getFecha_ingreso());
        user.setDias_vacaciones(insert.getDias_vacaciones());
        user.setEstado(insert.isEstado());
        user.setContrasena(insert.getContrasena());
        user.setTelefono(insert.getTelefono());
        user.setId_equipo(insert.getId_equipo());
        user.setId_cargo(insert.getId_cargo());
        user.setFecha_nacimiento(insert.getFecha_nacimiento());
        user.setDias_vacaciones_restante(insert.getDias_vacaciones_restante());
        user.setRequiere_cambio_contrasena(insert.isRequiere_cambio_contrasena());

        userRepository.save(user);

        UserDto userDto = new UserDto();

        userDto.setId_usuario(user.getId_usuario());
        userDto.setNombre(user.getNombre());
        userDto.setApellido(user.getApellido());
        userDto.setNro_cedula(user.getNro_cedula());
        userDto.setCorreo(user.getCorreo());
        userDto.setId_rol(user.getId_rol());
        userDto.setFecha_ingreso(user.getFecha_ingreso());
        userDto.setAntiguedad(user.getAntiguedad());
        userDto.setDias_vacaciones(user.getDias_vacaciones());
        userDto.setEstado(user.isEstado());
        userDto.setContrasena(user.getContrasena());
        userDto.setTelefono(user.getTelefono());
        userDto.setId_equipo(user.getId_equipo());
        userDto.setId_cargo(user.getId_cargo());
        userDto.setFecha_nacimiento(user.getFecha_nacimiento());
        userDto.setDias_vacaciones_restante(user.getDias_vacaciones_restante());
        userDto.setRequiere_cambio_contrasena(user.isRequiere_cambio_contrasena());

        return userDto;
    }

    @Override
    public UserDto update(UserUpdateDto update, int id) {
        Optional<Usuario> user = userRepository.findById(id);

        if (user.isEmpty()){
            return null;
        }


        user.get().setNombre(update.getNombre());
        user.get().setApellido(update.getApellido());
        user.get().setNro_cedula(update.getNro_cedula());
        user.get().setCorreo(update.getCorreo());
        user.get().setId_rol(update.getId_rol());
        user.get().setFecha_ingreso(update.getFecha_ingreso());
        user.get().setDias_vacaciones(update.getDias_vacaciones());
        user.get().setEstado(update.isEstado());
        user.get().setContrasena(update.getContrasena());
        user.get().setTelefono(update.getTelefono());
        user.get().setId_equipo(update.getId_equipo());
        user.get().setId_cargo(update.getId_cargo());
        user.get().setFecha_nacimiento(update.getFecha_nacimiento());
        user.get().setDias_vacaciones_restante(update.getDias_vacaciones_restante());
        user.get().setRequiere_cambio_contrasena(update.isRequiere_cambio_contrasena());

        userRepository.save(user.get());

        UserDto userDto = new UserDto();

        userDto.setId_usuario(user.get().getId_usuario());
        userDto.setNombre(user.get().getNombre());
        userDto.setApellido(user.get().getApellido());
        userDto.setNro_cedula(user.get().getNro_cedula());
        userDto.setCorreo(user.get().getCorreo());
        userDto.setId_rol(user.get().getId_rol());
        userDto.setFecha_ingreso(user.get().getFecha_ingreso());
        userDto.setAntiguedad(user.get().getAntiguedad());
        userDto.setDias_vacaciones(user.get().getDias_vacaciones());
        userDto.setEstado(user.get().isEstado());
        userDto.setContrasena(user.get().getContrasena());
        userDto.setTelefono(user.get().getTelefono());
        userDto.setId_equipo(user.get().getId_equipo());
        userDto.setId_cargo(user.get().getId_cargo());
        userDto.setFecha_nacimiento(user.get().getFecha_nacimiento());
        userDto.setDias_vacaciones_restante(user.get().getDias_vacaciones_restante());
        userDto.setRequiere_cambio_contrasena(user.get().isRequiere_cambio_contrasena());

        return userDto;
    }

    @Override
    public UserDto delete(int id) {
        Optional<Usuario> user = userRepository.findById(id);

        if (user.isEmpty()){
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId_usuario(user.get().getId_usuario());
        userDto.setNombre(user.get().getNombre());
        userDto.setApellido(user.get().getApellido());
        userDto.setNro_cedula(user.get().getNro_cedula());
        userDto.setCorreo(user.get().getCorreo());
        userDto.setId_rol(user.get().getId_rol());
        userDto.setFecha_ingreso(user.get().getFecha_ingreso());
        userDto.setAntiguedad(user.get().getAntiguedad());
        userDto.setDias_vacaciones(user.get().getDias_vacaciones());
        userDto.setEstado(user.get().isEstado());
        userDto.setContrasena(user.get().getContrasena());
        userDto.setTelefono(user.get().getTelefono());
        userDto.setId_equipo(user.get().getId_equipo());
        userDto.setId_cargo(user.get().getId_cargo());
        userDto.setFecha_nacimiento(user.get().getFecha_nacimiento());
        userDto.setDias_vacaciones_restante(user.get().getDias_vacaciones_restante());
        userDto.setRequiere_cambio_contrasena(user.get().isRequiere_cambio_contrasena());

        userRepository.deleteById(id);

        return userDto;

    }
}
