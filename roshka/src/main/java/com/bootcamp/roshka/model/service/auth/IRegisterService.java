package com.bootcamp.roshka.model.service.auth;

import com.bootcamp.roshka.model.dto.UserDto;
import com.bootcamp.roshka.model.dto.UserInsertDto;
import com.bootcamp.roshka.model.entity.Usuario;
import com.bootcamp.roshka.model.entity.auth.AuthRequest;

import java.security.NoSuchAlgorithmException;

public interface IRegisterService {

    Boolean registerUser(UserInsertDto insertDto) throws NoSuchAlgorithmException;
    Usuario checkIfEmailExists(String correo);
}
