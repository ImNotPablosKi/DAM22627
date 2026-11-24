package com.example.EjerciciosConsultas.modelo;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Revision {

    @Id
    String codigo;

    boolean cambio_filtro;
    boolean cambio_aceite;
    double coste;

    @Override
    public String toString() {
        return "Revision{" +
                "codigo='" + codigo + '\'' +
                ", cambio_filtro=" + cambio_filtro +
                ", cambio_aceite=" + cambio_aceite +
                ", coste=" + coste +
                ", coche=" + coche.getMatricula() +
                '}';
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "coche_id")
    Coche coche;

}
