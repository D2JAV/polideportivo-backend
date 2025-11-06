package com.polideportivo_backend.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {
    private Integer idReserva;
    private Integer idCliente;
    private Integer idUsuario;
    private String clienteNombre;
    private String clienteApellido;
    private String usuarioNombre;

    @NotBlank
    @Size(min = 3, max = 50)
    private String tipoDeporte;

    @NotNull
    private LocalDate fechaReserva;

    @NotNull
    private LocalTime horaInicio;

    @NotNull
    @DecimalMin(value = "0.5")
    @DecimalMax(value = "24.0")
    private Double duracionHoras;

    @NotNull
    @DecimalMin(value = "0.0")
    private BigDecimal montoTotal;

    @Pattern(regexp = "PENDIENTE|CONFIRMADA|CANCELADA|COMPLETADA")
    private String estado;

    @Size(max = 255)
    private String observaciones;

    private LocalDateTime fechaCreacion;
}