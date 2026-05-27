package com.inventario.inventario_api.model;


import com.inventario.inventario_api.model.enums.Cargo;
import com.inventario.inventario_api.model.enums.Departamento;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;

    @Column(nullable = false, length = 100)
    private String nombre;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cargo cargo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Departamento departamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
