package com.inventario.inventario_api.controller;

import com.inventario.inventario_api.model.Mantenimiento;
import com.inventario.inventario_api.model.enums.TipoMantenimiento;
import com.inventario.inventario_api.service.MantenimientoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mantenimiento")
public class MantenimientoController {

    private final MantenimientoService service;

    public MantenimientoController(MantenimientoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mantenimiento> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Mantenimiento obtenerPorId(@PathVariable int id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Mantenimiento crear(@RequestBody Mantenimiento mantenimiento) {
        return service.guardar(mantenimiento);
    }

    @PutMapping("/{id}")
    public Mantenimiento actualizar(@PathVariable int id, @RequestBody Mantenimiento mantenimiento) {
        return service.actualizar(id, mantenimiento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }

    @GetMapping("/equipo/{id_equipo}")
    public List<Mantenimiento> obtenerPorEquipo(@PathVariable int id_equipo) {
        return service.obtenerPorEquipo(id_equipo);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Mantenimiento> obtenerPorTipo(@PathVariable TipoMantenimiento tipo) {
        return service.obtenerPorTipoMantenimiento(tipo);
    }
}
