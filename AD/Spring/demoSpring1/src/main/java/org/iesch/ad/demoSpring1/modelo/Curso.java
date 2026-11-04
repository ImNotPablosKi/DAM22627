package org.iesch.ad.demoSpring1.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String nombre;

    @ToString.Exclude // Evitar stackoverflow
    @ManyToMany(mappedBy = "cursos") // nombre de la variable de la otra entidad
    // @ManyToMany(cascade = CascadeType.ALL, mappedBy = "cursos") <-- Peligroso, se puede dar el caso de que borres al padre (student)
    // Y tambien al resto del curso del estudiante
    // Se recomienda: CascadeType.PERSIST y MERGE
    // Con persist al guardar se guardaria el padre. Con Merge al actualizar
    private Set<Student> students = new HashSet<>();

}
