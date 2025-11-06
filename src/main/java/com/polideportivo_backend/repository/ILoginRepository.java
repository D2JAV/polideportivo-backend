package com.polideportivo_backend.repository;

import com.polideportivo_backend.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ILoginRepository  extends JpaRepository<Login, Integer> {
    List<?> findByUsuarioIdUsuarioOrderByFechaLoginDesc(Integer idUsuario);

    List<Login> findByUsuarioIdUsuarioAndFechaExpiracionAfter(Integer idUsuario, LocalDateTime now);


    // Métodos personalizados si los necesitas
}