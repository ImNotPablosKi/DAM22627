package org.iesch.PracticaTema1PSP.ForkJoin;

import lombok.extern.slf4j.Slf4j;
import org.iesch.PracticaTema1PSP.ThreadPool.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@SpringBootApplication
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class Main implements CommandLineRunner {

    private final String[] MESES = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {

        SpringApplication.run(org.iesch.PracticaTema1PSP.ForkJoin.Main.class, args);

    }

    @Override
    public void run(String... args) {

        long inicio = System.currentTimeMillis();

        Path dir = Path.of("src/main/java/org/iesch/PracticaTema1PSP/items/");

        ArrayList<Path> listaRutas = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {

            for (Path fichero : stream) {

                listaRutas.add(fichero);

            }

        } catch (IOException | DirectoryIteratorException e) {

            log.error(String.valueOf(e));

        }

        // en Main

        ForkJoinPool pool = new ForkJoinPool();
//                                  ^Documentación: Creates a ForkJoinPool with parallelism equal to Runtime.availableProcessors, using defaults for all other parameters

//      El getParallelism es el número de hilos disponibles
//      Es como cuando haces un en el thread pool Runtime.getRuntime().availableProcessors();
//      500 es el mínimo
        int threshold = Math.max(500, listaRutas.size() / (pool.getParallelism() * 4));
//                               ^mínimo   ^112mil          ^tareas que quiero
//      112000 / (16 * 4) = 1750 para cada Calcular Item
        CalcularItem task = new CalcularItem(threshold, listaRutas, 0, listaRutas.size());

        Map<Integer, Dato> resultado = pool.invoke(task);

        resultado.forEach((i, dato) -> {

            Item itemMax = dato.getItemMax();
            Item itemMin = dato.getItemMin();
            System.out.println("---------------------------- " + MESES[dato.getMes() - 1].toUpperCase(Locale.ROOT) + " ----------------------------");

            System.out.println("--- Temperatura máxima ---");
            System.out.println(itemMax.getTmax() + "ºC");
            System.out.println("Fecha: " + itemMax.getFecha());
            System.out.println("Hora: " + itemMax.getHoratmax());
            System.out.println("Estación: " + itemMax.getNombre());

            System.out.println("--- Temperatura mínima ---");
            System.out.println(itemMin.getTmin() + "ºC");
            System.out.println("Fecha: " + itemMin.getFecha());
            System.out.println("Hora: " + itemMin.getHoratmin());
            System.out.println("Estación: " + itemMin.getNombre());

        });

        long fin = System.currentTimeMillis();

        System.out.println("Tiempo: " + (fin - inicio) + " ms");

        System.out.println("Num " + num);
    }
}
