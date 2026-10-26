package org.iesch.ad.demoSpring1.repository;

import org.iesch.ad.demoSpring1.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query("select p from Persona p") // HQL
    List<Persona> buscaTodasPersonas();

    @NativeQuery("select * from Persona p") // SQL
    List<Persona> buscaTodasPersonasNative();

    List<Persona> findByNombreStartingWith(char c);

    List<Persona> findByDniContainingAndApellidosContaining(char c, String s);

    // DNI con un 9 o email nulo
    List<Persona> findByDniContainingOrEmailNull(String num);

}
