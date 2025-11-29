package com.polideportivo_backend.service.implementation;

import com.polideportivo_backend.exception.ResourceNotFoundException;
import com.polideportivo_backend.model.Trabajador;
import com.polideportivo_backend.model.Usuario;
import com.polideportivo_backend.repository.IGenericRepository;
import com.polideportivo_backend.repository.UsuarioRepository;
import com.polideportivo_backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repo;

    @Override
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repo.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        Usuario usuario = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trabajador no encontrado con id: " + id));
        repo.delete(usuario);
    }

    @Override
    public Optional<Usuario> findByCorreo(String correo) {
        return repo.findByCorreo(correo);
    }

    @Override
    public Optional<Usuario> findByNombreUsuario(String nombreUsuario) {
        return repo.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public Boolean existsByCorreo(String correo) {
        return repo.existsByCorreo(correo);
    }

    @Override
    public Boolean existsByNombreUsuario(String nombreUsuario) {
        return repo.existsByNombreUsuario(nombreUsuario);
    }

    @Override
    public Optional<Usuario> validar (String correo, String password) {
        Optional<Usuario> usuarioOpt = repo.findByCorreo(correo);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (usuario.getPassword().equals(password)) {
                return usuarioOpt;
            }
        }
        return Optional.empty();
    }

    @Override
    public Usuario update(Long id, Usuario usuarioActualizado) {
        // Buscar el usuario existente
        Usuario usuarioExistente = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        // Mantener campos que NO se pueden actualizar
        usuarioActualizado.setIdUsuario(usuarioExistente.getIdUsuario());
        usuarioActualizado.setFechaCreacion(usuarioExistente.getFechaCreacion());
        usuarioActualizado.setCorreo(usuarioExistente.getCorreo());
        usuarioActualizado.setNombreUsuario(usuarioExistente.getNombreUsuario());
        usuarioActualizado.setDni(usuarioExistente.getDni());

        // Si la contraseña viene vacía o nula, mantener la existente
        if (usuarioActualizado.getPassword() == null ||
                usuarioActualizado.getPassword().trim().isEmpty()) {
            usuarioActualizado.setPassword(usuarioExistente.getPassword());
        }

        return repo.save(usuarioActualizado);
    }
}