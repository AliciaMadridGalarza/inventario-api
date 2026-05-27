package com.inventario.inventario_api.model;


import com.inventario.inventario_api.model.enums.TipoMantenimiento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMantenimiento tipoMantenimiento;

    private LocalDate fecha;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoMantenimiento getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(TipoMantenimiento tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
