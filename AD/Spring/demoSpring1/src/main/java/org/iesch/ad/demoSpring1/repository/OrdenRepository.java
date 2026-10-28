package org.iesch.ad.demoSpring1.repository;

import org.iesch.ad.demoSpring1.modelo.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Long> {



}
