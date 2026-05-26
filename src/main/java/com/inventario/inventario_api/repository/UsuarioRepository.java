package com.inventario.inventario_api.repository;

import com.inventario.inventario_api.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

    Optional<Usuarios> findByEmail(String email);

    List<Usuarios> findByDepartamento(String departamento);

    List<Usuarios> findByActivo(Boolean activo);

    boolean existsByEmail(String email);
}