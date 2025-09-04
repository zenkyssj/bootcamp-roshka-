package com.bootcamp.roshka.model.service.login;

import com.bootcamp.roshka.model.entity.Usuario;
import com.bootcamp.roshka.model.entity.auth.AuthRequest;
import com.bootcamp.roshka.model.entity.auth.AuthResponse;

public interface ILoginService {

    AuthResponse Auth(AuthRequest request);
    String getToken(Usuario user);
}
