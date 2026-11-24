package ejercicios.consultas.Repositorios;

import ejercicios.consultas.Modelos.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisionRepositorio extends JpaRepository<Revision, String> {

}
