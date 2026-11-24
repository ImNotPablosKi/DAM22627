package com.example.EjerciciosConsultas.repositorio;

import com.example.EjerciciosConsultas.modelo.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocheRepositorio extends JpaRepository<Coche, Long> {

    @Query("SELECT c FROM Coche c ORDER BY SIZE(c.revisiones) ASC LIMIT 1")
    Coche cocheConMenosRevisiones();

    @Query("SELECT c.matricula, SIZE(c.revisiones) FROM Coche c")
    List<String> cochesJuntoARevisiones();

}
