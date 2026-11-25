package org.iesch.ad.ej_consultas.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {
    @Id
    private Long id;
    @Column(nullable = false)
    private String nif;
    @Column(nullable = false)
    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;
    @OneToMany(mappedBy = "cliente")
    private List<Coche> coches = new ArrayList<>();

    protected Cliente() {
    }

    public Long getId() { return id; }
    public String getNif() { return nif; }
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getCiudad() { return ciudad; }
    public String getTelefono() { return telefono; }
    public List<Coche> getCoches() { return coches; }
}
