package com.polideportivo_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrabajadorDTO {
    private Long idTrabajador;
    private UsuarioDTO usuario;
}