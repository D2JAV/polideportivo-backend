package com.polideportivo_backend.dto;

import lombok.Data;

@Data
public class AdministradorDTO {
    private Long idAdmin;
    private UsuarioDTO usuario;
}