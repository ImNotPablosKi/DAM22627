package org.iesch.ad.ej_consultas.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Coche {
    @Id
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    @Column(precision = 12, scale = 2)
    private BigDecimal precio;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    @OneToMany(mappedBy = "coche")
    private List<Revision> revisiones = new ArrayList<>();

    protected Coche() {
    }

    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getColor() { return color; }
    public BigDecimal getPrecio() { return precio; }
    public Cliente getCliente() { return cliente; }
    public List<Revision> getRevisiones() { return revisiones; }
}
