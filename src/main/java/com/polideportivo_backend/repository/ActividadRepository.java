package com.polideportivo_backend.repository;

import com.polideportivo_backend.model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {
    Optional<Actividad> findByNombre(String nombre);
}