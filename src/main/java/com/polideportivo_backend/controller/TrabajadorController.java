package com.polideportivo_backend.controller;

import com.polideportivo_backend.dto.TrabajadorDTO;
import com.polideportivo_backend.model.Trabajador;
import com.polideportivo_backend.service.TrabajadorService;
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
@RequestMapping("/api/trabajadores")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<TrabajadorDTO>> findAll() {
        List<TrabajadorDTO> list = trabajadorService.findAll().stream()
                .map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabajadorDTO> findById(@PathVariable Long id) {
        return trabajadorService.findById(id)
                .map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TrabajadorDTO dto) {
        Trabajador obj = trabajadorService.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdTrabajador()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trabajadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private TrabajadorDTO convertToDto(Trabajador obj) {
        return modelMapper.map(obj, TrabajadorDTO.class);
    }

    private Trabajador convertToEntity(TrabajadorDTO dto) {
        return modelMapper.map(dto, Trabajador.class);
    }
}