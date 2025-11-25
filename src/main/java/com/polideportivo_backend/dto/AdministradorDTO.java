package com.polideportivo_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorDTO {
    private Long idAdmin;
    private UsuarioDTO usuario;
}