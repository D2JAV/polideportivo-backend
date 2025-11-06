package com.polideportivo_backend.repository;

import com.polideportivo_backend.model.Campo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CampoRepository extends JpaRepository<Campo, Long> {
    List<Campo> findByEstado(String estado);
    List<Campo> findByNombreContainingIgnoreCase(String nombre);
}