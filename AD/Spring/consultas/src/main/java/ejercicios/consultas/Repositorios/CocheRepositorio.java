package ejercicios.consultas.Repositorios;

import ejercicios.consultas.Modelos.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepositorio extends JpaRepository<Coche, String> {

}
