package org.jimcode.rapidosyfuriosos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity(name = "ClienteEntity")
@Table(name = "cliente")
public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codcli")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomcli", length = 40, nullable = false)
    private String nombre;

    @Column(name = "apepcli", length = 40, nullable = false)
    private String apellidopaterno;

    @Column(name = "apemcli", length = 40, nullable = false)
    private String apellidomaterno;

    @Column(name = "doccli", length = 20, nullable = false)
    private String numerodocumento;

    @Column(name = "feccli", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechanacimiento;

    @Column(name = "naccli", length = 50, nullable = false)
    private String nacionalidad;

    @Column(name = "dircli", length = 300, nullable = false)
    private String direccion;

    @Column(name = "telcli", length = 15, nullable = false)
    private String telefono;

    @Column(name = "celcli", length = 15, nullable = false)
    private String celular;

    @Column(name = "corcli", length = 100, nullable = false)
    private String correo;

    @Column(name = "estcli", nullable = false)
    private Boolean estado;

    // Claves Foráneas
    @ManyToOne // Relación de mucho a uno
    @JoinColumn(name = "coddis", nullable = false)
    private DistritoEntity distrito;

    @ManyToOne // Relación de mucho a uno
    @JoinColumn(name = "codsex", nullable = false)
    private SexoEntity sexo;

    @ManyToOne // Relación de mucho a uno
    @JoinColumn(name = "codtipd", nullable = false)
    private TipoDocumentoEntity tipodocumento;



}
