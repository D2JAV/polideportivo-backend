package com.polideportivo_backend.controller;

import com.polideportivo_backend.dto.ActividadDTO;
import com.polideportivo_backend.model.Actividad;
import com.polideportivo_backend.service.ActividadService;
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
@RequestMapping("/api/actividades")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ActividadController {

    private final ActividadService actividadService;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ActividadDTO>> findAll() {
        List<ActividadDTO> list = actividadService.findAll().stream()
                .map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActividadDTO> findById(@PathVariable Long id) {
        return actividadService.findById(id)
                .map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ActividadDTO dto) {
        Actividad obj = actividadService.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdActividad()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActividadDTO> update(@PathVariable Long id, @Valid @RequestBody ActividadDTO dto) {
        Actividad obj = actividadService.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        actividadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ActividadDTO> findByNombre(@PathVariable String nombre) {
        return actividadService.findByNombre(nombre)
                .map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    private ActividadDTO convertToDto(Actividad obj) {
        return modelMapper.map(obj, ActividadDTO.class);
    }

    private Actividad convertToEntity(ActividadDTO dto) {
        return modelMapper.map(dto, Actividad.class);
    }
}