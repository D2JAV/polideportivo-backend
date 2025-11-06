package com.polideportivo_backend.config;

import com.polideportivo_backend.model.*;
import com.polideportivo_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private IReservaRepository reservaRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUsuarios();
        loadClientes();
        loadReservas();
    }

    private void loadUsuarios() {
        if (usuarioRepository.count() == 0) {
            System.out.println("📦 Cargando usuarios...");

            Usuario admin = new Usuario();
            admin.setNombreUsuario("admin");
            admin.setEmail("admin@polideportivo.com");
            admin.setPassword("admin123");
            admin.setRol("ADMIN");
            admin.setNombre("Admin");
            admin.setApellido("Principal");
            admin.setDni("12345678");
            admin.setTelefono("999888777");
            admin.setEstado(true);
            admin.setFechaRegistro(LocalDateTime.now());
            admin.setUltimoLogin(LocalDateTime.now());
            usuarioRepository.save(admin);

            Usuario trabajador = new Usuario();
            trabajador.setNombreUsuario("trabajador");
            trabajador.setEmail("trabajador@polideportivo.com");
            trabajador.setPassword("trab123");
            trabajador.setRol("TRABAJADOR");
            trabajador.setNombre("Juan");
            trabajador.setApellido("Pérez");
            trabajador.setDni("87654321");
            trabajador.setTelefono("999888666");
            trabajador.setEstado(true);
            trabajador.setFechaRegistro(LocalDateTime.now());
            trabajador.setUltimoLogin(LocalDateTime.now());
            usuarioRepository.save(trabajador);

            System.out.println("✅ Usuarios cargados: " + usuarioRepository.count());
        }
    }

    private void loadClientes() {
        if (clienteRepository.count() == 0) {
            System.out.println("📦 Cargando clientes...");

            Usuario usuarioAdmin = usuarioRepository.findAll().get(0);

            Cliente cliente1 = new Cliente();
            cliente1.setUsuario(usuarioAdmin);
            cliente1.setNombre("Carlos");
            cliente1.setApellido("López");
            cliente1.setDni("11111111");
            cliente1.setTelefono("999888555");
            cliente1.setEmail("carlos@email.com");
            cliente1.setFechaRegistro(LocalDateTime.now());
            clienteRepository.save(cliente1);

            Cliente cliente2 = new Cliente();
            cliente2.setUsuario(usuarioAdmin);
            cliente2.setNombre("Ana");
            cliente2.setApellido("Martínez");
            cliente2.setDni("22222222");
            cliente2.setTelefono("999888333");
            cliente2.setEmail("ana@email.com");
            cliente2.setFechaRegistro(LocalDateTime.now());
            clienteRepository.save(cliente2);

            System.out.println("✅ Clientes cargados: " + clienteRepository.count());
        }
    }

    private void loadReservas() {
        if (reservaRepository.count() == 0) {
            System.out.println("📦 Cargando reservas...");

            Cliente cliente1 = clienteRepository.findAll().get(0);
            Usuario trabajador = usuarioRepository.findAll().get(1);

            Reserva reserva1 = new Reserva();
            reserva1.setCliente(cliente1);
            reserva1.setUsuario(trabajador);
            reserva1.setTipoDeporte("FUTBOL");
            reserva1.setFechaReserva(LocalDate.now().plusDays(1));
            reserva1.setHoraInicio(LocalTime.of(10, 0));
            reserva1.setDuracionHoras(2.0);
            reserva1.setMontoTotal(new BigDecimal("100.00"));
            reserva1.setEstado("CONFIRMADA");
            reserva1.setObservaciones("Partido amistoso");
            reserva1.setFechaCreacion(LocalDateTime.now());
            reservaRepository.save(reserva1);




            System.out.println("✅ Reservas cargadas: " + reservaRepository.count());
        }
    }
}