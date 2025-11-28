package com.polideportivo_backend.service.implementation;

import com.polideportivo_backend.model.Usuario;
import com.polideportivo_backend.repository.IGenericRepository;
import com.polideportivo_backend.repository.UsuarioRepository;
import com.polideportivo_backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends GenericService<Usuario, Long> implements UsuarioService {
    private final UsuarioRepository repo;

    @Override
    protected IGenericRepository<Usuario, Long> getRepo() {
        return repo;
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

}