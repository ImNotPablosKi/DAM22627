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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String nombre;

    @ManyToMany(cascade = CascadeType.ALL) // Importante NO usar ALL en ambos lados
    @JoinTable(
            name = "student_curso",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private Set<Curso> cursos = new HashSet<>();



}
