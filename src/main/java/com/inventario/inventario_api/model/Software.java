package com.inventario.inventario_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "software")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Software {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_equipoS", nullable = false)
    private Equipos equipo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String version;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_licencia", nullable = false)
    private TipoLicencia tipoLicencia;

    @Column(name = "fecha_expiracion")
    private LocalDate fechaExpiracion; // puede ser null
}
