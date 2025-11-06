package com.polideportivo_backend.service;

import com.polideportivo_backend.dto.ReservaDTO;
import com.polideportivo_backend.model.Reserva;

public interface IReservaService extends IGenericService<Reserva, Integer> {
    ReservaDTO confirmarReserva(Integer id);
    // Solo métodos CRUD básicos aquí
}