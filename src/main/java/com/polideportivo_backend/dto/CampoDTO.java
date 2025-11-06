package com.polideportivo_backend.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CampoDTO {
    private Long idCampo;
    private String nombre;
    private BigDecimal precioPorHora;
    private String estado;
    private String descripcion;
}