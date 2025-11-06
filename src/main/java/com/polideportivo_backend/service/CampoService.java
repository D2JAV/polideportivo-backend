package com.polideportivo_backend.service;

import com.polideportivo_backend.model.Campo;
import java.util.List;
import java.util.Optional;

public interface CampoService {
    List<Campo> findAll();
    Optional<Campo> findById(Long id);
    Campo save(Campo campo);
    Campo update(Long id, Campo campo);
    void deleteById(Long id);
    List<Campo> findByEstado(String estado);
    List<Campo> findByNombreContaining(String nombre);
}