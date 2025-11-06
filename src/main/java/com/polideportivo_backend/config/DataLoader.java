package com.polideportivo_backend.config;

import com.polideportivo_backend.model.*;
import com.polideportivo_backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final AdministradorRepository administradorRepository;
    private final TrabajadorRepository trabajadorRepository;
    private final ClienteRepository clienteRepository;
    private final CampoRepository campoRepository;
    private final ActividadRepository actividadRepository;

    @Override
    public void run(String... args) throws Exception {
        cargarUsuariosIniciales();
        cargarActividades();
        cargarCampos();
        cargarClientes();
    }

    private void cargarUsuariosIniciales() {
        if (usuarioRepository.count() == 0) {
            // Admin
            Usuario admin = new Usuario();
            admin.setNombreUsuario("admin");
            admin.setCorreo("admin@polideportivo.com");
            admin.setPassword("admin123");
            admin.setRol("ADMIN");
            admin.setNombre("Administrador");
            admin.setApellido("Sistema");
            admin.setDni("00000000");
            admin.setEstado(true);
            usuarioRepository.save(admin);

            Administrador adminEntidad = new Administrador();
            adminEntidad.setUsuario(admin);
            administradorRepository.save(adminEntidad);

            // Trabajador
            Usuario trabajador = new Usuario();
            trabajador.setNombreUsuario("trabajador");
            trabajador.setCorreo("trabajador@polideportivo.com");
            trabajador.setPassword("trabajador123");
            trabajador.setRol("TRABAJADOR");
            trabajador.setNombre("Juan");
            trabajador.setApellido("Pérez");
            trabajador.setDni("11111111");
            trabajador.setEstado(true);
            usuarioRepository.save(trabajador);

            Trabajador trabajadorEntidad = new Trabajador();
            trabajadorEntidad.setUsuario(trabajador);
            trabajadorRepository.save(trabajadorEntidad);
        }
    }

    private void cargarActividades() {
        if (actividadRepository.count() == 0) {
            Actividad futbol = new Actividad();
            futbol.setNombre("FUTBOL");
            futbol.setDescripcion("Fútbol 11 y fútbol 7");
            actividadRepository.save(futbol);

            Actividad voley = new Actividad();
            voley.setNombre("VOLEY");
            voley.setDescripcion("Vóley playa y vóley sala");
            actividadRepository.save(voley);

            Actividad basquet = new Actividad();
            basquet.setNombre("BASQUET");
            basquet.setDescripcion("Básquetbol cancha completa");
            actividadRepository.save(basquet);
        }
    }

    private void cargarCampos() {
        if (campoRepository.count() == 0) {
            Campo campo1 = new Campo();
            campo1.setNombre("Cancha Principal Fútbol");
            campo1.setPrecioPorHora(new BigDecimal("80.00"));
            campo1.setEstado("DISPONIBLE");
            campo1.setDescripcion("Cancha de fútbol 11 con césped natural");
            campoRepository.save(campo1);

            Campo campo2 = new Campo();
            campo2.setNombre("Cancha Auxiliar Fútbol 7");
            campo2.setPrecioPorHora(new BigDecimal("60.00"));
            campo2.setEstado("DISPONIBLE");
            campo2.setDescripcion("Cancha de fútbol 7 con césped sintético");
            campoRepository.save(campo2);

            Campo campo3 = new Campo();
            campo3.setNombre("Cancha Vóley Playa");
            campo3.setPrecioPorHora(new BigDecimal("40.00"));
            campo3.setEstado("DISPONIBLE");
            campo3.setDescripcion("Cancha de vóley playa con arena profesional");
            campoRepository.save(campo3);
        }
    }

    private void cargarClientes() {
        if (clienteRepository.count() == 0) {
            Cliente cliente1 = new Cliente();
            cliente1.setNombre("Carlos");
            cliente1.setApellido("Gómez");
            cliente1.setDni("12345678");
            cliente1.setTelefono("987654321");
            cliente1.setCorreo("carlos@gmail.com");
            clienteRepository.save(cliente1);

            Cliente cliente2 = new Cliente();
            cliente2.setNombre("María");
            cliente2.setApellido("López");
            cliente2.setDni("87654321");
            cliente2.setTelefono("987654322");
            cliente2.setCorreo("maria@gmail.com");
            clienteRepository.save(cliente2);
        }
    }
}