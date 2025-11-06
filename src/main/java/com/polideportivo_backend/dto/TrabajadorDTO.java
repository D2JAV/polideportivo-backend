package com.polideportivo_backend.dto;

import lombok.Data;

@Data
public class TrabajadorDTO {
    private Long idTrabajador;
    private UsuarioDTO usuario;
}