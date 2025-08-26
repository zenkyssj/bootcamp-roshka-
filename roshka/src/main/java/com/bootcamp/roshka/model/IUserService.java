package com.bootcamp.roshka.model;

import java.util.List;

public interface IUserService <T, TI, TU>{
    List<T> getAllUsers();
    T getById(int id);
    T add(TI insert);
    T update(TU update, int id);
    T delete(int id);
}
