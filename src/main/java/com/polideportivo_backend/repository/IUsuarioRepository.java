package com.polideportivo_backend.repository;

import com.polideportivo_backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IUsuarioRepository  extends JpaRepository<Usuario, Integer> {
    // Métodos personalizados si los necesitas
}