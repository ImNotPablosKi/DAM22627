package org.iesch.ad.demoCarga.repositorio;

import org.iesch.ad.demoCarga.modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
}
