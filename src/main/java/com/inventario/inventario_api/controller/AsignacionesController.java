package com.inventario.inventario_api.controller;

import com.inventario.inventario_api.model.Asignaciones;
import com.inventario.inventario_api.service.AsignacionesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionesController {

    private final AsignacionesService service;

    public AsignacionesController(AsignacionesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Asignaciones> obtenerTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Asignaciones obtenerPorId(@PathVariable int id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Asignaciones crear(@RequestBody Asignaciones asignacion) {
        return service.guardar(asignacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }

    @GetMapping("/usuario/{id_usuario}")
    public List<Asignaciones> obtenerPorUsuario(@PathVariable int id_usuario) {
        return service.obtenerPorUsuario(id_usuario);
    }

    @GetMapping("/equipo/{id_equipo}")
    public List<Asignaciones> obtenerPorEquipo(@PathVariable int id_equipo) {
        return service.obtenerPorEquipo(id_equipo);
    }
}
