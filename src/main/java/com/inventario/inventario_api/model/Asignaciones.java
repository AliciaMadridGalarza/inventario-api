package com.inventario.inventario_api.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "asignaciones")
public class Asignaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha_asignacion")
    private LocalDate fechaAsignacion = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;


    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
