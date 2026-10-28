package org.iesch.ad.demoSpring1.repository;

import org.iesch.ad.demoSpring1.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {



}
