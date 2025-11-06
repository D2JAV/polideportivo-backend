package com.polideportivo_backend.controller;

import com.polideportivo_backend.model.Actividad;
import com.polideportivo_backend.service.ActividadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/actividades")
@RequiredArgsConstructor
public class ActividadController {

    private final ActividadService actividadService;

    @GetMapping
    public ResponseEntity<List<Actividad>> getAllActividades() {
        return ResponseEntity.ok(actividadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actividad> getActividadById(@PathVariable Long id) {
        return actividadService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Actividad> createActividad(@RequestBody Actividad actividad) {
        return ResponseEntity.ok(actividadService.save(actividad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actividad> updateActividad(@PathVariable Long id, @RequestBody Actividad actividad) {
        return ResponseEntity.ok(actividadService.update(id, actividad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActividad(@PathVariable Long id) {
        actividadService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Actividad> getActividadByNombre(@PathVariable String nombre) {
        return actividadService.findByNombre(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}