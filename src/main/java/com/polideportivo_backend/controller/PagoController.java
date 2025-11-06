package com.polideportivo_backend.controller;

import com.polideportivo_backend.model.Pago;
import com.polideportivo_backend.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @GetMapping
    public ResponseEntity<List<Pago>> getAllPagos() {
        return ResponseEntity.ok(pagoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable Long id) {
        return pagoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pago> createPago(@RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.save(pago));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> updatePago(@PathVariable Long id, @RequestBody Pago pago) {
        return ResponseEntity.ok(pagoService.update(id, pago));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable Long id) {
        pagoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/reserva/{idReserva}")
    public ResponseEntity<List<Pago>> getPagosByReserva(@PathVariable Long idReserva) {
        return ResponseEntity.ok(pagoService.findByReservaId(idReserva));
    }

    @GetMapping("/estado/{estadoPago}")
    public ResponseEntity<List<Pago>> getPagosByEstado(@PathVariable String estadoPago) {
        return ResponseEntity.ok(pagoService.findByEstadoPago(estadoPago));
    }
}