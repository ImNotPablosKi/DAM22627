package org.example.bloque1ej5.repositorio;

import org.example.bloque1ej5.modelo.RegistroVehicular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroVehicularRepositorio extends JpaRepository<RegistroVehicular, Long> {

}
