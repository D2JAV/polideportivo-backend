package com.polideportivo_backend.service.implementation;

import com.polideportivo_backend.model.Trabajador;
import com.polideportivo_backend.repository.TrabajadorRepository;
import com.polideportivo_backend.service.TrabajadorService;
import com.polideportivo_backend.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrabajadorServiceImpl implements TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;

    @Override
    public List<Trabajador> findAll() {
        return trabajadorRepository.findAll();
    }

    @Override
    public Optional<Trabajador> findById(Long id) {
        return trabajadorRepository.findById(id);
    }

    @Override
    public Trabajador save(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    @Override
    public void deleteById(Long id) {
        Trabajador trabajador = trabajadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trabajador no encontrado con id: " + id));
        trabajadorRepository.delete(trabajador);
    }

    @Override
    public Optional<Trabajador> findByUsuarioId(Long idUsuario) {
        return trabajadorRepository.findByUsuarioIdUsuario(idUsuario);
    }
}