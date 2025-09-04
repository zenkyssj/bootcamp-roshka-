package com.bootcamp.roshka.model.service.login;

import com.bootcamp.roshka.model.repository.UserRepository;
import com.bootcamp.roshka.model.entity.Usuario;
import com.bootcamp.roshka.model.entity.auth.AuthRequest;
import com.bootcamp.roshka.model.entity.auth.AuthResponse;
import com.bootcamp.roshka.tools.Encrypt;
import com.bootcamp.roshka.tools.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService implements ILoginService {
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    @Autowired
    public LoginService(UserRepository userRepository,
                        UserDetailsService userDetailsService,
                        JwtService jwtService){
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse Auth(AuthRequest request) {
        Usuario user = userRepository.findByCorreo(request.getCorreo());

        if (user == null){
            throw new BadCredentialsException("Credenciales invalidas");
        }

        try {
            String hashedPassword = Encrypt.GetBCRYPT(request.getPassword());

            if (!user.getContrasena().equals(request.getPassword())) {
                throw new BadCredentialsException("Credenciales invalidas");
            }

            String token = getToken(user);

            AuthResponse response = new AuthResponse();

            response.setEmail(user.getCorreo());
            response.setToken(token);

            return response;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al procesar: ", e);
        }

    }

    @Override
    public String getToken(Usuario user) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getCorreo());

        return jwtService.generateToken(userDetails);
    }
}
