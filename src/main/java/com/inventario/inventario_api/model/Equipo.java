package com.inventario.inventario_api.model;

import com.inventario.inventario_api.model.enums.Estado;
import com.inventario.inventario_api.model.enums.Marca;
import com.inventario.inventario_api.model.enums.TipoEquipo;
import com.inventario.inventario_api.model.enums.Ubicacion;
import jakarta.persistence.*;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEquipo tipoEquipo;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Marca marca;

    @Column(length = 100)
    private String modelo;

    @Column(name = "numero_serie", unique = true)
    private String numeroSerie;

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.DISPONIBLE; // POR DEFECTO SE PONE QUE ESTRA DISPONIBÑE


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Ubicacion ubicacion;


    @ManyToOne
    @JoinColumn(name = "id_software")
    private Software software;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }
}
