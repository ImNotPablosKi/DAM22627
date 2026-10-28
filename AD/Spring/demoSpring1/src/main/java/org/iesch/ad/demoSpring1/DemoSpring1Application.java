package org.iesch.ad.demoSpring1;

import lombok.RequiredArgsConstructor;
import org.iesch.ad.demoSpring1.modelo.Coche;
import org.iesch.ad.demoSpring1.modelo.Persona;
import org.iesch.ad.demoSpring1.repository.CocheRepository;
import org.iesch.ad.demoSpring1.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
@RequiredArgsConstructor
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class DemoSpring1Application implements CommandLineRunner {

//	@Autowired
//	List<Persona> listaPersona;

	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	CocheRepository cocheRepository;

	@Value("${mi.app.nombre}")
	String nombre;

	@Value("${mi.app.version}")
	String version;

	@Value("${firma}")
	String firma;

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(DemoSpring1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Hola Mundo!!");

//		Persona p = Persona.builder().nombre("Juan").apellidos("López Garrido").email("juan@aa.es").dni("18444555A").build();
//		Persona p2 = Persona.builder().nombre("Antonio").apellidos("Sánchez Jiménez").email("antonio@aa.es").dni("18464575B").build();
//		Persona p3 = Persona.builder().nombre("Pepito").apellidos("Tezano Izquierdo").email("pepito@aa.es").dni("66666666A").build();
//		Persona p4 = Persona.builder().nombre("Paula").apellidos("Maicas Val").email("paula@aa.es").dni("67676767C").build();
//		 System.out.println(p);

		 // List<Persona> personaList = new ArrayList<>(Arrays.asList(p, p2, p3, p4));

//		Persona p = new Persona();
//		p.setNombre("Juanjo");
//		p.setApellidos("Zuñiga Antón");
//		System.out.println(p);
//		personaRepository.save(p);

//		personaRepository.saveAll(personaList);

		// CRUD
		// READ
//		List<Persona> personaList1 = personaRepository.findAll();
//		System.out.println(personaList1);
//
//		// select * from tabla where id = 4;
//		Optional<Persona> personaEncontradaPorId = personaRepository.findById(4L);
//		if (personaEncontradaPorId.isPresent()) {
//
//			Persona p = personaEncontradaPorId.get();
//			System.out.println(p);
//
//		} else {
//
//			System.out.println("Persona no encontrada");
//
//		}
//
//		// UPDATE
//		// Estamos trabajando con personaEncontradaPorId
//		if (personaEncontradaPorId.isPresent()) {
//
//			personaEncontradaPorId.get().setNombre("Joaquin");
//			personaEncontradaPorId.get().setApellidos("Se me cae");
//			personaEncontradaPorId.get().setDni("99123123R");
//			personaEncontradaPorId.get().setEmail("toni@aa.es");
//			personaEncontradaPorId.get().setEmail("toni@aa.es");
//
//			// Guardo
//			personaRepository.save(personaEncontradaPorId.get());
//
//		}
//
//		personaList1 = personaRepository.findAll();
//		System.out.println(personaList1);
//
//		// DELETE
//		Optional<Persona> personaABorrar = personaRepository.findById(4L);
//
//		if (personaABorrar.isPresent()) {
//
//			Persona personaBorra = personaABorrar.get();
//			personaRepository.delete(personaBorra);
//
//		}
//
//		Persona personatmp = new Persona();
//		personatmp.setId(3L);
//		personaRepository.delete(personatmp);

//		System.out.println(version);
//		System.out.println(nombre);
//		System.out.println(firma);
//
//		Persona p = Persona.builder().id(1L).dni("18444555A").build();
//		System.out.println(p.toString());
//
//		Persona p2 = Persona.builder().id(2L).nombre("Juanjo").build();
//		System.out.println(p2.toString());

//		System.out.println(" --- HQL --- ");
//		List<Persona> listaPersonas = personaRepository.buscaTodasPersonas();
//		System.out.println(listaPersonas);
//
//		System.out.println(" --- SQL NATIVO --- ");
//		List<Persona> listaPersonas2 = personaRepository.buscaTodasPersonasNative();
//		System.out.println(listaPersonas2);
//
//		System.out.println(" --- PSEUDO LENGUAJE --- ");
//		// Buscamos las personas cuyo nombre empiezen por J
//
//		List<Persona> personaListComienzaPorLetra = personaRepository.findByNombreStartingWith('J');
//		System.out.println(personaListComienzaPorLetra);
//
//		// Buscamos las personas cuya letra del dni sea A y el apellido contenga una R
//		List<Persona> personas = personaRepository.findByDniContainingAndApellidosContaining('a', "R");
//		System.out.println(personas);
//
//		// DNI con un 9 o email NULL
//		List<Persona> personas2Condiciones = personaRepository.findByDniContainingOrEmailNull("9");
//		System.out.println(personas2Condiciones);

//		System.out.println("--- One 2 One / OneToOne ---");
//		Persona persona = Persona.builder().nombre("Colega").apellidos("Coléguez").dni("17676767L").email("colega@coleguez.gg").build();
//
//		Coche coche = Coche.builder().marca("Volkswagen").mdoelo("Golf GTS").matricula("67676767").build();
//
//		persona.setCoche(coche);
//		personaRepository.save(persona);

		// Cargar de BBDD la persona con ID 13
		/*Optional<Persona> persona = personaRepository.findById(13L);

		if (persona.isPresent()) {
			Persona p = persona.get();
			System.out.println(p);
		}

		Optional<Coche> coche = cocheRepository.findById(1L);
		// Hecprooll tech
		coche.ifPresent(System.out::println);*/

//		System.out.println("--- One 2 One BIDIRECCIONAL ---");
//		Persona persona = Persona.builder().nombre("Pepito").dni("18779900G").apellidos("Perez Sánchez").email("pepitops@aa.es").build();
//		personaRepository.save(persona);
//
//		Coche coche = Coche.builder().matricula("9988 NTP").build();
//		cocheRepository.save(coche);
//
//		persona.setCoche(coche);
//		coche.setPersona(persona);
//
//		personaRepository.save(persona);

		System.out.println("Peta Bidireccional");
		Optional<Persona> persona = personaRepository.findById(14L);

		if (persona.isPresent()) {

			Persona persona1 = persona.get();
			System.out.println(persona1);

		}

		Optional<Coche> coche = cocheRepository.findById(2L);

		if (coche.isPresent()) {

			Coche coche1 = coche.get();
			System.out.println(coche1);
			Persona personatmp = coche.get().getPersona();
			System.out.println(personatmp);

		}

	}
}
