package com.inventario.inventario_api.repository;

import com.inventario.inventario_api.model.Mantenimiento;
import com.inventario.inventario_api.model.TipoMantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {

    List<Mantenimiento> findByEquipoId(int equipoId);

    List<Mantenimiento> findByTipo(TipoMantenimiento tipo);

    List<Mantenimiento> findByResuelto(Boolean resuelto);

    List<Mantenimiento> findByEquipoIdOrderByFechaDesc(int equipoId);

    List<Mantenimiento> findByResuelteFalse();

    List<Mantenimiento> findByFechaBetween(LocalDate inicio, LocalDate fin);
}