package com.inventario.inventario_api.repository;

import com.inventario.inventario_api.model.Usuario;
import com.inventario.inventario_api.model.enums.Cargo;
import com.inventario.inventario_api.model.enums.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByCargo(Cargo cargo);
    List<Usuario> findByDepartamento(Departamento departamento);
}
