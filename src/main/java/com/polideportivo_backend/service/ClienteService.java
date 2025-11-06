package com.polideportivo_backend.service;

import com.polideportivo_backend.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente save(Cliente cliente);
    Cliente update(Long id, Cliente cliente);
    void deleteById(Long id);
    Optional<Cliente> findByDni(String dni);
    Optional<Cliente> findByCorreo(String correo);
}