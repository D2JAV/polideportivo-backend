package com.polideportivo_backend.service;

import com.polideportivo_backend.dto.ClienteDTO;
import com.polideportivo_backend.model.Usuario;

import java.util.List;

public interface IUsuarioService extends IGenericService<Usuario, Integer> {
    List<ClienteDTO> findAllDTO();
    // Solo métodos específicos si los necesitas
    // Los métodos DTO van en una interfaz separada como IProductService
}