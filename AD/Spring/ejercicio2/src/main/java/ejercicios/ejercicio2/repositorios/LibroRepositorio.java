package ejercicios.ejercicio2.repositorios;

import ejercicios.ejercicio2.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {
    List<Libro> findByCategoriaId(Long l);
}
