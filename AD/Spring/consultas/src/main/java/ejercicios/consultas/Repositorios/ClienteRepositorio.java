package ejercicios.consultas.Repositorios;

import ejercicios.consultas.Modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    List<Cliente> findDistinctByCochesColorIgnoreCase(String color);

    List<Cliente> findDistinctByCochesPrecioGreaterThan(BigDecimal precio);

    List<Cliente> seleccionarClienteConMasCoches();
}
