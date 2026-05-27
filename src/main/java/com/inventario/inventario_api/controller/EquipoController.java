package com.inventario.inventario_api.controller;

import com.inventario.inventario_api.model.Equipo;
import com.inventario.inventario_api.model.enums.Estado;
import com.inventario.inventario_api.service.EquipoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    private final EquipoService service;

    public EquipoController(EquipoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Equipo> listarEquipos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Equipo obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }

    @GetMapping("/disponibles")
    public List<Equipo> obtenerDisponibles() {
        return service.obtenerPorEstado(Estado.DISPONIBLE);
    }


    @PostMapping
    public Equipo crearEquipo(@RequestBody Equipo equipo) {
        return service.guardar(equipo);
    }

    @PutMapping("/{id}")
    public Equipo actualizarEquipo(@PathVariable Integer id, @RequestBody Equipo equipo) {
        return service.actualizar(id, equipo);
    }

    @DeleteMapping("/{id}")
    public void eliminarEquipo(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
