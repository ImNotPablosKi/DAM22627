package com.example.EjerciciosConsultas.repositorio;

import com.example.EjerciciosConsultas.modelo.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisionRepositorio extends JpaRepository<Revision, String> {
}
