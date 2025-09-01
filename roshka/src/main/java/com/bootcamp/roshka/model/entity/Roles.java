package com.bootcamp.roshka.model.entity;

import jakarta.validation.constraints.NotNull;

public class Roles {

    @NotNull
    private int id_rol;

    @NotNull
    private String nombre;

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
