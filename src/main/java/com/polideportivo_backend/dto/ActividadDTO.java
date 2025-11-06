package com.polideportivo_backend.dto;

import lombok.Data;

@Data
public class ActividadDTO {
    private Long idActividad;
    private String nombre;
    private String descripcion;
}