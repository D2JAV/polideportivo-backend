package com.polideportivo_backend.controller;

import com.polideportivo_backend.dto.ClienteDTO;
import com.polideportivo_backend.dto.UsuarioDTO;
import com.polideportivo_backend.service.IUsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final IUsuarioService service;

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

    @GetMapping("/username/{username}")
    public ResponseEntity<UsuarioDTO> findByUsername(@PathVariable("username") String username) throws Exception {
        UsuarioDTO obj = service.findByUsername(username);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO dto) throws Exception {
        UsuarioDTO obj = service.saveDTO(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUsuario()).toUri();
        return ResponseEntity.created(location).body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody UsuarioDTO dto) throws Exception {
        dto.setIdUsuario(id);
        UsuarioDTO obj = service.updateDTO(dto, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Void> changeStatus(@PathVariable("id") Integer id, @RequestParam Boolean estado) throws Exception {
        service.changeStatus(id, estado);
        return ResponseEntity.ok().build();
    }
}