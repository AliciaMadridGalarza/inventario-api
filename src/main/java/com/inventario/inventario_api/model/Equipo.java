package com.inventario.inventario_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipo;
    private String marca;
    private String modelo;

    @Column(name = "numero_serie", unique = true)
    private String numeroSerie;

    private String estado;
    private String ubicacion;


}
