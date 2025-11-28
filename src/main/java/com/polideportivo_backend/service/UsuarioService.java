package com.polideportivo_backend.service;

import com.polideportivo_backend.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    Usuario update(Long id, Usuario usuario);
    void deleteById(Long id);
    Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    Boolean existsByCorreo(String correo);
    Boolean existsByNombreUsuario(String nombreUsuario);

    Optional<Usuario> validar (String correo, String password);
}