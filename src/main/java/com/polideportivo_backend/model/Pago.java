package com.polideportivo_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pagos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idPago;

    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false,
            foreignKey = @ForeignKey(name = "FK_PAGO_RESERVA"))
    private Reserva reserva;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago = LocalDateTime.now();

    @Column(name = "monto_pagado", nullable = false)
    private Double montoPagado;

    @Column(name = "metodo_pago", length = 20)
    private String metodoPago; // EFECTIVO, TARJETA, YAPE, PLIN

    private String referencia;

    @Column(name = "estado_pago", length = 20)
    private String estadoPago = "PENDIENTE"; // PENDIENTE, COMPLETADO, ANULADO

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false,
            foreignKey = @ForeignKey(name = "FK_PAGO_USUARIO"))
    private Usuario usuario;

    private String observaciones;
}