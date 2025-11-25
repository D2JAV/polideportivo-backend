package com.polideportivo_backend.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampoDTO {
    private Long idCampo;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    private String nombre;

    @NotNull(message = "El precio por hora es obligatorio")
    @DecimalMin(value = "0.0", message = "El precio por hora debe ser mayor o igual a 0")
    private BigDecimal precioPorHora;

    private String estado = "DISPONIBLE";
    private String descripcion;
}