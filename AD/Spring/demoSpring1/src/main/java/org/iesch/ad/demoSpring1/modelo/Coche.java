package org.iesch.ad.demoSpring1.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String marca;
    String mdoelo;
    String matricula;

    @OneToOne(mappedBy = "coche") // Nombre de la variable que hace el mapeo en la relación padre
    @ToString.Exclude
    Persona persona;

}
