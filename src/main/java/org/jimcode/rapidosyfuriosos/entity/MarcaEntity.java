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

@Entity(name = "MarcaEntity")
@Table(name = "marca")
public class MarcaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codmar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nommar", length = 50, nullable = false)
    private String nombre;

    @Column(name = "estmar", nullable = false)
    private Boolean estado;
}
