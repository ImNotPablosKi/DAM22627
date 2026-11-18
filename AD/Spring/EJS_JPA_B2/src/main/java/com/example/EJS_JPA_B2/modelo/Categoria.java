package com.example.EJS_JPA_B2.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "categoria")
    List<Libro> libros = new ArrayList<>();

    // Helper
    public void agregarLibro(Libro libro) {

        libros.add(libro);
        libro.setCategoria(this);

    }

    public void quitarLibro(Libro libro) {

        libros.remove(libro);
        libro.setCategoria(null);

    }

}
