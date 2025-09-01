package com.bootcamp.roshka.model.entity;

import jakarta.validation.constraints.NotNull;

public class Equipos {

    @NotNull
    private int id_equipo;

    @NotNull
    private String nombre;

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
