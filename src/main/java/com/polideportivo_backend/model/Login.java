package com.polideportivo_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "login")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idLogin;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "fecha_login")
    private LocalDateTime fechaLogin;

    @Column(name = "ip_address", length = 45)
    private String ipAddress;

    @Column(name = "user_agent", length = 255)
    private String userAgent;

    @Column(nullable = false)
    private Boolean exito = true;

    @Column(name = "token_sesion", length = 500)
    private String tokenSesion;

    @Column(name = "fecha_expiracion")
    private LocalDateTime fechaExpiracion;

    @PrePersist
    public void prePersist() {
        this.fechaLogin = LocalDateTime.now();
    }
}
