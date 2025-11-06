package com.polideportivo_backend.service.implementation;

import com.polideportivo_backend.model.Pago;
import com.polideportivo_backend.repository.PagoRepository;
import com.polideportivo_backend.service.PagoService;
import com.polideportivo_backend.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;

    @Override
    public List<Pago> findAll() {
        return pagoRepository.findAll();
    }

    @Override
    public Optional<Pago> findById(Long id) {
        return pagoRepository.findById(id);
    }

    @Override
    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public Pago update(Long id, Pago pagoDetails) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado con id: " + id));

        pago.setReserva(pagoDetails.getReserva());
        pago.setFechaPago(pagoDetails.getFechaPago());
        pago.setMontoPagado(pagoDetails.getMontoPagado());
        pago.setMetodoPago(pagoDetails.getMetodoPago());
        pago.setReferencia(pagoDetails.getReferencia());
        pago.setEstadoPago(pagoDetails.getEstadoPago());
        pago.setUsuario(pagoDetails.getUsuario());
        pago.setObservaciones(pagoDetails.getObservaciones());

        return pagoRepository.save(pago);
    }

    @Override
    public void deleteById(Long id) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado con id: " + id));
        pagoRepository.delete(pago);
    }

    @Override
    public List<Pago> findByReservaId(Long idReserva) {
        return pagoRepository.findByReservaIdReserva(idReserva);
    }

    @Override
    public List<Pago> findByEstadoPago(String estadoPago) {
        return pagoRepository.findByEstadoPago(estadoPago);
    }

    @Override
    public List<Pago> findByUsuarioId(Long idUsuario) {
        return pagoRepository.findByUsuarioIdUsuario(idUsuario);
    }
}