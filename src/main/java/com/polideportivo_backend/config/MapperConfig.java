package com.polideportivo_backend.config;

import com.polideportivo_backend.dto.*;
import com.polideportivo_backend.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper defaultMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Configurar mapeos personalizados para relaciones
        configureReservaMappings(modelMapper);
        configurePagoMappings(modelMapper);
        configureUsuarioMappings(modelMapper);

        return modelMapper;
    }

    private void configureReservaMappings(ModelMapper modelMapper) {
        // ReservaDTO -> Reserva (Escritura)
        modelMapper.createTypeMap(ReservaDTO.class, Reserva.class)
                .addMapping(ReservaDTO::getIdReserva, Reserva::setIdReserva)
                .addMapping(ReservaDTO::getFechaReserva, Reserva::setFechaReserva)
                .addMapping(ReservaDTO::getHoraInicio, Reserva::setHoraInicio)
                .addMapping(ReservaDTO::getDuracionHoras, Reserva::setDuracionHoras)
                .addMapping(ReservaDTO::getMontoTotal, Reserva::setMontoTotal)
                .addMapping(ReservaDTO::getEstado, Reserva::setEstado)
                .addMapping(ReservaDTO::getFechaCreacion, Reserva::setFechaCreacion);

        // Reserva -> ReservaDTO (Lectura)
        modelMapper.createTypeMap(Reserva.class, ReservaDTO.class)
                .addMapping(Reserva::getIdReserva, ReservaDTO::setIdReserva)
                .addMapping(Reserva::getFechaReserva, ReservaDTO::setFechaReserva)
                .addMapping(Reserva::getHoraInicio, ReservaDTO::setHoraInicio)
                .addMapping(Reserva::getDuracionHoras, ReservaDTO::setDuracionHoras)
                .addMapping(Reserva::getMontoTotal, ReservaDTO::setMontoTotal)
                .addMapping(Reserva::getEstado, ReservaDTO::setEstado)
                .addMapping(Reserva::getFechaCreacion, ReservaDTO::setFechaCreacion);
    }

    private void configurePagoMappings(ModelMapper modelMapper) {
        // PagoDTO -> Pago (Escritura)
        modelMapper.createTypeMap(PagoDTO.class, Pago.class)
                .addMapping(PagoDTO::getIdPago, Pago::setIdPago)
                .addMapping(PagoDTO::getFechaPago, Pago::setFechaPago)
                .addMapping(PagoDTO::getMontoPagado, Pago::setMontoPagado)
                .addMapping(PagoDTO::getMetodoPago, Pago::setMetodoPago)
                .addMapping(PagoDTO::getReferencia, Pago::setReferencia)
                .addMapping(PagoDTO::getEstadoPago, Pago::setEstadoPago)
                .addMapping(PagoDTO::getObservaciones, Pago::setObservaciones);

        // Pago -> PagoDTO (Lectura)
        modelMapper.createTypeMap(Pago.class, PagoDTO.class)
                .addMapping(Pago::getIdPago, PagoDTO::setIdPago)
                .addMapping(Pago::getFechaPago, PagoDTO::setFechaPago)
                .addMapping(Pago::getMontoPagado, PagoDTO::setMontoPagado)
                .addMapping(Pago::getMetodoPago, PagoDTO::setMetodoPago)
                .addMapping(Pago::getReferencia, PagoDTO::setReferencia)
                .addMapping(Pago::getEstadoPago, PagoDTO::setEstadoPago)
                .addMapping(Pago::getObservaciones, PagoDTO::setObservaciones);
    }

    private void configureUsuarioMappings(ModelMapper modelMapper) {
        // UsuarioDTO -> Usuario (Escritura)
        modelMapper.createTypeMap(UsuarioDTO.class, Usuario.class)
                .addMapping(UsuarioDTO::getIdUsuario, Usuario::setIdUsuario)
                .addMapping(UsuarioDTO::getNombreUsuario, Usuario::setNombreUsuario)
                .addMapping(UsuarioDTO::getCorreo, Usuario::setCorreo)
                .addMapping(UsuarioDTO::getPassword, Usuario::setPassword)
                .addMapping(UsuarioDTO::getFechaCreacion, Usuario::setFechaCreacion)
                .addMapping(UsuarioDTO::getRol, Usuario::setRol)
                .addMapping(UsuarioDTO::getDni, Usuario::setDni)
                .addMapping(UsuarioDTO::getTelefono, Usuario::setTelefono)
                .addMapping(UsuarioDTO::getNombre, Usuario::setNombre)
                .addMapping(UsuarioDTO::getApellido, Usuario::setApellido)
                .addMapping(UsuarioDTO::getEstado, Usuario::setEstado);

        // Usuario -> UsuarioDTO (Lectura)
        modelMapper.createTypeMap(Usuario.class, UsuarioDTO.class)
                .addMapping(Usuario::getIdUsuario, UsuarioDTO::setIdUsuario)
                .addMapping(Usuario::getNombreUsuario, UsuarioDTO::setNombreUsuario)
                .addMapping(Usuario::getCorreo, UsuarioDTO::setCorreo)
                .addMapping(Usuario::getPassword, UsuarioDTO::setPassword)
                .addMapping(Usuario::getFechaCreacion, UsuarioDTO::setFechaCreacion)
                .addMapping(Usuario::getRol, UsuarioDTO::setRol)
                .addMapping(Usuario::getDni, UsuarioDTO::setDni)
                .addMapping(Usuario::getTelefono, UsuarioDTO::setTelefono)
                .addMapping(Usuario::getNombre, UsuarioDTO::setNombre)
                .addMapping(Usuario::getApellido, UsuarioDTO::setApellido)
                .addMapping(Usuario::getEstado, UsuarioDTO::setEstado);
    }
}