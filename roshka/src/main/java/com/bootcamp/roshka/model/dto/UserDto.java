package com.bootcamp.roshka.model.dto;

import org.springframework.hateoas.RepresentationModel;

import java.time.Period;
import java.sql.Date;

public class UserDto extends RepresentationModel<UserDto> {

    private int id_usuario;
    private String nombre;
    private String apellido;
    private int nro_cedula;
    private String correo;
    private int id_rol;
    private Date fecha_ingreso;
    private String antiguedad;
    private int dias_vacaciones;
    private boolean estado;
    private String contrasena;
    private String telefono;
    private int id_equipo;
    private int id_cargo;
    private Date fecha_nacimiento;
    private int dias_vacaciones_restante;
    private boolean requiere_cambio_contrasena;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNro_cedula() {
        return nro_cedula;
    }

    public void setNro_cedula(int nro_cedula) {
        this.nro_cedula = nro_cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String interval) {
        this.antiguedad = interval;
    }

    public int getDias_vacaciones() {
        return dias_vacaciones;
    }

    public void setDias_vacaciones(int dias_vacaciones) {
        this.dias_vacaciones = dias_vacaciones;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getDias_vacaciones_restante() {
        return dias_vacaciones_restante;
    }

    public void setDias_vacaciones_restante(int dias_vacaciones_restante) {
        this.dias_vacaciones_restante = dias_vacaciones_restante;
    }

    public boolean isRequiere_cambio_contrasena() {
        return requiere_cambio_contrasena;
    }

    public void setRequiere_cambio_contrasena(boolean requiere_cambio_contrasena) {
        this.requiere_cambio_contrasena = requiere_cambio_contrasena;
    }


}
