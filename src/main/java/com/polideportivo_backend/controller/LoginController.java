package com.polideportivo_backend.controller;

import com.polideportivo_backend.dto.LoginDTO;
import com.polideportivo_backend.dto.UsuarioDTO;
import com.polideportivo_backend.service.ILoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    private final ILoginService service;

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@Valid @RequestBody LoginDTO loginDTO) throws Exception {
        UsuarioDTO usuario = (UsuarioDTO) service.login(loginDTO);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/logout/{idUsuario}")
    public ResponseEntity<Void> logout(@PathVariable("idUsuario") Integer idUsuario) throws Exception {
        service.logout(idUsuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/verify-session/{token}")
    public ResponseEntity<UsuarioDTO> verifySession(@PathVariable("token") String token) throws Exception {
        UsuarioDTO usuario = service.verifySession(token);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/login-history/{idUsuario}")
    public ResponseEntity<?> getLoginHistory(@PathVariable("idUsuario") Integer idUsuario) throws Exception {
        return ResponseEntity.ok(service.getLoginHistory(idUsuario));
    }
}