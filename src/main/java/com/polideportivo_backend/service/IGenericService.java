package com.polideportivo_backend.service;

import com.polideportivo_backend.dto.ClienteDTO;
import com.polideportivo_backend.dto.LoginDTO;
import com.polideportivo_backend.dto.ReservaDTO;
import com.polideportivo_backend.dto.UsuarioDTO;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;

public interface IGenericService <T,ID>{
    T save(T t) throws  Exception;
    T update(@Valid Integer t, ReservaDTO id) throws  Exception;
    List<T> findAll() throws  Exception;
    T findById(ID id) throws  Exception;
    void delete(ID id) throws  Exception;

    Object login(@Valid LoginDTO loginDTO);

    void logout(Integer idUsuario);

    List<ClienteDTO> findAllDTO();

    UsuarioDTO findByIdDTO(Integer id);

    UsuarioDTO verifySession(String token);

    Object getLoginHistory(Integer idUsuario);

    UsuarioDTO findByUsername(String username);

    UsuarioDTO saveDTO(@Valid UsuarioDTO dto);

    UsuarioDTO updateDTO(UsuarioDTO dto, @Valid Integer id);

    void changeStatus(Integer id, Boolean estado);

    ClienteDTO findByDni(String dni);

    List<ClienteDTO> findByNombreOrApellido(String nombre, String apellido);

    void changeEstado(Integer id, String estado);

    List<ReservaDTO> findByCliente(Integer idCliente);

    List<ReservaDTO> findByFecha(LocalDate fecha);

    List<ReservaDTO> findByEstado(String estado);

    ReservaDTO cancelarReserva(Integer id);
}
