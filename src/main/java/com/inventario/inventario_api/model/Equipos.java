package com.inventario.inventario_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "equipos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Equipos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEquipo tipo;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(name = "numero_serie", nullable = false, unique = true)
    private String numeroSerie;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EstadoEquipo estado = EstadoEquipo.DISPONIBLE;

    @Column(nullable = true)
    private String ubicacion;

}
