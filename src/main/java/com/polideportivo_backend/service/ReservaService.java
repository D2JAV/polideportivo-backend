package com.polideportivo_backend.service;

import com.polideportivo_backend.model.Reserva;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservaService {
    List<Reserva> findAll();
    Optional<Reserva> findById(Long id);
    Reserva save(Reserva reserva);
    Reserva update(Long id, Reserva reserva);
    void deleteById(Long id);
    List<Reserva> findByClienteId(Long idCliente);
    List<Reserva> findByCampoId(Long idCampo);
    List<Reserva> findByEstado(String estado);
    List<Reserva> findByFechaReserva(LocalDate fechaReserva);
    List<Reserva> findByFechaReservaAndCampoId(LocalDate fechaReserva, Long idCampo);
    Boolean verificarDisponibilidad(Long idCampo, LocalDate fecha, String horaInicio, Double duracion);
}