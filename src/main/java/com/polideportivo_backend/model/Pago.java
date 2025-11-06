package com.polideportivo_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Data
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false)
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
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private String observaciones;
}