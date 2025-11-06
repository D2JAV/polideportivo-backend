package com.polideportivo_backend.controller;

import com.polideportivo_backend.model.Reserva;
import com.polideportivo_backend.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> getAllReservas() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Long id) {
        return reservaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.save(reserva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.update(id, reserva));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        reservaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<Reserva>> getReservasByCliente(@PathVariable Long idCliente) {
        return ResponseEntity.ok(reservaService.findByClienteId(idCliente));
    }

    @GetMapping("/campo/{idCampo}")
    public ResponseEntity<List<Reserva>> getReservasByCampo(@PathVariable Long idCampo) {
        return ResponseEntity.ok(reservaService.findByCampoId(idCampo));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Reserva>> getReservasByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(reservaService.findByEstado(estado));
    }

    @GetMapping("/disponibilidad")
    public ResponseEntity<Boolean> verificarDisponibilidad(
            @RequestParam Long idCampo,
            @RequestParam String fecha,
            @RequestParam String horaInicio,
            @RequestParam Double duracion) {

        LocalDate fechaReserva = LocalDate.parse(fecha);
        Boolean disponible = reservaService.verificarDisponibilidad(idCampo, fechaReserva, horaInicio, duracion);
        return ResponseEntity.ok(disponible);
    }
}