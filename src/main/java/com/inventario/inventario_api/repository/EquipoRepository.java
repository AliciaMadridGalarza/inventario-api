package com.inventario.inventario_api.repository;

import com.inventario.inventario_api.model.Equipos;
import com.inventario.inventario_api.model.EstadoEquipo;
import com.inventario.inventario_api.model.TipoEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipoRepository extends JpaRepository<Equipos, Long> {

    List<Equipos> findByEstado(EstadoEquipo estado);

    List<Equipos> findByTipo(TipoEquipo tipo);

    Optional<Equipos> findByNumeroSerie(String numeroSerie);

    List<Equipos> findByUbicacionContainingIgnoreCase(String ubicacion);

    List<Equipos> findByTipoAndEstado(TipoEquipo tipo, EstadoEquipo estado);

    boolean existsByNumeroSerie(String numeroSerie);
}
