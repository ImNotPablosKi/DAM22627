package org.iesch.ad.demoSpring1;

import lombok.RequiredArgsConstructor;
import org.iesch.ad.demoSpring1.modelo.Persona;
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


@SpringBootApplication
@RequiredArgsConstructor
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class DemoSpring1Application implements CommandLineRunner {

//	@Autowired
//	List<Persona> listaPersona;

	@Autowired
	PersonaRepository personaRepository;

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
		// System.out.println(p);

		// List<Persona> personaList = new ArrayList<>(Arrays.asList(p2, p3, p4));

		// personaRepository.save(p);
		// personaRepository.saveAll(personaList);

		// CRUD
		List<Persona> personaList1 = personaRepository.findAll();
		System.out.println(personaList1);
//		System.out.println(listaPersona);



//		System.out.println(version);
//		System.out.println(nombre);
//		System.out.println(firma);
//
//		Persona p = Persona.builder().id(1L).dni("18444555A").build();
//		System.out.println(p.toString());
//
//		Persona p2 = Persona.builder().id(2L).nombre("Juanjo").build();
//		System.out.println(p2.toString());

	}
}
