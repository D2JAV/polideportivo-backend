package com.polideportivo_backend.controller;

import com.polideportivo_backend.dto.ReservaDTO;
import com.polideportivo_backend.model.Reserva;
import com.polideportivo_backend.service.IReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaController {

    private final IReservaService service;

    @GetMapping
    public ResponseEntity<List<Reserva>> findAll() throws Exception {
        List<Reserva> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable("id") Integer id) throws Exception {
        ReservaDTO obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<ReservaDTO>> findByCliente(@PathVariable("idCliente") Integer idCliente) throws Exception {
        List<ReservaDTO> list = service.findByCliente(idCliente);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<ReservaDTO>> findByFecha(@PathVariable("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) throws Exception {
        List<ReservaDTO> list = service.findByFecha(fecha);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<ReservaDTO>> findByEstado(@PathVariable("estado") String estado) throws Exception {
        List<ReservaDTO> list = service.findByEstado(estado);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> save(@Valid @RequestBody ReservaDTO dto) throws Exception {
        ReservaDTO obj = service.save((Reserva) dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdReserva()).toUri();
        return ResponseEntity.created(location).body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody ReservaDTO dto) throws Exception {
        dto.setIdReserva(id);
        ReservaDTO obj = service.update(id, dto);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Void> changeEstado(@PathVariable("id") Integer id, @RequestParam String estado) throws Exception {
        service.changeEstado(id, estado);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/confirmar")
    public ResponseEntity<ReservaDTO> confirmarReserva(@PathVariable("id") Integer id) throws Exception {
        ReservaDTO obj = service.confirmarReserva(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<ReservaDTO> cancelarReserva(@PathVariable("id") Integer id) throws Exception {
        ReservaDTO obj = service.cancelarReserva(id);
        return ResponseEntity.ok(obj);
    }
}