package com.polideportivo_backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "campos")
public class Campo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCampo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(name = "precio_por_hora", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioPorHora;

    @Column(length = 20)
    private String estado = "DISPONIBLE";

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    public Long getIdCampo() { return idCampo; }
    public void setIdCampo(Long idCampo) { this.idCampo = idCampo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public BigDecimal getPrecioPorHora() { return precioPorHora; }
    public void setPrecioPorHora(BigDecimal precioPorHora) { this.precioPorHora = precioPorHora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}