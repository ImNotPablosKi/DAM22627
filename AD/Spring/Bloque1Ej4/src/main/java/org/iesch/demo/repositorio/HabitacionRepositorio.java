package org.iesch.demo.repositorio;

import org.iesch.demo.modelo.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface HabitacionRepositorio extends JpaRepository<Habitacion, Long> {
    // Metodo para consultar por nombre
    Optional<Habitacion> findByNumero(int nombre);
}
