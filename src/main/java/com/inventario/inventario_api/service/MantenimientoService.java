package com.inventario.inventario_api.service;

import com.inventario.inventario_api.exception.ResourceNotFoundException;
import com.inventario.inventario_api.model.Mantenimiento;
import com.inventario.inventario_api.model.enums.TipoMantenimiento;
import com.inventario.inventario_api.repository.MantenimientoRepository;

import java.util.List;

public class MantenimientoService {

    private MantenimientoRepository repository;

    public List<Mantenimiento> obtenerTodos() {
        return repository.findAll();
    }

    public Mantenimiento obtenerPorId(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe mantenimiento"));
    }

    public Mantenimiento guardar(Mantenimiento mantenimiento) {
        return repository.save(mantenimiento);
    }

    public Mantenimiento actualizar(int id, Mantenimiento mantenimiento) {
        Mantenimiento mntm = obtenerPorId(id);
        mntm.setEquipo(mantenimiento.getEquipo());
        mntm.setTipoMantenimiento(mantenimiento.getTipoMantenimiento());
        mntm.setFecha(mantenimiento.getFecha());
        mntm.setDescripcion(mantenimiento.getDescripcion());
        return repository.save(mntm);
    }

    public void eliminar(int id) {
        obtenerPorId(id);
        repository.deleteById(id);
    }

    public List<Mantenimiento> obtenerPorEquipo(int id_equipo) {
        return repository.findByEquipoId(id_equipo);
    }

    public List<Mantenimiento> obtenerPorTipo(TipoMantenimiento tipo) {
        return repository.findByTipo(tipo);
    }
}
