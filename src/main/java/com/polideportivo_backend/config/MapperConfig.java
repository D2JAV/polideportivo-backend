package com.polideportivo_backend.config;

import com.polideportivo_backend.dto.*;
import com.polideportivo_backend.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class MapperConfig {

    @Bean(name = "defaultMapper")
    public ModelMapper defaultMapper() {
        ModelMapper modelMapper = new ModelMapper();
        configureUsuarioMappings(modelMapper);
        configureClienteMappings(modelMapper);
        configureReservaMappings(modelMapper);
        return modelMapper;
    }

    @Bean(name = "usuarioMapper")
    public ModelMapper usuarioMapper() {
        ModelMapper modelMapper = new ModelMapper();
        configureUsuarioMappings(modelMapper);
        return modelMapper;
    }

    @Bean(name = "clienteMapper")
    public ModelMapper clienteMapper() {
        ModelMapper modelMapper = new ModelMapper();
        configureClienteMappings(modelMapper);
        return modelMapper;
    }

    @Bean(name = "reservaMapper")
    public ModelMapper reservaMapper() {
        ModelMapper modelMapper = new ModelMapper();
        configureReservaMappings(modelMapper);
        return modelMapper;
    }

    private void configureUsuarioMappings(ModelMapper modelMapper) {
        // Escritura - UsuarioDTO to Usuario
        modelMapper.createTypeMap(UsuarioDTO.class, Usuario.class)
                .addMapping(UsuarioDTO::getIdUsuario, (Usuario dest, Object v) -> dest.setIdUsuario((Integer) v))
                .addMapping(UsuarioDTO::getNombreUsuario, (Usuario dest, Object v) -> dest.setNombreUsuario((String) v))
                .addMapping(UsuarioDTO::getEmail, (Usuario dest, Object v) -> dest.setEmail((String) v))
                .addMapping(UsuarioDTO::getPassword, (Usuario dest, Object v) -> dest.setPassword((String) v))
                .addMapping(UsuarioDTO::getRol, (Usuario dest, Object v) -> dest.setRol((String) v))
                .addMapping(UsuarioDTO::getNombre, Usuario::setNombre)
                .addMapping(UsuarioDTO::getApellido, (Usuario dest, Object v) -> dest.setApellido((String) v))
                .addMapping(UsuarioDTO::getDni, (Usuario dest, Object v) -> dest.setDni((String) v))
                .addMapping(UsuarioDTO::getTelefono, (Usuario dest, Object v) -> dest.setTelefono((String) v))
                .addMapping(UsuarioDTO::getEstado, (Usuario dest, Object v) -> dest.setEstado((Boolean) v));

        // Lectura - Usuario to UsuarioDTO
        modelMapper.createTypeMap(Usuario.class, UsuarioDTO.class)
                .addMapping(Usuario::getIdUsuario, (UsuarioDTO dest, Object v) -> dest.setIdUsuario((Integer) v))
                .addMapping(Usuario::getNombreUsuario, (UsuarioDTO dest, Object v) -> dest.setNombreUsuario((String) v))
                .addMapping(Usuario::getEmail, (UsuarioDTO dest, Object v) -> dest.setEmail((String) v))
                .addMapping(Usuario::getPassword, (UsuarioDTO dest, Object v) -> dest.setPassword((String) v))
                .addMapping(Usuario::getRol, (UsuarioDTO dest, Object v) -> dest.setRol((String) v))
                .addMapping(Usuario::getNombre, (UsuarioDTO dest, Object v) -> dest.setNombre((String) v))
                .addMapping(Usuario::getApellido, (UsuarioDTO dest, Object v) -> dest.setApellido((String) v))
                .addMapping(Usuario::getDni, (UsuarioDTO dest, Object v) -> dest.setDni((String) v))
                .addMapping(Usuario::getTelefono, (UsuarioDTO dest, Object v) -> dest.setTelefono((String) v))
                .addMapping(Usuario::getEstado, (UsuarioDTO dest, Object v) -> dest.setEstado((Boolean) v))
                .addMapping(Usuario::getFechaRegistro, (UsuarioDTO dest, Object v) -> dest.setFechaRegistro((LocalDateTime) v))
                .addMapping(Usuario::getUltimoLogin, (UsuarioDTO dest, Object v) -> dest.setUltimoLogin((LocalDateTime) v));
    }

    private void configureClienteMappings(ModelMapper modelMapper) {
        // Escritura - ClienteDTO to Cliente
        modelMapper.createTypeMap(ClienteDTO.class, Cliente.class)
                .addMapping(ClienteDTO::getIdCliente, (Cliente dest, Object v) -> dest.setIdCliente((Integer) v))
                .addMapping(ClienteDTO::getNombre, (Cliente dest, Object v) -> dest.setNombre((String) v))
                .addMapping(ClienteDTO::getApellido, (Cliente dest, Object v) -> dest.setApellido((String) v))
                .addMapping(ClienteDTO::getDni, (Cliente dest, Object v) -> dest.setDni((String) v))
                .addMapping(ClienteDTO::getTelefono, (Cliente dest, Object v) -> dest.setTelefono((String) v))
                .addMapping(ClienteDTO::getEmail, (Cliente dest, Object v) -> dest.setEmail((String) v));

        // Lectura - Cliente to ClienteDTO
        modelMapper.createTypeMap(Cliente.class, ClienteDTO.class)
                .addMapping(Cliente::getIdCliente, (ClienteDTO dest, Object v) -> dest.setIdCliente((Integer) v))
                .addMapping(Cliente::getNombre, (ClienteDTO dest, Object v) -> dest.setNombre((String) v))
                .addMapping(Cliente::getApellido, (ClienteDTO dest, Object v) -> dest.setApellido((String) v))
                .addMapping(Cliente::getDni, (ClienteDTO dest, Object v) -> dest.setDni((String) v))
                .addMapping(Cliente::getTelefono, (ClienteDTO dest, Object v) -> dest.setTelefono((String) v))
                .addMapping(Cliente::getEmail, (ClienteDTO dest, Object v) -> dest.setEmail((String) v))
                .addMapping(Cliente::getFechaRegistro, (ClienteDTO dest, Object v) -> dest.setFechaRegistro((LocalDateTime) v))
                .addMapping(src -> src.getUsuario().getIdUsuario(), (ClienteDTO dest, Object v) -> dest.setIdUsuario((Integer) v));
    }

    private void configureReservaMappings(ModelMapper modelMapper) {
        // Escritura - ReservaDTO to Reserva
        modelMapper.createTypeMap(ReservaDTO.class, Reserva.class)
                .addMapping(ReservaDTO::getIdReserva, (Reserva dest, Object v) -> dest.setIdReserva((Integer) v))
                .addMapping(ReservaDTO::getTipoDeporte, (Reserva dest, Object v) -> dest.setTipoDeporte((String) v))
                .addMapping(ReservaDTO::getFechaReserva, (Reserva dest, Object v) -> dest.setFechaReserva((java.time.LocalDate) v))
                .addMapping(ReservaDTO::getHoraInicio, (Reserva dest, Object v) -> dest.setHoraInicio((java.time.LocalTime) v))
                .addMapping(ReservaDTO::getDuracionHoras, (Reserva dest, Object v) -> dest.setDuracionHoras((Double) v))
                .addMapping(ReservaDTO::getMontoTotal, (Reserva dest, Object v) -> dest.setMontoTotal((java.math.BigDecimal) v))
                .addMapping(ReservaDTO::getEstado, (Reserva dest, Object v) -> dest.setEstado((String) v))
                .addMapping(ReservaDTO::getObservaciones, (Reserva dest, Object v) -> dest.setObservaciones((String) v));

        // Lectura - Reserva to ReservaDTO
        modelMapper.createTypeMap(Reserva.class, ReservaDTO.class)
                .addMapping(Reserva::getIdReserva, (ReservaDTO dest, Object v) -> dest.setIdReserva((Integer) v))
                .addMapping(Reserva::getTipoDeporte, (ReservaDTO dest, Object v) -> dest.setTipoDeporte((String) v))
                .addMapping(Reserva::getFechaReserva, (ReservaDTO dest, Object v) -> dest.setFechaReserva((java.time.LocalDate) v))
                .addMapping(Reserva::getHoraInicio, (ReservaDTO dest, Object v) -> dest.setHoraInicio((java.time.LocalTime) v))
                .addMapping(Reserva::getDuracionHoras, (ReservaDTO dest, Object v) -> dest.setDuracionHoras((Double) v))
                .addMapping(Reserva::getMontoTotal, (ReservaDTO dest, Object v) -> dest.setMontoTotal((java.math.BigDecimal) v))
                .addMapping(Reserva::getEstado, (ReservaDTO dest, Object v) -> dest.setEstado((String) v))
                .addMapping(Reserva::getObservaciones, (ReservaDTO dest, Object v) -> dest.setObservaciones((String) v))
                .addMapping(Reserva::getFechaCreacion, (ReservaDTO dest, Object v) -> dest.setFechaCreacion((LocalDateTime) v))
                .addMapping(src -> src.getCliente().getIdCliente(), (ReservaDTO dest, Object v) -> dest.setIdCliente((Integer) v))
                .addMapping(src -> src.getCliente().getNombre(), (ReservaDTO dest, Object v) -> dest.setClienteNombre((String) v))
                .addMapping(src -> src.getCliente().getApellido(), (ReservaDTO dest, Object v) -> dest.setClienteApellido((String) v))
                .addMapping(src -> src.getUsuario().getIdUsuario(), (ReservaDTO dest, Object v) -> dest.setIdUsuario((Integer) v))
                .addMapping(src -> src.getUsuario().getNombre(), (ReservaDTO dest, Object v) -> dest.setUsuarioNombre((String) v));
    }
}