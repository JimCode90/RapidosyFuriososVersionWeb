package org.jimcode.rapidosyfuriosos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


// Lombok
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

// Jakarta
@Entity(name = "DistritoEntity")
@Table(name = "distrito")

// Serializar la clase
public class DistritoEntity implements Serializable {
    // Código de serialización
    private static final long serialVersionUID = 1L;

    @Id // Define la clave primaria
    @Column(name = "coddis") // Define la columna en bd
    @GeneratedValue(strategy = GenerationType.IDENTITY) // es para el autoincrement
    private Long codigo;

    @Column(name = "nomdis", length = 50, nullable = false)
    private String nombre;

    @Column(name = "estdis", nullable = false)
    private Boolean estado;

}
