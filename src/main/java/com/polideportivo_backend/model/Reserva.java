package com.polideportivo_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false,
            foreignKey = @ForeignKey(name = "FK_RESERVA_CLIENTE"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_campo", nullable = false,
            foreignKey = @ForeignKey(name = "FK_RESERVA_CAMPO"))
    private Campo campo;

    @ManyToOne
    @JoinColumn(name = "id_actividad", nullable = false,
            foreignKey = @ForeignKey(name = "FK_RESERVA_ACTIVIDAD"))
    private Actividad actividad;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fechaReserva;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "duracion_horas", nullable = false)
    private Double duracionHoras;

    @Column(name = "monto_total", nullable = false)
    private Double montoTotal;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false,
            foreignKey = @ForeignKey(name = "FK_RESERVA_USUARIO"))
    private Usuario usuario;

    @Column(length = 20)
    private String estado = "PENDIENTE";

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();
}