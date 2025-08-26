package com.bootcamp.roshka.model.database;

import com.bootcamp.roshka.model.Usuario;
import com.bootcamp.roshka.model.dto.UserDto;
import com.bootcamp.roshka.model.dto.UserInsertDto;
import com.bootcamp.roshka.model.dto.UserUpdateDto;

import java.util.List;

public interface IDAOUser {
    List<Usuario> getAllUsers();
    Usuario findById(int id);
    Usuario add(Usuario user);
    Usuario update(Usuario user, int id);
    Usuario delete(int id);
}
