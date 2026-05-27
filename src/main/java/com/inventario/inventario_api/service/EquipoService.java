package com.inventario.inventario_api.service;

import com.inventario.inventario_api.exception.ResourceNotFoundException;
import com.inventario.inventario_api.model.Equipo;
import com.inventario.inventario_api.model.enums.Estado;
import com.inventario.inventario_api.model.enums.TipoEquipo;
import com.inventario.inventario_api.model.enums.Ubicacion;
import com.inventario.inventario_api.repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {
    private EquipoRepository repository;

    public EquipoService(EquipoRepository repository) {
        this.repository = repository;
    }

    public List<Equipo> obtenerTodos() {
        return repository.findAll();
    }

    public Equipo obtenerPorId(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado"));
    }

    public Equipo guardar(Equipo equipo) {
        return repository.save(equipo);
    }

    public Equipo actualizar(int id, Equipo equipo) {
        Equipo equipoNuevo = obtenerPorId(id);
        equipoNuevo.setTipoEquipo(equipo.getTipoEquipo());
        equipoNuevo.setMarca(equipo.getMarca());
        equipoNuevo.setModelo(equipo.getModelo());
        equipoNuevo.setNumeroSerie(equipo.getNumeroSerie());
        equipoNuevo.setEstado(equipo.getEstado());
        equipoNuevo.setUbicacion(equipo.getUbicacion());
        equipoNuevo.setSoftware(equipo.getSoftware());
        return repository.save(equipo);
    }

    public void eliminar(int id) {
        obtenerPorId(id);
        repository.deleteById(id);
    }

    public List<Equipo> obtenerPorEstado(Estado estado) {
        return repository.findByEstado(estado);
    }

    public List<Equipo> obtenerPorTipo(TipoEquipo tipoEquipo) {
        return repository.findByTipoEquipo(tipoEquipo);
    }

    public List<Equipo> obtenerPorUbicacion(Ubicacion ubicacion) {
        return repository.findByUbicacion(ubicacion);
    }
}