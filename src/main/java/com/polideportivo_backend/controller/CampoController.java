package com.polideportivo_backend.controller;

import com.polideportivo_backend.model.Campo;
import com.polideportivo_backend.service.CampoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/campos")
@RequiredArgsConstructor
public class CampoController {

    private final CampoService campoService;

    @GetMapping
    public ResponseEntity<List<Campo>> getAllCampos() {
        return ResponseEntity.ok(campoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campo> getCampoById(@PathVariable Long id) {
        return campoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Campo> createCampo(@RequestBody Campo campo) {
        return ResponseEntity.ok(campoService.save(campo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campo> updateCampo(@PathVariable Long id, @RequestBody Campo campo) {
        return ResponseEntity.ok(campoService.update(id, campo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampo(@PathVariable Long id) {
        campoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Campo>> getCamposByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(campoService.findByEstado(estado));
    }
}