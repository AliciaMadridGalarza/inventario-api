package com.inventario.inventario_api.service;

import com.inventario.inventario_api.exception.ResourceNotFoundException;
import com.inventario.inventario_api.model.Usuario;
import com.inventario.inventario_api.repository.UsuarioRepository;

import com.inventario.inventario_api.model.enums.Cargo;
import com.inventario.inventario_api.model.enums.Departamento;

import java.util.List;


public class UsuarioService {

    private UsuarioRepository repository;

    public List<Usuario> obtenerTodos(){
        return repository.findAll();
    }

    public Usuario obtenerPorId(int id){
        return repository.findById(id)
                         .orElseThrow(() -> new ResourceNotFoundException("Error con el usuario o el ID"));
    }

    public Usuario guardar(Usuario usuario){
        return repository.save(usuario);
    }

    public Usuario actualizar(int id, Usuario usuario){
        Usuario user = obtenerPorId(id);
        user.setNombre(usuario.getNombre());
        user.setCargo(usuario.getCargo());
        user.setDepartamento(usuario.getDepartamento());
        return  repository.save(user);
    }

    public void eliminar(int id){
        obtenerPorId(id);
        repository.deleteById(id);
    }

    public List<Usuario> obtenerPorCargo(Cargo cargo){
        return repository.findByCargo(cargo);
    }

    public List<Usuario> obtenerPorDepartamento(Departamento departamento){
        return repository.findByDepartamento(departamento);
    }
}
