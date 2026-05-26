package com.inventario.inventario_api.repository;


import com.inventario.inventario_api.model.Software;
import com.inventario.inventario_api.model.TipoLicencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SoftwareRepository extends JpaRepository<Software, Long> {

    List<Software> findByTipoLicencia(TipoLicencia tipoLicencia);

    List<Software> findByFechaExpiracionBefore(LocalDate fecha);

    // Licencias expiradas
    @Query("SELECT s FROM Software s WHERE s.fechaExpiracion IS NOT NULL AND s.fechaExpiracion < CURRENT_DATE")
    List<Software> findExpiradas();

    // Licencias que expiran en los próximos N días
    @Query("SELECT s FROM Software s WHERE s.fechaExpiracion BETWEEN CURRENT_DATE AND :fechaLimite")
    List<Software> findProximasAExpirar(LocalDate fechaLimite);
}