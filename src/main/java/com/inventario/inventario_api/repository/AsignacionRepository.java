package com.inventario.inventario_api.repository;


import com.inventario.inventario_api.model.Asignaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignaciones, Long> {

    List<Asignaciones> findByUsuarioIdAndActivaTrue(Long usuarioId);

    List<Asignaciones> findByEquipoIdAndActivaTrue(Long equipoId);

    Optional<Asignaciones> findFirstByEquipoIdAndActivaTrue(Long equipoId);

    List<Asignaciones> findByActivaTrue();

}
