package com.polideportivo_backend.service.implementation;

import com.polideportivo_backend.model.Reserva;
import com.polideportivo_backend.repository.ReservaRepository;
import com.polideportivo_backend.service.ReservaService;
import com.polideportivo_backend.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Override
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva update(Long id, Reserva reservaDetails) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con id: " + id));

        reserva.setCliente(reservaDetails.getCliente());
        reserva.setCampo(reservaDetails.getCampo());
        reserva.setActividad(reservaDetails.getActividad());
        reserva.setFechaReserva(reservaDetails.getFechaReserva());
        reserva.setHoraInicio(reservaDetails.getHoraInicio());
        reserva.setDuracionHoras(reservaDetails.getDuracionHoras());
        reserva.setMontoTotal(reservaDetails.getMontoTotal());
        reserva.setUsuario(reservaDetails.getUsuario());
        reserva.setEstado(reservaDetails.getEstado());

        return reservaRepository.save(reserva);
    }

    @Override
    public void deleteById(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con id: " + id));
        reservaRepository.delete(reserva);
    }

    @Override
    public List<Reserva> findByClienteId(Long idCliente) {
        return reservaRepository.findByClienteIdCliente(idCliente);
    }

    @Override
    public List<Reserva> findByCampoId(Long idCampo) {
        return reservaRepository.findByCampoIdCampo(idCampo);
    }

    @Override
    public List<Reserva> findByEstado(String estado) {
        return reservaRepository.findByEstado(estado);
    }

    @Override
    public List<Reserva> findByFechaReserva(LocalDate fechaReserva) {
        return reservaRepository.findByFechaReserva(fechaReserva);
    }

    @Override
    public List<Reserva> findByFechaReservaAndCampoId(LocalDate fechaReserva, Long idCampo) {
        return reservaRepository.findByFechaReservaAndCampoIdCampo(fechaReserva, idCampo);
    }

    @Override
    public Boolean verificarDisponibilidad(Long idCampo, LocalDate fecha, String horaInicio, Double duracion) {
        List<Reserva> reservasExistentes = reservaRepository.findByFechaReservaAndCampoIdCampo(fecha, idCampo);

        if (reservasExistentes.isEmpty()) {
            return true;
        }

        LocalTime horaInicioReserva = LocalTime.parse(horaInicio);
        LocalTime horaFinReserva = horaInicioReserva.plusHours(duracion.longValue());

        for (Reserva reserva : reservasExistentes) {
            if (!reserva.getEstado().equals("CANCELADA")) {
                LocalTime horaInicioExistente = reserva.getHoraInicio();
                LocalTime horaFinExistente = horaInicioExistente.plusHours(reserva.getDuracionHoras().longValue());

                // Verificar superposición
                if (horaInicioReserva.isBefore(horaFinExistente) && horaFinReserva.isAfter(horaInicioExistente)) {
                    return false;
                }
            }
        }

        return true;
    }
}