package com.polideportivo_backend.service;

import com.polideportivo_backend.model.Pago;
import java.util.List;
import java.util.Optional;

public interface PagoService {
    List<Pago> findAll();
    Optional<Pago> findById(Long id);
    Pago save(Pago pago);
    Pago update(Long id, Pago pago);
    void deleteById(Long id);
    List<Pago> findByReservaId(Long idReserva);
    List<Pago> findByEstadoPago(String estadoPago);
    List<Pago> findByUsuarioId(Long idUsuario);
}