package com.polideportivo_backend.service.implementation;

import com.polideportivo_backend.model.Actividad;
import com.polideportivo_backend.repository.ActividadRepository;
import com.polideportivo_backend.repository.IGenericRepository;
import com.polideportivo_backend.service.ActividadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActividadServiceImpl extends GenericService<Actividad, Long> implements ActividadService {
    private final ActividadRepository repo;

    @Override
    protected IGenericRepository<Actividad, Long> getRepo() {
        return (IGenericRepository<Actividad, Long>) repo;
    }

    @Override
    public Optional<Actividad> findByNombre(String nombre) {
        return repo.findByNombre(nombre);
    }
}