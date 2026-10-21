package org.iesch.ad.demoSpring1.modelo;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Persona {


    @Id // Para indicar la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para que sea autoincremental
    Long id;

    String nombre;
    String apellidos;

    @Column(length = 9)
    String dni;
    String email;

}
