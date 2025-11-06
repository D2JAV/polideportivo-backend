package com.polideportivo_backend.service;

import com.polideportivo_backend.model.Actividad;
import java.util.List;
import java.util.Optional;

public interface ActividadService {
    List<Actividad> findAll();
    Optional<Actividad> findById(Long id);
    Actividad save(Actividad actividad);
    Actividad update(Long id, Actividad actividad);
    void deleteById(Long id);
    Optional<Actividad> findByNombre(String nombre);
}