package com.polideportivo_backend.repository;

import com.polideportivo_backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    Optional<Usuario> findByDni(String dni);
    Boolean existsByCorreo(String correo);
    Boolean existsByNombreUsuario(String nombreUsuario);
}