package com.polideportivo_backend.controller;

import com.polideportivo_backend.dto.PagoDTO;
import com.polideportivo_backend.model.Pago;
import com.polideportivo_backend.service.PagoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PagoController {

    private final PagoService pagoService;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PagoDTO>> findAll() {
        List<PagoDTO> list = pagoService.findAll().stream()
                .map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> findById(@PathVariable Long id) {
        return pagoService.findById(id)
                .map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PagoDTO dto) {
        Pago obj = pagoService.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdPago()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoDTO> update(@PathVariable Long id, @Valid @RequestBody PagoDTO dto) {
        Pago obj = pagoService.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reserva/{idReserva}")
    public ResponseEntity<List<PagoDTO>> findByReservaId(@PathVariable Long idReserva) {
        List<PagoDTO> list = pagoService.findByReservaId(idReserva).stream()
                .map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/estado/{estadoPago}")
    public ResponseEntity<List<PagoDTO>> findByEstadoPago(@PathVariable String estadoPago) {
        List<PagoDTO> list = pagoService.findByEstadoPago(estadoPago).stream()
                .map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    private PagoDTO convertToDto(Pago obj) {
        return modelMapper.map(obj, PagoDTO.class);
    }

    private Pago convertToEntity(PagoDTO dto) {
        return modelMapper.map(dto, Pago.class);
    }
}