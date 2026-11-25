package org.iesch.ad.ej_consultas.repositorio;

import org.iesch.ad.ej_consultas.dto.CocheRevisiones;
import org.iesch.ad.ej_consultas.modelo.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CocheRepository extends JpaRepository<Coche, String> {
    @Query("""
            select c from Coche c
            where not exists (
                select otro.matricula from Coche otro
                where (select count(rOtro) from Revision rOtro where rOtro.coche = otro)
                    < (select count(r) from Revision r where r.coche = c)
            )
            order by c.matricula
            """)
    List<Coche> buscarCochesConMenosRevisiones();

    @Query("""
            select new org.iesch.ad.ej_consultas.dto.CocheRevisiones(c.matricula, count(r))
            from Coche c left join c.revisiones r
            group by c.matricula
            order by c.matricula
            """)
    List<CocheRevisiones> contarRevisionesPorCoche();
}
