package com.polideportivo_backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Integer idUsuario;

    @NotBlank
    @Size(min = 3, max = 50)
    private String nombreUsuario;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    @Pattern(regexp = "ADMIN|TRABAJADOR|CLIENTE")
    private String rol;

    @NotBlank
    @Size(min = 2, max = 50)
    private String nombre;

    @NotBlank
    @Size(min = 2, max = 50)
    private String apellido;

    @NotBlank
    @Pattern(regexp = "[0-9]{8}")
    private String dni;

    @Pattern(regexp = "[0-9]{9}")
    private String telefono;

    private Boolean estado = true;

    private LocalDateTime fechaRegistro;

    private LocalDateTime ultimoLogin;

    public Object getIdCliente() {
                return null;
    }

    public void setIdCliente(@Valid Integer id) {

    }
}