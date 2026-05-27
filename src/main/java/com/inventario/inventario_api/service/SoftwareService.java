package com.inventario.inventario_api.service;


import com.inventario.inventario_api.exception.ResourceNotFoundException;
import com.inventario.inventario_api.model.Software;
import com.inventario.inventario_api.model.enums.Licencia;
import com.inventario.inventario_api.repository.SoftwareRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class SoftwareService {
    private SoftwareRepository repository;

    public SoftwareService(SoftwareRepository repository) {
        this.repository = repository;
    }

    public List<Software> obtenerTodos(){
        return repository.findAll();
    }

    public Software obtenerPorId(int id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Error con el software o el ID"));
    }

    public Software guardar(Software software){
        return repository.save(software);
    }

    public Software actualizar(int id, Software software){
        Software sft = obtenerPorId(id);
        sft.setNombre(software.getNombre());
        sft.setVersion(software.getVersion());
        sft.setLicencia(software.getLicencia());
        sft.setFechaExpiracion(software.getFechaExpiracion());
        return  repository.save(sft);
    }

    public void eliminar(int id){
        obtenerPorId(id);
        repository.deleteById(id);
    }

    public List<Software> obtenerCaducados(){
        return repository.findByFechaExpiracionBefore(LocalDate.now());
    }

    public List<Software> obtenerPorLicencia(Licencia licencia){
        return repository.findByLicencia(licencia);
    }
}

