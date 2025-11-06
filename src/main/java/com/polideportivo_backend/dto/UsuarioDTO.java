package com.polideportivo_backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UsuarioDTO {
    private Long idUsuario;
    private String nombreUsuario;
    private String correo;
    private String password;
    private LocalDateTime fechaCreacion;
    private String rol;
    private String dni;
    private String telefono;
    private String nombre;
    private String apellido;
    private Boolean estado;
}