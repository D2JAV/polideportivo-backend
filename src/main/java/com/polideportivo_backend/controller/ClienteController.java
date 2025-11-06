package com.polideportivo_backend.controller;

import com.polideportivo_backend.dto.ClienteDTO;
import com.polideportivo_backend.dto.UsuarioDTO;
import com.polideportivo_backend.service.IClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    private final IClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() throws Exception {
        List<ClienteDTO> list = service.findAllDTO();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable("id") Integer id) throws Exception {
        UsuarioDTO obj = service.findByIdDTO(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<ClienteDTO> findByDni(@PathVariable("dni") String dni) throws Exception {
        ClienteDTO obj = service.findByDni(dni);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ClienteDTO>> findByNombreOrApellido(
            @RequestParam String nombre,
            @RequestParam String apellido) throws Exception {
        List<ClienteDTO> list = service.findByNombreOrApellido(nombre, apellido);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@RequestBody @Valid UsuarioDTO dto) throws Exception {
        UsuarioDTO obj = service.saveDTO(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCliente()).toUri();
        return ResponseEntity.created(location).body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody UsuarioDTO dto) throws Exception {
        dto.setIdCliente(id);
        UsuarioDTO obj = service.updateDTO(dto, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}