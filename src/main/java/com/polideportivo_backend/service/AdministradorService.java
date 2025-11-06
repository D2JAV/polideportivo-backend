package com.polideportivo_backend.service;

import com.polideportivo_backend.model.Administrador;

import java.util.List;
import java.util.Optional;

public interface AdministradorService {
    List<Administrador> findAll();
    Optional<Administrador> findById(Long id);
    Administrador save(Administrador administrador);
    void deleteById(Long id);
    Optional<Administrador> findByUsuarioId(Long idUsuario);
}