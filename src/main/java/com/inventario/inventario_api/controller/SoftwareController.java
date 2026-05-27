package com.inventario.inventario_api.controller;


import com.inventario.inventario_api.model.Software;
import com.inventario.inventario_api.model.enums.Licencia;
import com.inventario.inventario_api.service.SoftwareService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/software")
public class SoftwareController {

    private final SoftwareService service;

    public SoftwareController(SoftwareService service) {
        this.service = service;
    }

    @GetMapping
    public List<Software> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Software obtenerPorId(@PathVariable int id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Software crear(@RequestBody Software software) {
        return service.guardar(software);
    }

    @PutMapping("/{id}")
    public Software actualizar(@PathVariable int id, @RequestBody Software software) {
        return service.actualizar(id, software);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }

    @GetMapping("/caducados")
    public List<Software> obtenerCaducados() {
        return service.obtenerCaducados();
    }

    @GetMapping("/licencia/{licencia}")
    public List<Software> obtenerPorLicencia(@PathVariable Licencia licencia) {
        return service.obtenerPorLicencia(licencia);
    }
}
