package org.example.bloque1ej5.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;

    private String modelo;

    private String matricula;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registro_vehicular_id", nullable = false, unique = true)
    private RegistroVehicular registroVehicular;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public RegistroVehicular getRegistroVehicular() {
        return registroVehicular;
    }

    public void setRegistroVehicular(RegistroVehicular registroVehicular) {
        this.registroVehicular = registroVehicular;
    }
}
