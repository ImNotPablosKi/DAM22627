package org.iesch.ad.demoSpring1.repository;

import org.iesch.ad.demoSpring1.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {



}
