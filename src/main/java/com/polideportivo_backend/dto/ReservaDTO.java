package com.polideportivo_backend.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Data
public class ReservaDTO {
    private Long idReserva;
    private ClienteDTO cliente;
    private CampoDTO campo;
    private ActividadDTO actividad;
    private LocalDate fechaReserva;
    private LocalTime horaInicio;
    private Double duracionHoras;
    private Double montoTotal;
    private UsuarioDTO usuario;
    private String estado;
    private LocalDateTime fechaCreacion;
}