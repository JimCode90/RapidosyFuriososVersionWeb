package org.jimcode.rapidosyfuriosos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity(name = "ServicioEntity")
@Table(name = "servicio")
public class ServicioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomser", length = 50, nullable = false)
    private String nombre;

    @Column(name = "desser", length = 300, nullable = false)
    private String descripcion;

    @Column(name = "preser", precision = 10, scale = 2, nullable = false)
    private BigDecimal precio;

    @Column(name = "estser", nullable = false)
    private Boolean estado;
}
