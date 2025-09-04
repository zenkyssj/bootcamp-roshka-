package com.bootcamp.roshka.tools.jwt;

import com.bootcamp.roshka.tools.Encrypt;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.security.NoSuchAlgorithmException;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(JwtAuthFilter jwtAuthFilter,
                          UserDetailsService userDetailsService) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll()

                        .requestMatchers(HttpMethod.POST, "/api/usuarios").hasAnyAuthority("ROLE_1", "ROLE_4")
                        .requestMatchers(HttpMethod.GET, "/api/usuarios").hasAnyAuthority("ROLE_1", "ROLE_4")
                        .requestMatchers(HttpMethod.GET, "/api/usuarios/**").hasAnyAuthority("ROLE_1", "ROLE_4")
                        .requestMatchers(HttpMethod.PUT, "/api/usuarios/**").hasAnyAuthority("ROLE_1", "ROLE_4")
                        .requestMatchers(HttpMethod.DELETE, "/api/usuarios/**").hasAnyAuthority("ROLE_1", "ROLE_4")

                        .anyRequest().authenticated()

                )
                .sessionManagement(sess ->
                        sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint((request, response, authException) -> {
                            System.err.println("=== ERROR DE AUTENTICACIÓN ===");
                            System.err.println("URI: " + request.getRequestURI());
                            System.err.println("Método: " + request.getMethod());
                            System.err.println("Mensaje: " + authException.getMessage());
                            System.err.println("Autenticación: " + SecurityContextHolder.getContext().getAuthentication());

                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            response.setContentType("application/json;charset=UTF-8");
                            response.getWriter().write("{\"error\":\"Error de autenticación\", \"mensaje\":\""
                                    + authException.getMessage() + "\"}");
                        })
                )
                .build();


    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String username = authentication.getName();
                String password = String.valueOf(authentication.getCredentials());

                try{
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);


                    if (passwordEconder().matches(password, username)){
                        return new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );
                    } else{
                        throw new BadCredentialsException("Credenciales invalidas");
                    }
                } catch (UsernameNotFoundException e){
                    throw new BadCredentialsException("Usuario no encontrado");
                }
            }

            @Override
            public boolean supports(Class<?> authentication) {
                return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEconder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                try {
                    return Encrypt.GetBCRYPT(rawPassword.toString());
                } catch (NoSuchAlgorithmException e){
                    throw new RuntimeException("Error al crear el token");
                }
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                try {
                    String hashedRawPassword = Encrypt.GetBCRYPT(rawPassword.toString());
                    return hashedRawPassword.equals(encodedPassword);
                } catch (NoSuchAlgorithmException e){
                    return false;
                }
            }
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}