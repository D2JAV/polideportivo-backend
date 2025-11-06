package com.polideportivo_backend.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Integer idCliente;

    @NotNull
    private Integer idUsuario;

    @NotNull
    @Size(min = 2, max = 50)
    private String nombre;

    @NotNull
    @Size(min = 2, max = 50)
    private String apellido;

    @NotNull
    @Pattern(regexp = "[0-9]{8}")
    private String dni;

    @Pattern(regexp = "[0-9]{9}")
    private String telefono;

    @Email
    private String email;

    private LocalDateTime fechaRegistro;
}