package com.polideportivo_backend.controller;

import com.polideportivo_backend.dto.AdministradorDTO;
import com.polideportivo_backend.model.Administrador;
import com.polideportivo_backend.service.AdministradorService;
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
@RequestMapping("/api/administradores")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AdministradorController {

    private final AdministradorService administradorService;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<AdministradorDTO>> findAll() {
        List<AdministradorDTO> list = administradorService.findAll().stream()
                .map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDTO> findById(@PathVariable Long id) {
        return administradorService.findById(id)
                .map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody AdministradorDTO dto) {
        Administrador obj = administradorService.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdAdmin()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        administradorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private AdministradorDTO convertToDto(Administrador obj) {
        return modelMapper.map(obj, AdministradorDTO.class);
    }

    private Administrador convertToEntity(AdministradorDTO dto) {
        return modelMapper.map(dto, Administrador.class);
    }
}