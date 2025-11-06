package com.polideportivo_backend.repository;

import com.polideportivo_backend.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByReservaIdReserva(Long idReserva);
    List<Pago> findByEstadoPago(String estadoPago);
    List<Pago> findByUsuarioIdUsuario(Long idUsuario);
}