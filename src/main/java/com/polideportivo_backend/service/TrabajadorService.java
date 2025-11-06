package com.polideportivo_backend.service;

import com.polideportivo_backend.model.Trabajador;

import java.util.List;
import java.util.Optional;

public interface TrabajadorService {
    List<Trabajador> findAll();
    Optional<Trabajador> findById(Long id);
    Trabajador save(Trabajador trabajador);
    void deleteById(Long id);
    Optional<Trabajador> findByUsuarioId(Long idUsuario);
}