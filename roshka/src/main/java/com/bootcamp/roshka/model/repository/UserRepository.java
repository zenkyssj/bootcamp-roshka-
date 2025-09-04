package com.bootcamp.roshka.model.repository;

import com.bootcamp.roshka.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByIdRol(int idRol);
    List<Usuario> findByIdEquipo(int idEquipo);
    List<Usuario> findByIdCargo(int idCargo);
    List<Usuario> findByIdRolAndIdEquipo(int idRol, int idEquipo);
    List<Usuario> findByIdRolAndIdCargo(int idRol, int idCargo);
    List<Usuario> findByIdEquipoAndIdCargo(int idEquipo, int idCargo);

    List<Usuario> findByIdRolAndIdEquipoAndIdCargo(int idRol, int idEquipo, int idCargo);

    Usuario findByCorreo(String correo);
}
