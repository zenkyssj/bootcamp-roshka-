package com.bootcamp.roshka.model.service.auth;

import com.bootcamp.roshka.model.dto.UserDto;
import com.bootcamp.roshka.model.dto.UserInsertDto;
import com.bootcamp.roshka.model.entity.Usuario;
import com.bootcamp.roshka.model.repository.UserRepository;
import com.bootcamp.roshka.model.service.user.UserService;
import com.bootcamp.roshka.tools.Encrypt;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class RegisterService implements IRegisterService{
    private final UserRepository userRepository;

    public RegisterService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Boolean registerUser(UserInsertDto insertDto){
        var userWithProvidedEmail = checkIfEmailExists(insertDto.getCorreo());

        if (userWithProvidedEmail != null){
            return false;
        }

        try {
            Usuario user = new Usuario();
            user.setNombre(insertDto.getNombre());
            user.setApellido(insertDto.getApellido());
            user.setNro_cedula(insertDto.getNro_cedula());
            user.setCorreo(insertDto.getCorreo());
            user.setId_rol(insertDto.getId_rol());
            user.setFecha_ingreso(insertDto.getFecha_ingreso());
            user.setDias_vacaciones(insertDto.getDias_vacaciones());
            user.setEstado(insertDto.isEstado());
            user.setContrasena(Encrypt.GetBCRYPT(insertDto.getContrasena()));
            user.setTelefono(insertDto.getTelefono());
            user.setId_equipo(insertDto.getId_equipo());
            user.setId_cargo(insertDto.getId_cargo());
            user.setFecha_nacimiento(insertDto.getFecha_nacimiento());
            user.setDias_vacaciones(insertDto.getDias_vacaciones());
            user.setRequiere_cambio_contrasena(insertDto.isRequiere_cambio_contrasena());

            userRepository.save(user);

            return true;
        } catch (NoSuchAlgorithmException e){
            System.err.println("Error al registrar usuario" + e);
        }

        return false;
    }

    @Override
    public Usuario checkIfEmailExists(String correo) {
        return userRepository.findByCorreo(correo);
    }
}
