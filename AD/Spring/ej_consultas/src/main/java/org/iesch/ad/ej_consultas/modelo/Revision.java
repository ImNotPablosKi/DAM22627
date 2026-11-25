package org.iesch.ad.ej_consultas.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class Revision {
    @Id
    private String codigo;
    private boolean cambioFiltro;
    private boolean cambioAceite;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal coste;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "coche_id", nullable = false)
    private Coche coche;

    protected Revision() {
    }

    public String getCodigo() { return codigo; }
    public boolean isCambioFiltro() { return cambioFiltro; }
    public boolean isCambioAceite() { return cambioAceite; }
    public BigDecimal getCoste() { return coste; }
    public Coche getCoche() { return coche; }
}
