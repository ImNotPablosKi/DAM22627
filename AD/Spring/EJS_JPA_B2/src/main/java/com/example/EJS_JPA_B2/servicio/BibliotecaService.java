package com.example.EJS_JPA_B2.servicio;

import com.example.EJS_JPA_B2.modelo.Categoria;
import com.example.EJS_JPA_B2.modelo.Libro;
import com.example.EJS_JPA_B2.repositorio.CategoriaRepository;
import com.example.EJS_JPA_B2.repositorio.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    CategoriaRepository categoriaRepositorio;
    LibroRepository libroRepositorio;

    public BibliotecaService(CategoriaRepository categoriaRepositorio, LibroRepository libroRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
        this.libroRepositorio = libroRepositorio;
    }

    public Categoria crearCategoria(String nombre) {

        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);

        return categoriaRepositorio.save(categoria);

    }

    @Transactional
    public Libro crearLibro(String titulo, String autor, long categoriaId) {

        Categoria categoria = buscarCategoria(categoriaId);
        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        categoria.agregarLibro(libro);

        return libroRepositorio.save(libro);
    }

    private Categoria buscarCategoria(long categoriaId) {

        return categoriaRepositorio.findById(categoriaId).orElseThrow(
                () -> new IllegalArgumentException("No existe la categoría " + categoriaId)
        );

    }

    public List<Categoria> listarCategorias() {

        return null; // ToDO

    }

    public List<Libro> listarLibros(Long categoriaId) {

        return categoriaId == null ? libroRepositorio.findAll() : libroRepositorio.findByCategoriaId(categoriaId);

    }

    @Transactional
    public void borrarLibro(long id) {

        Libro libro = libroRepositorio.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No existe el libro con id:  " + id)
        );

        libroRepositorio.delete(libro);

    }

    @Transactional
    public void cambiarCategoria(Long libro, long id) {

        Categoria categoria = buscarCategoria(id);

        if (libroRepositorio.existsByCategoriaId(id)) {

            throw new IllegalStateException("No se puede borrar una categoría con libros");

        }

        categoriaRepositorio.delete(categoria);

    }

    public void borrarCategoria(long l) {



    }
}
