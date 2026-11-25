package org.iesch.ad.ej_consultas.repositorio;

import org.iesch.ad.ej_consultas.dto.ClienteDatos;
import org.iesch.ad.ej_consultas.dto.ClienteResumen;
import org.iesch.ad.ej_consultas.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findDistinctByCochesColorIgnoreCase(String color);

    List<Cliente> findDistinctByCochesPrecioGreaterThan(BigDecimal precio);

    @Query("""
            select new org.iesch.ad.ej_consultas.dto.ClienteDatos(c.nombre, c.nif, c.ciudad)
            from Cliente c
            where not exists (
                select otro.id from Cliente otro
                where (select count(cocheOtro) from Coche cocheOtro where cocheOtro.cliente = otro)
                    > (select count(coche) from Coche coche where coche.cliente = c)
            )
            order by c.nombre, c.id
            """)
    List<ClienteDatos> buscarClientesConMasCoches();

    Optional<Cliente> findByCochesMatricula(String matricula);

    Optional<Cliente> findByCochesRevisionesCodigo(String codigo);

    @Query("""
            select new org.iesch.ad.ej_consultas.dto.ClienteResumen(
                c.id, c.nombre, c.nif, c.direccion, c.ciudad, c.telefono,
                count(distinct coche.matricula), sum(revision.coste))
            from Cliente c
            left join c.coches coche
            left join coche.revisiones revision
            where exists (
                select r.codigo from Revision r
                where r.codigo = :codigo and r.coche.cliente = c
            )
            group by c.id, c.nombre, c.nif, c.direccion, c.ciudad, c.telefono
            """)
    Optional<ClienteResumen> buscarResumenPorCodigoRevision(@Param("codigo") String codigo);
}
