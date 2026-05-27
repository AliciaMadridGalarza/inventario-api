package com.inventario.inventario_api.model;

import com.inventario.inventario_api.model.enums.Licencia;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="software")
public class Software {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 30)
    private String version;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Licencia licencia;

    @Column(name = "fecha_expiracion")
    private LocalDate fechaExpiracion;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
