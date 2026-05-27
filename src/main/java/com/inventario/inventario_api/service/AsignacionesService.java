package com.inventario.inventario_api.service;

import com.inventario.inventario_api.exception.ResourceNotFoundException;
import com.inventario.inventario_api.model.Asignaciones;
import com.inventario.inventario_api.repository.AsignacionesRepository;

import java.util.List;

public class AsignacionesService {

    private AsignacionesRepository repository;

    public AsignacionesService(AsignacionesRepository repository) {
        this.repository = repository;
    }

    public List<Asignaciones> obtenerTodas() {
        return repository.findAll();
    }

    public Asignaciones obtenerPorId(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe asignación la asignacion"));
    }

    public Asignaciones guardar(Asignaciones asignacion) {
        return repository.save(asignacion);
    }

    public void eliminar(int id) {
        obtenerPorId(id);
        repository.deleteById(id);
    }

    public List<Asignaciones> obtenerPorUsuario(int id_usuario) {
        return repository.findByUsuarioId(id_usuario);
    }

    public List<Asignaciones> obtenerPorEquipo(int id_equipo) {
        return repository.findByEquipoId(id_equipo);
    }
}
