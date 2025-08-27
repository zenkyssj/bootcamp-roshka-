package com.bootcamp.roshka.model.service;

import com.bootcamp.roshka.model.entity.Usuario;
import com.bootcamp.roshka.model.database.IDAOUser;
import com.bootcamp.roshka.model.dto.UserDto;
import com.bootcamp.roshka.model.dto.UserInsertDto;
import com.bootcamp.roshka.model.dto.UserUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService<UserDto, UserInsertDto, UserUpdateDto> {
    private final IDAOUser userDao;

    public UserService(IDAOUser userDao ){
        this.userDao = userDao;
    }


    @Override
    public List<UserDto> getAllUsers() {
        System.out.println("Llamando getAllUsers desde Service...");
        var users = userDao.getAllUsers();
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
        System.out.println("Llamando findById desde Service...");
        var user =  userDao.findById(id);

        if (user == null){
            return null;
        }

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

        System.out.println("Llamando add desde Service...");
        userDao.add(user);

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
        System.out.println("Llamando findById desde Service...");
        var user = userDao.findById(id);

        if (user == null){
            return null;
        }

        user.setNombre(update.getNombre());
        user.setApellido(update.getApellido());
        user.setNro_cedula(update.getNro_cedula());
        user.setCorreo(update.getCorreo());
        user.setId_rol(update.getId_rol());
        user.setFecha_ingreso(update.getFecha_ingreso());
        user.setDias_vacaciones(update.getDias_vacaciones());
        user.setEstado(update.isEstado());
        user.setContrasena(update.getContrasena());
        user.setTelefono(update.getTelefono());
        user.setId_equipo(update.getId_equipo());
        user.setId_cargo(update.getId_cargo());
        user.setFecha_nacimiento(update.getFecha_nacimiento());
        user.setDias_vacaciones_restante(update.getDias_vacaciones_restante());
        user.setRequiere_cambio_contrasena(update.isRequiere_cambio_contrasena());

        userDao.update(user, id);

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
    public UserDto delete(int id) {
        var user = userDao.findById(id);

        if (user == null){
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId_equipo(id);
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

        userDao.delete(id);

        return userDto;
    }
}
