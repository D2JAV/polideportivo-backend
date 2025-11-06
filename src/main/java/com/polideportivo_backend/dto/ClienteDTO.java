package com.polideportivo_backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ClienteDTO {
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String correo;
    private LocalDateTime fechaRegistro;
}