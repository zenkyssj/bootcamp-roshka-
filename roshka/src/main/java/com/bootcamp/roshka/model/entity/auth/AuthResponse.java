package com.bootcamp.roshka.model.entity.auth;

public class AuthResponse {
    private String email;

    private String token;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String toke) {
        this.token = toke;
    }

}
