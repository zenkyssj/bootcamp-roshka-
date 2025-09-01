package com.bootcamp.roshka.model.database;

import com.bootcamp.roshka.model.entity.Usuario;

import java.util.List;

public interface IDAOUser {
    List<Usuario> getAllUsers();
    List<Usuario> getAllUsersByRol(int idRol);
    List<Usuario> getAllUsersByEquipo(int idEquipo);
    List<Usuario> getAllUsersByCargo(int idCargo);
    List<Usuario> getAllUsersByRolAndEquipo(int idRol, int idEquipo);
    List<Usuario> getAllUsersByRolAndCargo(int idRol, int idCargo);
    List<Usuario> getAllUsersByEquipoAndCargo(int idEquipo, int idCargo);
    List<Usuario> getAllUsersFiltered(int idRol, int idEquipo, int idCargo);
    Usuario findById(int id);
    Usuario add(Usuario user);
    Usuario update(Usuario user, int id);
    Usuario delete(int id);
}
