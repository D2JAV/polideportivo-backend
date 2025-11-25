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
            System.out.println("👤 Cargando usuarios iniciales...");

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

            System.out.println("✅ Usuarios cargados: " + usuarioRepository.count());
        }
    }

    private void cargarActividades() {
        if (actividadRepository.count() == 0) {
            System.out.println("⚽ Cargando actividades...");

            Actividad futbol = new Actividad();
            futbol.setNombre("FUTBOL");
            futbol.setDescripcion("Fútbol 11 y fútbol 7");
            actividadRepository.save(futbol);

            Actividad voley = new Actividad();
            voley.setNombre("VOLEY");
            voley.setDescripcion("Vóley playa y vóley sala");
            actividadRepository.save(voley);

            System.out.println("✅ Actividades cargadas: " + actividadRepository.count());
        }
    }

    private void cargarCampos() {
        if (campoRepository.count() == 0) {
            System.out.println("🏟️ Cargando campos...");

            // Campos de FÚTBOL
            Campo campoFutbol1 = new Campo();
            campoFutbol1.setNombre("Cancha Principal Fútbol");
            campoFutbol1.setPrecioPorHora(new BigDecimal("80.00"));
            campoFutbol1.setEstado("DISPONIBLE");
            campoFutbol1.setDescripcion("Cancha de fútbol 11 con césped natural");
            campoRepository.save(campoFutbol1);

            Campo campoFutbol2 = new Campo();
            campoFutbol2.setNombre("Cancha Auxiliar Fútbol 7");
            campoFutbol2.setPrecioPorHora(new BigDecimal("60.00"));
            campoFutbol2.setEstado("DISPONIBLE");
            campoFutbol2.setDescripcion("Cancha de fútbol 7 con césped sintético");
            campoRepository.save(campoFutbol2);

            // Campos de VÓLEY
            Campo campoVoley1 = new Campo();
            campoVoley1.setNombre("Cancha Vóley Playa 1");
            campoVoley1.setPrecioPorHora(new BigDecimal("40.00"));
            campoVoley1.setEstado("DISPONIBLE");
            campoVoley1.setDescripcion("Cancha de vóley playa profesional");
            campoRepository.save(campoVoley1);

            Campo campoVoley2 = new Campo();
            campoVoley2.setNombre("Cancha Vóley Sala");
            campoVoley2.setPrecioPorHora(new BigDecimal("35.00"));
            campoVoley2.setEstado("DISPONIBLE");
            campoVoley2.setDescripcion("Cancha de vóley sala techada");
            campoRepository.save(campoVoley2);

            System.out.println("✅ Campos cargados: " + campoRepository.count());
        }
    }

    private void cargarClientes() {
        if (clienteRepository.count() == 0) {
            System.out.println("👥 Cargando clientes...");

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

            Cliente cliente3 = new Cliente();
            cliente3.setNombre("Roberto");
            cliente3.setApellido("Silva");
            cliente3.setDni("11223344");
            cliente3.setTelefono("987654323");
            cliente3.setCorreo("roberto@gmail.com");
            clienteRepository.save(cliente3);

            System.out.println("✅ Clientes cargados: " + clienteRepository.count());
        }
    }
}