package org.jimcode.rapidosyfuriosos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity(name = "VehiculoEntity")
@Table(name = "vehiculo")
public class VehiculoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codveh")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "plaveh", length = 20, nullable = false)
    private String placa;

    @Column(name = "modveh", length = 50, nullable = false)
    private String modelo;

    @Column(name = "anioveh", nullable = false)
    private Integer anio;

    @Column(name = "estveh", nullable = false)
    private Boolean estado;

    // Claves Foráneas
    @ManyToOne // Relación de mucho a uno
    @JoinColumn(name = "codmar", nullable = false)
    private MarcaEntity marca;

    @ManyToOne // Relación de mucho a uno
    @JoinColumn(name = "codcol", nullable = false)
    private ColorEntity color;

    @ManyToOne // Relación de mucho a uno
    @JoinColumn(name = "codcli", nullable = false)
    private ClienteEntity cliente;

}
