package com.bootcamp.roshka.model.service;

import com.bootcamp.roshka.model.database.IDAOUser;
import com.bootcamp.roshka.model.entity.Usuario;
import com.bootcamp.roshka.model.entity.auth.AuthRequest;
import com.bootcamp.roshka.model.entity.auth.AuthResponse;
import com.bootcamp.roshka.tools.Encrypt;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class LoginService implements ILoginService{
    private final IDAOUser userDao;

    @Autowired
    public LoginService(IDAOUser userDao){
        this.userDao = userDao;
    }

    @Override
    public AuthResponse Auth(AuthRequest request) {
        AuthResponse response = new AuthResponse();

        try {
            String hashedPassword = Encrypt.GetSHA256(request.getPassword());

            Usuario user = new Usuario(); // TODO: Obtener usuario segun email y password hasheado

            if (user == null) return null; // Retorna null si no se encontr ningun usuario

            response.setEmail(user.getCorreo());
            response.setToken(getToken(user));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }



        return response;
    }

    @Override
    public String getToken(Usuario user) {
        return "";
    }
}
