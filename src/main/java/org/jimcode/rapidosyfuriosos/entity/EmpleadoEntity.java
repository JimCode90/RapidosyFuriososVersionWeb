package org.jimcode.rapidosyfuriosos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity(name = "EmpleadoEntity")
@Table(name = "empleado")
public class EmpleadoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codemp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomemp", length = 40, nullable = false)
    private String nombre;

    @Column(name = "apepemp", length = 40, nullable = false)
    private String apellidopaterno;

    @Column(name = "apememp", length = 40, nullable = false)
    private String apellidomaterno;

    @Column(name = "docemp", length = 20, nullable = false)
    private String numerodocumento;

    @Column(name = "fecemp", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechanacimiento;

    @Column(name = "nacemp", length = 50, nullable = false)
    private String nacionalidad;

    @Column(name = "diremp", length = 300, nullable = false)
    private String direccion;

    @Column(name = "telemp", length = 15, nullable = false)
    private String telefono;

    @Column(name = "celemp", length = 15, nullable = false)
    private String celular;

    @Column(name = "coremp", length = 100, nullable = false)
    private String correo;

    @Column(name = "usuemp", length = 40, nullable = false)
    private String usuario;

    @Column(name = "claemp", length = 255, nullable = false)
    private String clave;

    @Column(name = "sueemp", precision = 10, scale = 2, nullable = false)
    private BigDecimal sueldo;

    @Column(name = "estemp", nullable = false)
    private Boolean estado;

    // Claves Foráneas
    @ManyToOne // Relación de mucho a uno
    @JoinColumn(name = "coddis", nullable = false)
    private DistritoEntity distrito;

    @ManyToOne // Relación de mucho a uno
    @JoinColumn(name = "codrol", nullable = false)
    private RolEntity rol;

    @ManyToOne // Relación de mucho a uno
    @JoinColumn(name = "codsex", nullable = false)
    private SexoEntity sexo;

    @ManyToOne // Relación de mucho a uno
    @JoinColumn(name = "codtipd", nullable = false)
    private TipoDocumentoEntity tipodocumento;

    @ManyToOne // Relación de mucho a uno
    @JoinColumn(name = "codestc", nullable = false)
    private EstadoCivilEntity estadocivil;

}
