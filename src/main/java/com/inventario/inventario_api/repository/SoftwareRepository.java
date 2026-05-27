package com.inventario.inventario_api.repository;

import com.inventario.inventario_api.model.Software;
import com.inventario.inventario_api.model.enums.Licencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SoftwareRepository extends JpaRepository<Software, Integer> {
    List<Software> findByLicencia(Licencia licencia);
    List<Software> findByFechaExpiracionBefore(LocalDate fecha);
}