package com.example.EjerciciosConsultas.repositorio;

import com.example.EjerciciosConsultas.modelo.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepositorio extends JpaRepository<Coche, Long> {
}
