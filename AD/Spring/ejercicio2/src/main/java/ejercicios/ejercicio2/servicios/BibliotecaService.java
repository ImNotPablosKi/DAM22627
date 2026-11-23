package ejercicios.ejercicio2.servicios;

import ejercicios.ejercicio2.modelos.Categoria;
import ejercicios.ejercicio2.modelos.Libro;
import ejercicios.ejercicio2.repositorios.CategoriaRepositorio;
import ejercicios.ejercicio2.repositorios.LibroRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaService {

    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    @Autowired
    LibroRepositorio libroRepositorio;

    public Categoria crearCategoria(String s) {
        Categoria categoria = Categoria.builder().nombre(s).build();
        return categoriaRepositorio.save(categoria);
    }

    public Libro crearLibro(String titulo, String autor, long l) {
        Libro libro = Libro.builder().titulo(titulo).autor(autor).categoria(categoriaRepositorio.findById(l).orElseThrow(()->new IllegalArgumentException("No existe la catrgoría "+l))).build();
        return libroRepositorio.save(libro);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepositorio.findAll();
    }

    public List<Libro> listarLibros(Long catId) {
        return catId == null ? libroRepositorio.findAll() : libroRepositorio.findByCategoriaId(catId);
    }

    @Transactional
    public void borrarLibro(long l) {
        Libro libro = libroRepositorio.findById(l).orElseThrow(()->new IllegalArgumentException("No existe el libro con id "+l));
        libroRepositorio.delete(libro);
    }

    @Transactional
    public void borrarCategoria(long l) {
        Categoria categoria = categoriaRepositorio.findById(l).orElseThrow(()->new IllegalArgumentException("No existe la categoria con id "+l));
        categoriaRepositorio.delete(categoria);
    }

    public void cambiarCategoria(Long libro, long l) {
        Libro libro1 = libroRepositorio.findById(libro).orElseThrow(()->new IllegalArgumentException("No existe el libro con id "+libro));

        libro1.setCategoria(categoriaRepositorio.findById(l).orElseThrow(()->new IllegalArgumentException("No existe el libro con id "+libro)));

        libroRepositorio.save(libro1);

    }
}
