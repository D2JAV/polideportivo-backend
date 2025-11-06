package com.polideportivo_backend.service.implementation;

import com.polideportivo_backend.model.Campo;
import com.polideportivo_backend.repository.CampoRepository;
import com.polideportivo_backend.service.CampoService;
import com.polideportivo_backend.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CampoServiceImpl implements CampoService {

    private final CampoRepository campoRepository;

    @Override
    public List<Campo> findAll() {
        return campoRepository.findAll();
    }

    @Override
    public Optional<Campo> findById(Long id) {
        return campoRepository.findById(id);
    }

    @Override
    public Campo save(Campo campo) {
        return campoRepository.save(campo);
    }

    @Override
    public Campo update(Long id, Campo campoDetails) {
        Campo campo = campoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campo no encontrado con id: " + id));

        campo.setNombre(campoDetails.getNombre());
        campo.setPrecioPorHora(campoDetails.getPrecioPorHora());
        campo.setEstado(campoDetails.getEstado());
        campo.setDescripcion(campoDetails.getDescripcion());

        return campoRepository.save(campo);
    }

    @Override
    public void deleteById(Long id) {
        Campo campo = campoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campo no encontrado con id: " + id));
        campoRepository.delete(campo);
    }

    @Override
    public List<Campo> findByEstado(String estado) {
        return campoRepository.findByEstado(estado);
    }

    @Override
    public List<Campo> findByNombreContaining(String nombre) {
        return campoRepository.findByNombreContainingIgnoreCase(nombre);
    }
}