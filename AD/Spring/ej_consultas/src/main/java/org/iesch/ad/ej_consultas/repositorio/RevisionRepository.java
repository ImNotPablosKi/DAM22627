package org.iesch.ad.ej_consultas.repositorio;

import org.iesch.ad.ej_consultas.modelo.Revision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisionRepository extends JpaRepository<Revision, String> {
}
