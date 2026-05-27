package com.inventario.inventario_api.controller;


import com.inventario.inventario_api.model.Usuario;
import com.inventario.inventario_api.model.enums.Cargo;
import com.inventario.inventario_api.model.enums.Departamento;
import com.inventario.inventario_api.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable int id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable int id, @RequestBody Usuario usuario) {
        return service.actualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        service.eliminar(id);
    }

    @GetMapping("/cargo/{cargo}")
    public List<Usuario> obtenerPorCargo(@PathVariable Cargo cargo) {
        return service.obtenerPorCargo(cargo);
    }

    @GetMapping("/departamento/{departamento}")
    public List<Usuario> obtenerPorDepartamento(@PathVariable Departamento departamento) {
        return service.obtenerPorDepartamento(departamento);
    }
}
