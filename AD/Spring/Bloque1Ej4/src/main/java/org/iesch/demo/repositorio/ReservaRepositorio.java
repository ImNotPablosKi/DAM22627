package org.iesch.demo.repositorio;

import org.iesch.demo.modelo.Habitacion;
import org.iesch.demo.modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {

     Optional<List<Reserva>> findByhabitacion_Id (Long id);
     Optional<List<Reserva>> findByFechaEntradaBetween(LocalDate incio, LocalDate fin);

}
