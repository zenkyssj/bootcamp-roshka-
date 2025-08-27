package com.bootcamp.roshka.model.service;

import java.util.List;

public interface IUserService <T, TI, TU>{
    List<T> getAllUsers();
    List<T> getAllUsersByRol(int idRol);
    List<T> getAllUsersByEquipo(int idEquipo);
    List<T> getAllUsersByCargo(int idCargo);
    List<T> getAllUsersByRolAndEquipo(int idRol, int idEquipo);
    List<T> getAllUsersByRolAndCargo(int idRol, int idCargo);
    List<T> getAllUsersByEquipoAndCargo(int idEquipo, int idCargo);
    List<T> getAllUsersFiltered(int idRol, int idEquipo, int idCargo);
    T getById(int id);
    T add(TI insert);
    T update(TU update, int id);
    T delete(int id);
}
