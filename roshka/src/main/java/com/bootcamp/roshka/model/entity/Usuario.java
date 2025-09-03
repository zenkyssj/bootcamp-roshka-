package com.bootcamp.roshka.model.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nro_cedula")
    private int nro_cedula;

    @Column(name = "correo")
    private String correo;

    @Column(name = "id_rol")
    private int idRol;

    @Column(name = "fecha_ingreso")
    private java.sql.Date fecha_ingreso;

    @Column(name = "antiguedad")
    private String antiguedad;

    @Column(name = "dias_vacaciones")
    private int dias_vacaciones;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "id_equipo")
    private int idEquipo;

    @Column(name = "id_cargo")
    private int idCargo;

    @Column(name = "fecha_nacimiento")
    private java.sql.Date fecha_nacimiento;

    @Column(name = "dias_vacaciones_restante")
    private int dias_vacaciones_restante;

    @Column(name = "requiere_cambio_contrasena")
    private boolean requiere_cambio_contrasena;

    public int getId_usuario() {
        return idUsuario;
    }

    public void setId_usuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
        return idRol;
    }

    public void setId_rol(int idRol) {
        this.idRol = idRol;
    }

    public java.sql.Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(java.sql.Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
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
        return idEquipo;
    }

    public void setId_equipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getId_cargo() {
        return idCargo;
    }

    public void setId_cargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public java.sql.Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(java.sql.Date fecha_nacimiento) {
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
