package com.polideportivo_backend.repository;

import com.polideportivo_backend.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface IReservaRepository  extends JpaRepository<Reserva, Integer> {
    Collection<Object> findByClienteIdCliente(Integer idCliente);

    Collection<Object> findByFechaReserva(LocalDate fecha);
    // Métodos personalizados si los necesitas
}