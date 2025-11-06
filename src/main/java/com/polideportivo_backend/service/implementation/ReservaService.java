package com.polideportivo_backend.service.implementation;

import com.polideportivo_backend.dto.ClienteDTO;
import com.polideportivo_backend.dto.LoginDTO;
import com.polideportivo_backend.dto.ReservaDTO;
import com.polideportivo_backend.dto.UsuarioDTO;
import com.polideportivo_backend.model.Reserva;
import com.polideportivo_backend.repository.IGenericRepository;
import com.polideportivo_backend.service.IReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService extends GenericService<Reserva, Integer> implements IReservaService {

    private final IGenericRepository<Reserva, Integer> repo;

    @Override
    protected IGenericRepository<Reserva, Integer> getRepo() {
        return repo;
    }

    @Override
    public Reserva update(Integer t, ReservaDTO id) throws Exception {
        return null;
    }

    @Override
    public Object login(LoginDTO loginDTO) {
        return null;
    }

    @Override
    public void logout(Integer idUsuario) {

    }

    @Override
    public List<ClienteDTO> findAllDTO() {
        return List.of();
    }

    @Override
    public UsuarioDTO findByIdDTO(Integer id) {
        return null;
    }

    @Override
    public UsuarioDTO verifySession(String token) {
        return null;
    }

    @Override
    public Object getLoginHistory(Integer idUsuario) {
        return null;
    }

    @Override
    public UsuarioDTO findByUsername(String username) {
        return null;
    }

    @Override
    public UsuarioDTO saveDTO(@Valid UsuarioDTO dto) {
        return null;
    }

    @Override
    public UsuarioDTO updateDTO(UsuarioDTO dto, Integer id) {
        return null;
    }

    @Override
    public void changeStatus(Integer id, Boolean estado) {

    }

    @Override
    public ClienteDTO findByDni(String dni) {
        return null;
    }

    @Override
    public List<ClienteDTO> findByNombreOrApellido(String nombre, String apellido) {
        return List.of();
    }

    @Override
    public void changeEstado(Integer id, String estado) {

    }

    @Override
    public List<ReservaDTO> findByCliente(Integer idCliente) {
        return List.of();
    }

    @Override
    public List<ReservaDTO> findByFecha(LocalDate fecha) {
        return List.of();
    }

    @Override
    public List<ReservaDTO> findByEstado(String estado) {
        return List.of();
    }

    @Override
    public ReservaDTO cancelarReserva(Integer id) {
        return null;
    }

    @Override
    public ReservaDTO confirmarReserva(Integer id) {
        return null;
    }
}