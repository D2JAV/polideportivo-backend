package com.polideportivo_backend.controller;

import com.polideportivo_backend.dto.CampoDTO;
import com.polideportivo_backend.model.Campo;
import com.polideportivo_backend.service.CampoService;
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
@RequestMapping("/api/campos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CampoController {

    private final CampoService campoService;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CampoDTO>> findAll() {
        List<CampoDTO> list = campoService.findAll().stream()
                .map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampoDTO> findById(@PathVariable Long id) {
        return campoService.findById(id)
                .map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CampoDTO dto) {
        Campo obj = campoService.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdCampo()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampoDTO> update(@PathVariable Long id, @Valid @RequestBody CampoDTO dto) {
        Campo obj = campoService.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        campoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<CampoDTO>> findByEstado(@PathVariable String estado) {
        List<CampoDTO> list = campoService.findByEstado(estado).stream()
                .map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    private CampoDTO convertToDto(Campo obj) {
        return modelMapper.map(obj, CampoDTO.class);
    }

    private Campo convertToEntity(CampoDTO dto) {
        return modelMapper.map(dto, Campo.class);
    }
}