package com.inventario.inventario_api.repository;

import com.inventario.inventario_api.model.Asignaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionesRepository extends JpaRepository<Asignaciones, Integer> {
    List<Asignaciones> findByUsuarioId(Integer idUsuario);
    List<Asignaciones> findByEquipoId(Integer idEquipo);
}