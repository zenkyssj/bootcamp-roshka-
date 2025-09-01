package com.bootcamp.roshka.model.database;

import com.bootcamp.roshka.model.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DAOUser implements IDAOUser {

    @Override
    public List<Usuario> getAllUsers() {
        System.out.println("Dentro de DAOUser getAllUsers");
        try (Connection conn = Conexion.getConnection()) {

            List<Usuario> usuarios = new ArrayList<>();

            String sql = "SELECT * FROM usuarios";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                Usuario user = new Usuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setNro_cedula(rs.getInt("nro_cedula"));
                user.setCorreo(rs.getString("correo"));
                user.setId_rol(rs.getInt("id_rol"));
                user.setFecha_ingreso(rs.getDate("fecha_ingreso"));

                LocalDate fechaIngreso = rs.getDate("fecha_ingreso").toLocalDate();
                Period periodo = Period.between(fechaIngreso, LocalDate.now());
                String antiguedad = periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días";
                user.setAntiguedad(antiguedad);

                user.setDias_vacaciones(rs.getInt("dias_vacaciones"));
                user.setEstado(rs.getBoolean("estado"));
                user.setContrasena(rs.getString("contrasena"));
                user.setTelefono(rs.getString("telefono"));
                user.setId_equipo(rs.getInt("id_equipo"));
                user.setId_cargo(rs.getInt("id_cargo"));
                user.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                user.setDias_vacaciones_restante(rs.getInt("dias_vacaciones_restante"));
                user.setRequiere_cambio_contrasena(rs.getBoolean("requiere_cambio_contrasena"));

                usuarios.add(user);
            }

            return usuarios;
        } catch (SQLException e) {
            return List.of();
        }

    }

    @Override
    public List<Usuario> getAllUsersByRol(int idRol) {
        System.out.println("Dentro de DAOUser getAllUsersByRol");
        try (Connection conn = Conexion.getConnection()){
            List<Usuario> usuarios = new ArrayList<>();

            String sql = "SELECT * FROM usuarios WHERE id_rol = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idRol);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Usuario user = new Usuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setNro_cedula(rs.getInt("nro_cedula"));
                user.setCorreo(rs.getString("correo"));
                user.setId_rol(rs.getInt("id_rol"));
                user.setFecha_ingreso(rs.getDate("fecha_ingreso"));

                LocalDate fechaIngreso = rs.getDate("fecha_ingreso").toLocalDate();
                Period periodo = Period.between(fechaIngreso, LocalDate.now());
                String antiguedad = periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días";
                user.setAntiguedad(antiguedad);

                user.setDias_vacaciones(rs.getInt("dias_vacaciones"));
                user.setEstado(rs.getBoolean("estado"));
                user.setContrasena(rs.getString("contrasena"));
                user.setTelefono(rs.getString("telefono"));
                user.setId_equipo(rs.getInt("id_equipo"));
                user.setId_cargo(rs.getInt("id_cargo"));
                user.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                user.setDias_vacaciones_restante(rs.getInt("dias_vacaciones_restante"));
                user.setRequiere_cambio_contrasena(rs.getBoolean("requiere_cambio_contrasena"));

                usuarios.add(user);
            }

            return usuarios;
        } catch (SQLException e){
            e.printStackTrace();
            return List.of();
        }

    }

    @Override
    public List<Usuario> getAllUsersByEquipo(int idEquipo) {
        System.out.println("Dentro de DAOUser getAllUsersByEquipo");
        try (Connection conn = Conexion.getConnection()){
            List<Usuario> usuarios = new ArrayList<>();

            String sql = "SELECT * FROM usuarios WHERE id_equipo = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idEquipo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Usuario user = new Usuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setNro_cedula(rs.getInt("nro_cedula"));
                user.setCorreo(rs.getString("correo"));
                user.setId_rol(rs.getInt("id_rol"));
                user.setFecha_ingreso(rs.getDate("fecha_ingreso"));

                LocalDate fechaIngreso = rs.getDate("fecha_ingreso").toLocalDate();
                Period periodo = Period.between(fechaIngreso, LocalDate.now());
                String antiguedad = periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días";
                user.setAntiguedad(antiguedad);

                user.setDias_vacaciones(rs.getInt("dias_vacaciones"));
                user.setEstado(rs.getBoolean("estado"));
                user.setContrasena(rs.getString("contrasena"));
                user.setTelefono(rs.getString("telefono"));
                user.setId_equipo(rs.getInt("id_equipo"));
                user.setId_cargo(rs.getInt("id_cargo"));
                user.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                user.setDias_vacaciones_restante(rs.getInt("dias_vacaciones_restante"));
                user.setRequiere_cambio_contrasena(rs.getBoolean("requiere_cambio_contrasena"));

                usuarios.add(user);
            }

            return usuarios;

        } catch (SQLException e){
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<Usuario> getAllUsersByCargo(int idCargo) {
        System.out.println("Dentro de DAOUser getAllUsersByCargo");
        try (Connection conn = Conexion.getConnection()){
            List<Usuario> usuarios = new ArrayList<>();

            String sql = "SELECT * FROM usuarios WHERE id_cargo = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idCargo);

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                Usuario user = new Usuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setNro_cedula(rs.getInt("nro_cedula"));
                user.setCorreo(rs.getString("correo"));
                user.setId_rol(rs.getInt("id_rol"));
                user.setFecha_ingreso(rs.getDate("fecha_ingreso"));

                LocalDate fechaIngreso = rs.getDate("fecha_ingreso").toLocalDate();
                Period periodo = Period.between(fechaIngreso, LocalDate.now());
                String antiguedad = periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días";
                user.setAntiguedad(antiguedad);

                user.setDias_vacaciones(rs.getInt("dias_vacaciones"));
                user.setEstado(rs.getBoolean("estado"));
                user.setContrasena(rs.getString("contrasena"));
                user.setTelefono(rs.getString("telefono"));
                user.setId_equipo(rs.getInt("id_equipo"));
                user.setId_cargo(rs.getInt("id_cargo"));
                user.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                user.setDias_vacaciones_restante(rs.getInt("dias_vacaciones_restante"));
                user.setRequiere_cambio_contrasena(rs.getBoolean("requiere_cambio_contrasena"));

                usuarios.add(user);

            }

            return usuarios;

        } catch (SQLException e){
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<Usuario> getAllUsersByRolAndEquipo(int idRol, int idEquipo) {
        System.out.println("Dentro de DAOUser getAllUsersByRolAndEquipo");
        try (Connection conn = Conexion.getConnection()){
            List<Usuario> usuarios = new ArrayList<>();

            String sql = "SELECT * FROM usuarios WHERE id_rol = ? AND id_equipo = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idRol);
            ps.setInt(2, idEquipo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Usuario user = new Usuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setNro_cedula(rs.getInt("nro_cedula"));
                user.setCorreo(rs.getString("correo"));
                user.setId_rol(rs.getInt("id_rol"));
                user.setFecha_ingreso(rs.getDate("fecha_ingreso"));

                LocalDate fechaIngreso = rs.getDate("fecha_ingreso").toLocalDate();
                Period periodo = Period.between(fechaIngreso, LocalDate.now());
                String antiguedad = periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días";
                user.setAntiguedad(antiguedad);

                user.setDias_vacaciones(rs.getInt("dias_vacaciones"));
                user.setEstado(rs.getBoolean("estado"));
                user.setContrasena(rs.getString("contrasena"));
                user.setTelefono(rs.getString("telefono"));
                user.setId_equipo(rs.getInt("id_equipo"));
                user.setId_cargo(rs.getInt("id_cargo"));
                user.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                user.setDias_vacaciones_restante(rs.getInt("dias_vacaciones_restante"));
                user.setRequiere_cambio_contrasena(rs.getBoolean("requiere_cambio_contrasena"));

                usuarios.add(user);

            }

            return usuarios;

        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<Usuario> getAllUsersByRolAndCargo(int idRol, int idCargo) {
        System.out.println("Dentro de DAOUser getAllUsersByRolAndCargo");
        try (Connection conn = Conexion.getConnection()){
            List<Usuario> usuarios = new ArrayList<>();

            String sql = "SELECT * FROM usuarios WHERE id_rol = ? AND id_cargo = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idRol);
            ps.setInt(2, idCargo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Usuario user = new Usuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setNro_cedula(rs.getInt("nro_cedula"));
                user.setCorreo(rs.getString("correo"));
                user.setId_rol(rs.getInt("id_rol"));
                user.setFecha_ingreso(rs.getDate("fecha_ingreso"));

                LocalDate fechaIngreso = rs.getDate("fecha_ingreso").toLocalDate();
                Period periodo = Period.between(fechaIngreso, LocalDate.now());
                String antiguedad = periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días";
                user.setAntiguedad(antiguedad);

                user.setDias_vacaciones(rs.getInt("dias_vacaciones"));
                user.setEstado(rs.getBoolean("estado"));
                user.setContrasena(rs.getString("contrasena"));
                user.setTelefono(rs.getString("telefono"));
                user.setId_equipo(rs.getInt("id_equipo"));
                user.setId_cargo(rs.getInt("id_cargo"));
                user.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                user.setDias_vacaciones_restante(rs.getInt("dias_vacaciones_restante"));
                user.setRequiere_cambio_contrasena(rs.getBoolean("requiere_cambio_contrasena"));

                usuarios.add(user);

            }

            return usuarios;

        } catch (SQLException e){
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<Usuario> getAllUsersByEquipoAndCargo(int idEquipo, int idCargo) {
        System.out.println("Dentro de DAOUser getAllUsersByEquipoAndCargo");
        try (Connection conn = Conexion.getConnection()){
            List<Usuario> usuarios = new ArrayList<>();

            String sql = "SELECT * FROM usuarios WHERE id_equipo = ? AND id_cargo = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idEquipo);
            ps.setInt(2, idCargo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Usuario user = new Usuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setNro_cedula(rs.getInt("nro_cedula"));
                user.setCorreo(rs.getString("correo"));
                user.setId_rol(rs.getInt("id_rol"));
                user.setFecha_ingreso(rs.getDate("fecha_ingreso"));

                LocalDate fechaIngreso = rs.getDate("fecha_ingreso").toLocalDate();
                Period periodo = Period.between(fechaIngreso, LocalDate.now());
                String antiguedad = periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días";
                user.setAntiguedad(antiguedad);

                user.setDias_vacaciones(rs.getInt("dias_vacaciones"));
                user.setEstado(rs.getBoolean("estado"));
                user.setContrasena(rs.getString("contrasena"));
                user.setTelefono(rs.getString("telefono"));
                user.setId_equipo(rs.getInt("id_equipo"));
                user.setId_cargo(rs.getInt("id_cargo"));
                user.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                user.setDias_vacaciones_restante(rs.getInt("dias_vacaciones_restante"));
                user.setRequiere_cambio_contrasena(rs.getBoolean("requiere_cambio_contrasena"));

                usuarios.add(user);

            }

            return usuarios;

        } catch (SQLException e){
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public List<Usuario> getAllUsersFiltered(int idRol, int idEquipo, int idCargo) {
        System.out.println("Dentro de DAOUser getAllUsersFiltered");
        try (Connection conn = Conexion.getConnection()){
            List<Usuario> usuarios = new ArrayList<>();

            String sql = "SELECT * FROM usuarios WHERE id_rol = ? AND id_equipo = ? AND id_cargo = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idRol);
            ps.setInt(2, idEquipo);
            ps.setInt(3, idCargo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Usuario user = new Usuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setNro_cedula(rs.getInt("nro_cedula"));
                user.setCorreo(rs.getString("correo"));
                user.setId_rol(rs.getInt("id_rol"));
                user.setFecha_ingreso(rs.getDate("fecha_ingreso"));

                LocalDate fechaIngreso = rs.getDate("fecha_ingreso").toLocalDate();
                Period periodo = Period.between(fechaIngreso, LocalDate.now());
                String antiguedad = periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días";
                user.setAntiguedad(antiguedad);

                user.setDias_vacaciones(rs.getInt("dias_vacaciones"));
                user.setEstado(rs.getBoolean("estado"));
                user.setContrasena(rs.getString("contrasena"));
                user.setTelefono(rs.getString("telefono"));
                user.setId_equipo(rs.getInt("id_equipo"));
                user.setId_cargo(rs.getInt("id_cargo"));
                user.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                user.setDias_vacaciones_restante(rs.getInt("dias_vacaciones_restante"));
                user.setRequiere_cambio_contrasena(rs.getBoolean("requiere_cambio_contrasena"));

                usuarios.add(user);

            }

            return usuarios;

        } catch (SQLException e){
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public Usuario findById(int id) {
        System.out.println("Dentro de DAOUser findById");
        try (Connection conn = Conexion.getConnection()) {
            String sql = "SELECT id_usuario, nombre, apellido, nro_cedula, correo, id_rol, fecha_ingreso, " +
                    "AGE(NOW(), fecha_ingreso) AS antiguedad, dias_vacaciones, estado, contrasena, " +
                    "telefono, id_equipo, id_cargo, fecha_nacimiento, dias_vacaciones_restante, requiere_cambio_contrasena " +
                    "FROM usuarios WHERE id_usuario = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Usuario user = new Usuario();
                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setNro_cedula(rs.getInt("nro_cedula"));
                user.setCorreo(rs.getString("correo"));
                user.setId_rol(rs.getInt("id_rol"));
                user.setFecha_ingreso(rs.getDate("fecha_ingreso"));

                LocalDate fechaIngreso = rs.getDate("fecha_ingreso").toLocalDate();
                Period periodo = Period.between(fechaIngreso, LocalDate.now());
                String antiguedad = periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días";
                user.setAntiguedad(antiguedad);

                user.setDias_vacaciones(rs.getInt("dias_vacaciones"));
                user.setEstado(rs.getBoolean("estado"));
                user.setContrasena(rs.getString("contrasena"));
                user.setTelefono(rs.getString("telefono"));
                user.setId_equipo(rs.getInt("id_equipo"));
                user.setId_cargo(rs.getInt("id_cargo"));
                user.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                user.setDias_vacaciones_restante(rs.getInt("dias_vacaciones_restante"));
                user.setRequiere_cambio_contrasena(rs.getBoolean("requiere_cambio_contrasena"));

                return user;
            }

        } catch (SQLException e) {
            return null;
        }

        return null;
    }

    @Override
    public Usuario add(Usuario user) {
        System.out.println("Dentro de DAOUser add");
        try (Connection conn = Conexion.getConnection()) {

            String sql = "INSERT INTO usuarios (nombre, apellido, nro_cedula, correo, id_rol, fecha_ingreso, " +
                    "dias_vacaciones, estado, contrasena, telefono, id_equipo, id_cargo, fecha_nacimiento, " +
                    "dias_vacaciones_restante, requiere_cambio_contrasena) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id_usuario, fecha_ingreso, antiguedad, dias_vacaciones, id_cargo, fecha_nacimiento";



            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setInt(3, user.getNro_cedula());
            ps.setString(4, user.getCorreo());
            ps.setInt(5, user.getId_rol());
            ps.setDate(6, user.getFecha_ingreso());
            ps.setInt(7, user.getDias_vacaciones());
            ps.setBoolean(8, user.isEstado());
            ps.setString(9, user.getContrasena());
            ps.setString(10, user.getTelefono());
            ps.setInt(11, user.getId_equipo());
            ps.setInt(12, user.getId_cargo());
            ps.setDate(13, user.getFecha_nacimiento());
            ps.setInt(14, user.getDias_vacaciones_restante());
            ps.setBoolean(15, user.isRequiere_cambio_contrasena());




            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user.setId_usuario(rs.getInt("id_usuario"));

                LocalDate fechaIngreso = rs.getDate("fecha_ingreso").toLocalDate();
                Period periodo = Period.between(fechaIngreso, LocalDate.now());
                String antiguedad = periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días";
                user.setAntiguedad(antiguedad);

                user.setDias_vacaciones(rs.getInt("dias_vacaciones"));
                user.setId_cargo(rs.getInt("id_cargo"));
                user.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));

                System.out.println("Usuario añadido");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return user;
    }

    @Override
    public Usuario update(Usuario user, int id) {
        System.out.println("Dentro de DAOUser update");
        try (Connection conn = Conexion.getConnection()){
            String sql = "UPDATE usuarios SET " +
                    "nombre = ?, " +
                    "apellido = ?, " +
                    "nro_cedula = ?, " +
                    "correo = ?, " +
                    "id_rol = ?, " +
                    "fecha_ingreso = ?, " +
                    "dias_vacaciones = ?, " +
                    "estado = ?, " +
                    "contrasena = ?, " +
                    "telefono = ?, " +
                    "id_equipo = ?, " +
                    "id_cargo = ?, " +
                    "fecha_nacimiento = ?, " +
                    "dias_vacaciones_restante = ?, " +
                    "requiere_cambio_contrasena = ? " +
                    "WHERE id_usuario = ? RETURNING fecha_ingreso, antiguedad, dias_vacaciones, id_cargo, fecha_nacimiento";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setInt(3, user.getNro_cedula());
            ps.setString(4, user.getCorreo());
            ps.setInt(5, user.getId_rol());
            ps.setDate(6, user.getFecha_ingreso());
            ps.setInt(7, user.getDias_vacaciones());
            ps.setBoolean(8, user.isEstado());
            ps.setString(9, user.getContrasena());
            ps.setString(10, user.getTelefono());
            ps.setInt(11, user.getId_equipo());
            ps.setInt(12, user.getId_cargo());
            ps.setDate(13, user.getFecha_nacimiento());
            ps.setInt(14, user.getDias_vacaciones_restante());
            ps.setBoolean(15, user.isRequiere_cambio_contrasena());
            ps.setInt(16, id);

            //int rows = ps.executeUpdate();

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                LocalDate fechaIngreso = rs.getDate("fecha_ingreso").toLocalDate();
                Period periodo = Period.between(fechaIngreso, LocalDate.now());
                String antiguedad = periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días";
                user.setAntiguedad(antiguedad);

                user.setDias_vacaciones(rs.getInt("dias_vacaciones"));
                user.setId_cargo(rs.getInt("id_cargo"));
                user.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
            }
            System.out.println("Usuario actualizado");



        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return user;
    }

    @Override
    public Usuario delete(int id) {
        System.out.println("Dentro de DAOUser delete");
        try (Connection conn = Conexion.getConnection()){
            String sql = "DELETE FROM usuarios WHERE id_usuario = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Usuario eliminado con el id: " + id);

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
