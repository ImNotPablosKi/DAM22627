package org.example.bloque1ej5;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.bloque1ej5.modelo.RegistroVehicular;
import org.example.bloque1ej5.modelo.Vehiculo;
import org.example.bloque1ej5.repositorio.RegistroVehicularRepositorio;
import org.example.bloque1ej5.repositorio.VehiculoRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class Bloque1ej5Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Bloque1ej5Application.class, args);
	}

	private final RegistroVehicularRepositorio registroVehicular;
	private final VehiculoRepositorio vehiculoRepositorio;

	@Override
	public void run(String... args) throws Exception {
//		Vehiculo vehiculo = Vehiculo.builder().marca("Toyota").modelo("Corolla").matricula("0118 CBT").build();
//		RegistroVehicular registroVehicular1 = RegistroVehicular.builder().numeroRegistro("REG-001").fechaExpedicion(LocalDate.now()).fechaVencimiento(LocalDate.of(2027,01,01)).vehiculo(vehiculo).build();
//		vehiculo.setRegistroVehicular(registroVehicular1);
//
//		vehiculoRepositorio.save(vehiculo);
//
//

		// Update en cascada
		Vehiculo vehiculo = vehiculoRepositorio.findById(1L).get();


		vehiculo.setMarca("vw");
		vehiculo.setModelo("GOLF");

		RegistroVehicular r = vehiculo.getRegistroVehicular();
		r.setFechaVencimiento(LocalDate.of(2050, 12, 31));
		vehiculoRepositorio.save(vehiculo);


	}
}
