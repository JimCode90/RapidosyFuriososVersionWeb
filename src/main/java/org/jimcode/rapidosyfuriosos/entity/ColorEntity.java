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

@Entity(name = "ColorEntity")
@Table(name = "color")
public class ColorEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codcol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomcol", length = 30, nullable = false)
    private String nombre;

    @Column(name = "estcol", nullable = false)
    private Boolean estado;
}
