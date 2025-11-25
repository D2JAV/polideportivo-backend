package com.polideportivo_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {
    private Long idPago;
    private ReservaDTO reserva;
    private LocalDateTime fechaPago;
    private Double montoPagado;
    private String metodoPago;
    private String referencia;
    private String estadoPago;
    private UsuarioDTO usuario;
    private String observaciones;
}