package com.polideportivo_backend.service.implementation;

import com.polideportivo_backend.model.Actividad;
import com.polideportivo_backend.repository.ActividadRepository;
import com.polideportivo_backend.service.ActividadService;
import com.polideportivo_backend.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActividadServiceImpl implements ActividadService {

    private final ActividadRepository actividadRepository;

    @Override
    public List<Actividad> findAll() {
        return actividadRepository.findAll();
    }

    @Override
    public Optional<Actividad> findById(Long id) {
        return actividadRepository.findById(id);
    }

    @Override
    public Actividad save(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    @Override
    public Actividad update(Long id, Actividad actividadDetails) {
        Actividad actividad = actividadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actividad no encontrada con id: " + id));

        actividad.setNombre(actividadDetails.getNombre());
        actividad.setDescripcion(actividadDetails.getDescripcion());

        return actividadRepository.save(actividad);
    }

    @Override
    public void deleteById(Long id) {
        Actividad actividad = actividadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actividad no encontrada con id: " + id));
        actividadRepository.delete(actividad);
    }

    @Override
    public Optional<Actividad> findByNombre(String nombre) {
        return actividadRepository.findByNombre(nombre);
    }
}