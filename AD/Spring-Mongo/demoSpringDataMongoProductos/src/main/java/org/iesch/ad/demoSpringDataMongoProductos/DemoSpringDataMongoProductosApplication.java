package org.iesch.ad.demoSpringDataMongoProductos;

import org.iesch.ad.demoSpringDataMongoProductos.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.iesch.ad.demoSpringDataMongoProductos.repositorio.ProductoRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoSpringDataMongoProductosApplication implements CommandLineRunner {

	@Autowired
	ProductoRepository productoRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataMongoProductosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Producto producto = Producto.builder()
//				.sku("BY1258CA")
//				.nombre("Coche de juguete")
//				.categoria("Juguetes")
//				.precio(15.59)
//				.stock(12)
//		.build();
//
//		productoRepository.save(producto);

//		List<Producto> productoList = productoRepository.findAll();
//		System.out.println(productoList);

		// Update
		Producto producto = productoRepository.findById("6b07278c3cd534fe03f1e1b9").get();
		System.out.println(producto);

		// Delete
		productoRepository.deleteById("6b07278c3cd534fe03f1e1b9");

	}
}
