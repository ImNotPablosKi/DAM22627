package com.example.EjerciciosConsultas.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coche {

    @Id
    String matricula;

    String marca;
    String modelo;
    String color;
    Double precio;

    @ManyToOne(optional = false)
    Cliente cliente;

    @OneToMany(mappedBy = "coche")
    List<Revision> revisiones;

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", cliente=" + cliente.getNombre() +
                ", revisiones=" + revisiones +
                '}';
    }
}
