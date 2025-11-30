package com.polideportivo_backend.service.implementation;

import com.polideportivo_backend.model.Actividad;
import com.polideportivo_backend.repository.ActividadRepository;
import com.polideportivo_backend.repository.IGenericRepository;
import com.polideportivo_backend.service.ActividadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActividadServiceImpl extends GenericService<Actividad, Long> implements ActividadService {
    private final ActividadRepository repo;

    @Override
    protected JpaRepository<Actividad, Long> getRepo() {
        return repo;
    }

    @Override
    public Optional<Actividad> findByNombre(String nombre) {
        return repo.findByNombre(nombre);
    }
}