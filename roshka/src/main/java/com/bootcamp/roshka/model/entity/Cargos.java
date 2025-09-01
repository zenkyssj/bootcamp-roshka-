package com.bootcamp.roshka.model.entity;

import jakarta.validation.constraints.NotNull;

public class Cargos {

    @NotNull
    private int id_cargo;

    @NotNull
    private String nombre;

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
