package com.example.EJS_JPA_B2.repositorio;

import com.example.EJS_JPA_B2.modelo.Categoria;
import com.example.EJS_JPA_B2.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {


    List<Libro> findByCategoriaId(Long categoriaId);

    boolean existsByCategoriaId(long id);
}
