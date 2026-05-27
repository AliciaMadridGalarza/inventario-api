package com.inventario.inventario_api.repository;

import com.inventario.inventario_api.model.Mantenimiento;
import com.inventario.inventario_api.model.enums.TipoMantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Integer> {
    List<Mantenimiento> findByEquipoId(Integer idEquipo);
    List<Mantenimiento> findByTipo(TipoMantenimiento tipo);
}
