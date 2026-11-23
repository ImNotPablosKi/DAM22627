package com.example.EjerciciosConsultas.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nif;
    String nombre;
    String direccion;
    String ciudad;
    String telefono;

    // Este campo apunta al campo cliente de la clase coche
    // Un coche tiene un único dueño, pero un dueño puede tener vario coches a su nombre
    @OneToMany(mappedBy = "cliente")
    List<Coche> coches;

}
