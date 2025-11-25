package com.polideportivo_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "campos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Campo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idCampo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(name = "precio_por_hora", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioPorHora;

    @Column(length = 20)
    private String estado = "DISPONIBLE";

    @Column(columnDefinition = "TEXT")
    private String descripcion;
}