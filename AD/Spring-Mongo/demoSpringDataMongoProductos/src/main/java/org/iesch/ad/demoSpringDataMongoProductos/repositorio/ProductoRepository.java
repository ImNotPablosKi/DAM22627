package org.iesch.ad.demoSpringDataMongoProductos.repositorio;

import org.iesch.ad.demoSpringDataMongoProductos.modelo.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductoRepository extends MongoRepository<Producto, String> {
}