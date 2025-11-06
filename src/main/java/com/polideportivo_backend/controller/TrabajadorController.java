package com.polideportivo_backend.controller;

import com.polideportivo_backend.model.Trabajador;
import com.polideportivo_backend.service.TrabajadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/trabajadores")
@RequiredArgsConstructor
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    @GetMapping
    public ResponseEntity<List<Trabajador>> getAllTrabajadores() {
        return ResponseEntity.ok(trabajadorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> getTrabajadorById(@PathVariable Long id) {
        return trabajadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Trabajador> createTrabajador(@RequestBody Trabajador trabajador) {
        return ResponseEntity.ok(trabajadorService.save(trabajador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrabajador(@PathVariable Long id) {
        trabajadorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}