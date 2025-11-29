package com.polideportivo_backend.controller;

import com.polideportivo_backend.dto.CredencialesDTO;
import com.polideportivo_backend.dto.UsuarioDTO;
import com.polideportivo_backend.dto.UsuarioUpdateDTO;
import com.polideportivo_backend.model.Usuario;
import com.polideportivo_backend.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> list = usuarioService.findAll().stream()
                .map(this::convertToDto).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        return usuarioService.findById(id)
                .map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO dto) {
        Usuario obj = usuarioService.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdUsuario()).toUri();
        return ResponseEntity.created(location).body(convertToDto(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @Valid @RequestBody UsuarioUpdateDTO dto) {
        // Convertir UsuarioUpdateDTO a Usuario
        Usuario usuarioActualizado = new Usuario();
        usuarioActualizado.setNombre(dto.getNombre());
        usuarioActualizado.setApellido(dto.getApellido());
        usuarioActualizado.setRol(dto.getRol());
        usuarioActualizado.setTelefono(dto.getTelefono());
        usuarioActualizado.setEstado(dto.getEstado());
        usuarioActualizado.setPassword(dto.getPassword());

        Usuario obj = usuarioService.update(id, usuarioActualizado);
        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<UsuarioDTO> findByCorreo(@PathVariable String correo) {
        return usuarioService.findByCorreo(correo)
                .map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/validar")
    public ResponseEntity<UsuarioDTO> validar(@RequestBody CredencialesDTO credencialesDTO) {
        return usuarioService.validar(credencialesDTO.getCorreo(),credencialesDTO.getPassword())
                .map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    private UsuarioDTO convertToDto(Usuario obj){
        return modelMapper.map(obj, UsuarioDTO.class);
    }

    // Convertir de un DTO a un Modelo (Entity)
    private Usuario convertToEntity(UsuarioDTO dto){
        return modelMapper.map(dto, Usuario.class);
    }

}