package com.polideportivo_backend.controller;

import com.polideportivo_backend.dto.ReservaDTO;
import com.polideportivo_backend.model.Reserva;
import com.polideportivo_backend.service.ReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaController {

    private final ReservaService reservaService;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> findAll() {
        List<ReservaDTO> list = reservaService.findAll().stream()
                .map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable Long id) {
        return reservaService.findById(id)
                .map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ReservaDTO dto) {
        Reserva obj = reservaService.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdReserva()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> update(@PathVariable Long id, @Valid @RequestBody ReservaDTO dto) {
        Reserva obj = reservaService.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<ReservaDTO>> findByClienteId(@PathVariable Long idCliente) {
        List<ReservaDTO> list = reservaService.findByClienteId(idCliente).stream()
                .map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/campo/{idCampo}")
    public ResponseEntity<List<ReservaDTO>> findByCampoId(@PathVariable Long idCampo) {
        List<ReservaDTO> list = reservaService.findByCampoId(idCampo).stream()
                .map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<ReservaDTO>> findByEstado(@PathVariable String estado) {
        List<ReservaDTO> list = reservaService.findByEstado(estado).stream()
                .map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
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

    private ReservaDTO convertToDto(Reserva obj) {
        return modelMapper.map(obj, ReservaDTO.class);
    }

    private Reserva convertToEntity(ReservaDTO dto) {
        return modelMapper.map(dto, Reserva.class);
    }
}