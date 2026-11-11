package org.iesch.PracticaTema1PSP.ThreadPool;

import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@SpringBootApplication
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class Main implements CommandLineRunner {

    private final String[] MESES = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }

    @Override
    public void run(String @NonNull ... args) {

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

        int hilos = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(hilos);
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        List<CalcularItem> taskList = new ArrayList<>();

        List<List<Path>> partes = dividirPartesPath(listaRutas, hilos * 3);


        for (List<Path> e : partes) {

            taskList.add(new CalcularItem(e));

        }

        List<Future<Map<Integer, Dato>>> resultados;

        try {

            resultados = executor.invokeAll(taskList);
            executor.shutdown();

            Map<Integer, Dato> total = new TreeMap<>();
            Float maximaTotal = null;
            Float minimaTotal = null;

            for (Future<Map<Integer, Dato>> e : resultados) {

                for (Dato d : e.get().values()) {

                    Dato dato = total.get(d.getMes());

                    if (dato == null) {

                        total.put(d.getMes(), d);
                        continue;

                    }

                    Float max = d.getItemMax().getTmax();
                    Float min = d.getItemMin().getTmin();

                    Float datoMax = dato.getItemMax().getTmax();
                    Float datoMin = dato.getItemMin().getTmin();

                    if (max != null && (datoMax == null || max > datoMax)) {

                        dato.setItemMax(d.getItemMax());

                    }

                    if (max != null && (maximaTotal == null || max > maximaTotal)) {

                        maximaTotal = max;

                    }

                    if (min != null && (datoMin == null || min < datoMin)) {

                        dato.setItemMin(d.getItemMin());

                    }

                    if (min != null && (minimaTotal == null || min < minimaTotal)) {

                        minimaTotal = min;

                    }

                }

            }

            total.forEach((integer, dato) -> {

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

            System.out.println("---------------------------- VALORES ABSOLUTOS --------------------");
            System.out.println("Máxima total: " + maximaTotal);
            System.out.println("Mínima total: " + minimaTotal);

            System.out.println("-------------------------------------------------------------------");

            long fin = System.currentTimeMillis();

            System.out.println("Tiempo: " + (fin - inicio) + " ms");

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {

            executor.shutdown();

        }

    }

    public static List<List<Path>> dividirPartesPath(ArrayList<Path> lista, int numPartes) {
        List<List<Path>> partes = new ArrayList<>();

        int total = lista.size();
        int base = total / numPartes;
        int resto = total % numPartes;

        int inicio = 0;
        for (int i = 0; i < numPartes; i++) {
            int size = base + ((i < resto) ? 1 : 0);
            partes.add(new ArrayList<>(lista.subList(inicio, inicio + size)));
            inicio += size;
        }
        return partes;
    }

}