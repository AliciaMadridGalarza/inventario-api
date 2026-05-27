package com.inventario.inventario_api.repository;

import com.inventario.inventario_api.model.Equipo;
import com.inventario.inventario_api.model.enums.Estado;
import com.inventario.inventario_api.model.enums.TipoEquipo;
import com.inventario.inventario_api.model.enums.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    List<Equipo> findByEstado(Estado estado);
    List<Equipo> findByTipoEquipo(TipoEquipo tipoEquipo);
    List<Equipo> findByUbicacion(Ubicacion ubicacion);
}