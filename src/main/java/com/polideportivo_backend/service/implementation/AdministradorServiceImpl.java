package com.polideportivo_backend.service.implementation;

import com.polideportivo_backend.model.Administrador;
import com.polideportivo_backend.repository.AdministradorRepository;
import com.polideportivo_backend.service.AdministradorService;
import com.polideportivo_backend.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministradorServiceImpl implements AdministradorService {

    private final AdministradorRepository administradorRepository;

    @Override
    public List<Administrador> findAll() {
        return administradorRepository.findAll();
    }

    @Override
    public Optional<Administrador> findById(Long id) {
        return administradorRepository.findById(id);
    }

    @Override
    public Administrador save(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Override
    public void deleteById(Long id) {
        Administrador administrador = administradorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Administrador no encontrado con id: " + id));
        administradorRepository.delete(administrador);
    }

    @Override
    public Optional<Administrador> findByUsuarioId(Long idUsuario) {
        return administradorRepository.findByUsuarioIdUsuario(idUsuario);
    }
}