package org.iesch.BasicosEj2.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.iesch.BasicosEj2.modelos.Categoria;
import org.iesch.BasicosEj2.modelos.Libro;
import org.iesch.BasicosEj2.repositorios.CategoriaRepository;
import org.iesch.BasicosEj2.repositorios.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BibliotecaService {

    @Autowired
    LibroRepository libroRepository;

    @Autowired
    CategoriaRepository categoriaRepository;


    public void crearCategoria(String s) {
        Categoria temp = Categoria.builder().nombre(s).build();
        categoriaRepository.save(temp);
        System.out.println("Categoria guardada exitosamente");
    }

    public void crearLibro(String titulo, String autor, long l) {

        Optional<Categoria> temp = categoriaRepository.findById(l);

        if (!temp.isPresent()){
            System.out.println("No existe dicha categoria");
        } else {
            Categoria real = temp.get();
            Libro tempLibro = Libro.builder().titulo(titulo).categoria(real).build();
            libroRepository.save(tempLibro);
            System.out.println("Libro guardado satisfactoriamente");
        }
    }

    public List<Categoria> listarCategorias() {

        List<Categoria> listaCategoriasTotales = categoriaRepository.findAll();
        return listaCategoriasTotales;

    }

    public List<Libro> listarLibros(Long aLong) {

        List<Libro> listaLibrosTotales = libroRepository.findAll();
        return listaLibrosTotales;

    }

    public void borrarLibro(long l) {
        Optional<Libro> tempLibro = libroRepository.findById(l);
        if (!tempLibro.isPresent()){
            System.out.println("El libro no existe");
        } else {
            libroRepository.delete(tempLibro.get());
            System.out.println("Libro borrado correctamente");
        }

    }

    @Transactional
    public void borrarCategoria(long l) {
        Optional<Categoria> tempCategoria = categoriaRepository.findById(l);
        if (!tempCategoria.isPresent()){
            System.out.println("La categoria no existe");
        } else {

            if (!tempCategoria.get().getLibros().isEmpty()){
                System.out.println("Hay libros en la categoria que impiden el borrado");
            } else {
                categoriaRepository.delete(tempCategoria.get());
                System.out.println("Categoria borrada correctamente");
            }

        }
    }

    public void cambiarCategoria(Long libro, long l) {
        Optional<Libro> tempLibro = libroRepository.findById(libro);
        if (!tempLibro.isPresent()){
            System.out.println("Libro no encontrado");
        } else {

            Optional<Categoria> categoriaTemp = categoriaRepository.findById(l);
            if (!categoriaTemp.isPresent()){
                System.out.println("Categoria no encontrada");
            } else {
                Libro libroReal = tempLibro.get();
                Categoria categoria = categoriaTemp.get();
                libroReal.setCategoria(categoria);
                libroRepository.save(libroReal);
                System.out.println("Categoria cambiada correctamente");
            }
        }

    }
}
