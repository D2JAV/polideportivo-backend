package com.polideportivo_backend.repository;

import com.polideportivo_backend.model.Cliente;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.ScopedValue;
import java.util.List;

@Repository
public interface IClienteRepository  extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido);

    boolean existsByEmail(@Email String email);


    // Métodos personalizados si los necesitas
}