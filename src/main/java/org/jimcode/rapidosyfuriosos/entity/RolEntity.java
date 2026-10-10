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

@Entity(name = "RolEntity")
@Table(name = "rol")
public class RolEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codrol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomrol", length = 40, nullable = false)
    private String nombre;

    @Column(name = "estrol", nullable = false)
    private Boolean estado;
}
