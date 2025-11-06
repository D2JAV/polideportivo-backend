package com.polideportivo_backend.repository;

import com.polideportivo_backend.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByClienteIdCliente(Long idCliente);
    List<Reserva> findByCampoIdCampo(Long idCampo);
    List<Reserva> findByEstado(String estado);
    List<Reserva> findByFechaReserva(LocalDate fechaReserva);
    List<Reserva> findByFechaReservaAndCampoIdCampo(LocalDate fechaReserva, Long idCampo);
}