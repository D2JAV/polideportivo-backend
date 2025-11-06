package com.polideportivo_backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
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