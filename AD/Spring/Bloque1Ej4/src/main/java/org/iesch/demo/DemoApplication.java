package org.iesch.demo;

import lombok.RequiredArgsConstructor;
import org.iesch.demo.Service.HotelService;
import org.iesch.demo.modelo.Habitacion;
import org.iesch.demo.modelo.Reserva;
import org.iesch.demo.repositorio.HabitacionRepositorio;
import org.iesch.demo.repositorio.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final HabitacionRepositorio habitacionRepositorio;
	private final ReservaRepositorio reservaRepositorio;
	private final HotelService hotelService;


    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		// Metemos habitaciones
//		Habitacion h101 = new Habitacion();
//		h101.setNumero(101);
//		h101.setTipo("Doble");
//		Habitacion h102 = new Habitacion();
//		h102.setNumero(102);
//		h102.setTipo("Suite");
//
//		// Guardamos
//
//		habitacionRepositorio.saveAll(Arrays.asList(h101, h102));
//
//		// Misma reserva para la misma habitacion
//
//		Reserva reserva1 = Reserva.builder().fechaEntrada(LocalDate.of(2026,12,1)).fechaSalida(LocalDate.of(2026,12,5)).habitacion(h101).build();
//		Reserva reserva2 = Reserva.builder().fechaEntrada(LocalDate.of(2026,12,20)).fechaSalida(LocalDate.of(2026,12,24)).habitacion(h101).build();
//		Reserva reserva3 = Reserva.builder().fechaEntrada(LocalDate.of(2027,12,10)).fechaSalida(LocalDate.of(2027,12,15)).habitacion(h101).build();
//		Reserva reserva4 = Reserva.builder().fechaEntrada(LocalDate.of(2027,12,25)).fechaSalida(LocalDate.of(2027,12,28)).habitacion(h102).build();
//		reservaRepositorio.saveAll(Arrays.asList(reserva1,reserva2,reserva3,reserva4));

//
//		// Reservas de la habitacion h101
//		Optional<Habitacion> habitacion = habitacionRepositorio.findByNumero(101);
//		if (!habitacion.isPresent()){
//			System.out.println("Habitacion inexistente");
//		} else {
//			System.out.println(habitacion.get());
//			Optional<List<Reserva>> reservasdelahabitacion101 = reservaRepositorio.findByhabitacion_Id(habitacion.get().getId());
//			if (!reservasdelahabitacion101.isPresent()){
//				System.out.println("La habitacion " + habitacion.get().getId() + " no tiene reservas disponibles");
//			} else {
//				for (Reserva r :reservasdelahabitacion101.get()){
//					System.out.println(r);
//				}
//			}
//
//		}
//
//		//Reservas entre fechas
//		Optional<List<Reserva>> reservaList = reservaRepositorio.findByFechaEntradaBetween(LocalDate.of(2026,12,1), LocalDate.of(2026,12,30));
//		if (!reservaList.isPresent()){
//			System.out.println("No se ha encontrado ninguna reserva entre esas fechas");
//		} else {
//			System.out.println("Reservas entre fechas encontrada: ");
//			for (Reserva r : reservaList.get()){
//				System.out.println(r);
//			}
//		}
//
//
//
//		// Update habitacion
//		Optional<Habitacion> temp = habitacionRepositorio.findByNumero(101);
//		if (temp.isPresent()){
//			Habitacion habitacionH101 = temp.get();
//			habitacionH101.setTipo("Doble Superior");
//			habitacionRepositorio.save(habitacionH101);
//		}
//		System.out.println(habitacionRepositorio.findByNumero(101));
//
//		// Update reserva
//		Optional<Reserva> reservatmp = reservaRepositorio.findById(3L);
//		if (reservatmp.isPresent()){
//			Reserva reserva3 = reservatmp.get();
//			reserva3.setFechaEntrada(LocalDate.of(2028,1,1));
//			reserva3.setFechaSalida(LocalDate.of(2028,2,1));
//			reservaRepositorio.save(reserva3);
//		}
//
//		// Borrar reserva
//
//		Optional<Reserva> reservatmp = reservaRepositorio.findById(1L);
//		if (!reservatmp.isPresent()){
//			System.out.println("Reserva inexistente");
//		} else {
//			Reserva r = reservatmp.get();
//			reservaRepositorio.delete(r);
//
//		}
//
//		// Borro una habitacion 102
//		Optional<Habitacion> habitaciontmp = habitacionRepositorio.findByNumero(102);
//		if (!habitaciontmp.isPresent()){
//			System.out.println("La habitacion no existe");
//		} else {
//			Habitacion habitacion102 = habitaciontmp.get();
//			hotelService.tieneReservas(habitacion102);
//			System.out.println("Habitacion " + habitacion102.getId() + " borrada satisfactoriamente");
//		}
//
//
}



}
