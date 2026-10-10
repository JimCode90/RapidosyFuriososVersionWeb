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

@Entity(name = "SexoEntity")
@Table(name = "sexo")
public class SexoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codsex")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomsex", length = 20, nullable = false)
    private String nombre;

    @Column(name = "estsex", nullable = false)
    private Boolean estado;
}
