//package org.iesch.PracticaTema1PSP.ThreadPool;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.PropertySource;
//
//import java.io.IOException;
//import java.nio.file.DirectoryIteratorException;
//import java.nio.file.DirectoryStream;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.*;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//import java.util.concurrent.ThreadPoolExecutor;
//
//@SpringBootApplication
//@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
//// Este es el main comentado para dejar clean el main principal
//public class MainComentado implements CommandLineRunner {
//
//    private final String[] MESES = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
//
//    public static void main(String[] args) {
//
//        SpringApplication.run(MainComentado.class, args);
//
//    }
//
//    @Override
//    public void run(String... args) {
//
//        long inicio = System.currentTimeMillis();
//
//        Path dir = Path.of("src/main/java/org/iesch/PracticaTema1PSP/rutas/");
//
////        ArrayList<Item> rutas = new ArrayList<>();
////
////        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
////
////            for (Path fichero : stream) {
////
////                String contenido = new String(Files.readAllBytes(fichero), StandardCharsets.UTF_8);
////
////                try {
////
////                    Item item = gson.fromJson(contenido, Item.class);
////                    if (item != null) rutas.add(item);
////
////                } catch (JsonSyntaxException ex) {
////
////                    System.err.println("Fichero mal hecho con errores de JSON: " + fichero);
////
////                }
////
////            }
////
////        } catch (IOException | DirectoryIteratorException e) {
////
////            System.err.println(e);
////
////        }
//
//        ArrayList<Path> listaRutas = new ArrayList<>();
//
//        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
//
//            for (Path fichero : stream) {
//
//                listaRutas.add(fichero);
//
//            }
//
//        } catch (IOException | DirectoryIteratorException e) {
//
//            System.err.println(e);
//
//        }
//
///*
//        Importante que el número de partes sea más grande que el número de hilos
//        Ya que si un hilo por lo que sea va lento y hemos dividido
//        las partes en el mismo número de hilos entonces tiene más parte que hacer y tardará más y hay que esperarlo
//        de lo contrario si dividimos la lista en más partes PERO haciendo eso cada parte es más pequeña
//        entonces el hilo que va lento no tardará tanto en hacer su parte y las demás partes serán gestionadas por
//        otros hilos, osea que se reparten el trabajo
//  */
//
//        int hilos = Runtime.getRuntime().availableProcessors();
////        int hilos = 16;
//        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(hilos);
////        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
//
//        List<CalcularItem> taskList = new ArrayList<CalcularItem>();
//
////        List<List<Item>> partes = dividirPartes(rutas, hilos * 2);
//        List<List<Path>> partes = dividirPartesPath(listaRutas, hilos * 3);
//
//
//        for (List<Path> e : partes) {
//
//            taskList.add(new CalcularItem(e));
//
//        }
//
//        List<Future<Map<Integer, Dato>>> resultados;
//
//        try {
//
//            resultados = executor.invokeAll(taskList);
//            executor.shutdown();
////            System.out.println("---- Resultados ----");
//
//            //            for (Future<Map<Integer, Dato>> e : resultados) {
////
////                System.out.println("DATO --------------------------------");
////                e.get().forEach((integer, dato) -> System.out.println(integer + " | " + dato));
////
////            }
//
////          Tiene que ser treemap en vez de hashmap ya que el orden de la clave (el mes) importa a la hora de imprimir
////          Por defecto lo hace ascendente asi que de puta madre
//            Map<Integer, Dato> total = new TreeMap<>();
//
//            for (Future<Map<Integer, Dato>> e : resultados) {
//
//                for (Dato d : e.get().values()) {
//
//                    Dato dato = total.get(d.getMes());
//
//                    if (dato == null) {
//
//                        total.put(d.getMes(), d);
//                        continue;
//
//                    }
//
//                    Float max = d.getItemMax().getTmax();
//                    Float min = d.getItemMin().getTmin();
//
//                    Float datoMax = dato.getItemMax().getTmax();
//                    Float datoMin = dato.getItemMin().getTmin();
//
//                    if (max != null && (datoMax == null || max > datoMax)) {
//
//                        dato.setItemMax(d.getItemMax());
//
//                    }
//
//                    if (min != null && (datoMin == null || min < datoMin)) {
//
//                        dato.setItemMin(d.getItemMin());
//
//                    }
//
//                }
//
//            }
//
////            total.forEach((integer, dato) -> System.out.println(integer + " | " + dato));
//
//            total.forEach((integer, dato) -> {
//
//                Item itemMax = dato.getItemMax();
//                Item itemMin = dato.getItemMin();
//                System.out.println("---------------------------- " + MESES[dato.getMes() - 1].toUpperCase(Locale.ROOT) + " ----------------------------");
//
//                System.out.println("--- Temperatura máxima ---");
//                System.out.println(itemMax.getTmax() + "ºC");
//                System.out.println("Fecha: " + itemMax.getFecha());
//                System.out.println("Hora: " + itemMax.getHoratmax());
//                System.out.println("Estación: " + itemMax.getNombre());
//
//                System.out.println("--- Temperatura mínima ---");
//                System.out.println(itemMin.getTmin() + "ºC");
//                System.out.println("Fecha: " + itemMin.getFecha());
//                System.out.println("Hora: " + itemMin.getHoratmin());
//                System.out.println("Estación: " + itemMin.getNombre());
//
//            });
//
//            System.out.println("------------------------------------------------------------------");
//
//            long fin = System.currentTimeMillis();
//
//            System.out.println("Tiempo: " + (fin - inicio) + " ms");
//
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        } finally {
//
//            executor.shutdown();
//
//        }
//
//    }
//
//    //  Método para indicarle en cuantas partes divido la lista
////  Para hacerlo de una forma eficiente hay que dividirla en x2 partes que hilos hay
//    public static List<List<Path>> dividirPartesPath(ArrayList<Path> lista, int numPartes) {
//        List<List<Path>> partes = new ArrayList<>();
//        /*
//        Ejemplo
//        101
//        3
//        base = 33
//        resto = 2
//         */
//        int total = lista.size();
//        int base = total / numPartes;     // tamaño mínimo de cada parte al hacer la división
//        int resto = total % numPartes;    // partes que sobran que hay que repartir por partes iguales en la medida de lo posible claro
//
//        int inicio = 0;
//        for (int i = 0; i < numPartes; i++) {
//            // Asignarle un solo tamaño más por cada resto, si el resto es de 2 habrán 2 listas con un tamaño más que el base
//            // Por ejemplo si la lista mide 101 / 3 partes da 33 de base (osea sin decimales), pero con 2 de resto, asi que 2 listas tendrán 34 y una 33
//            // Lo de la i < resto, es básciamente un contador, si el resto es 3 se sumará 1 a la base cuando 0,1,2 < resto, osea 3 veces
//            int size = base + ((i < resto) ? 1 : 0);
//            // Como el segundo parámetro de sublist es EXCLUSIVO no se cuenta, asi que lo que valga size será el inicio de la siguiente lista (sumándoselo al inicio anterior)
//            partes.add(new ArrayList<>(lista.subList(inicio, inicio + size)));
//            inicio += size;
//        }
//        return partes;
//    }
//
//    //  Método para indicarle en cuantas partes divido la lista
////  Para hacerlo de una forma eficiente hay que dividirla en x2 partes que hilos hay
//    public static List<List<Item>> dividirPartes(List<Item> lista, int numPartes) {
//        List<List<Item>> partes = new ArrayList<>();
//        /*
//        Ejemplo
//        101
//        3
//        base = 33
//        resto = 2
//         */
//        int total = lista.size();
//        int base = total / numPartes;     // tamaño mínimo de cada parte al hacer la división
//        int resto = total % numPartes;    // partes que sobran que hay que repartir por partes iguales en la medida de lo posible claro
//
//        int inicio = 0;
//        for (int i = 0; i < numPartes; i++) {
//            // Asignarle un solo tamaño más por cada resto, si el resto es de 2 habrán 2 listas con un tamaño más que el base
//            // Por ejemplo si la lista mide 101 / 3 partes da 33 de base (osea sin decimales), pero con 2 de resto, asi que 2 listas tendrán 34 y una 33
//            // Lo de la i < resto, es básciamente un contador, si el resto es 3 se sumará 1 a la base cuando 0,1,2 < resto, osea 3 veces
//            int size = base + ((i < resto) ? 1 : 0);
//            // Como el segundo parámetro de sublist es EXCLUSIVO no se cuenta, asi que lo que valga size será el inicio de la siguiente lista (sumándoselo al inicio anterior)
//            partes.add(new ArrayList<>(lista.subList(inicio, inicio + size)));
//            inicio += size;
//        }
//        return partes;
//    }
//
//
//    //  Método para dividir la lista entera en partes más pequeñas iguales para luego asignarle cada pequeña lista a cada hilo
////  En este método le indico el TAMAÑO de cada lista, no en cuantas partes divido la lista principal
//    public static List<List<Item>> dividirSize(List<Item> lista, int size) {
//
//        // Me creo la lista de listas
//        List<List<Item>> partes = new ArrayList<>();
//
//        for (int i = 0; i < lista.size(); i += size) {
//
//            // El math min es para que si se pasa pille el lista.size
//            // El segundo parámetro de subList es exclusive asi que no lo pilla
//            partes.add(new ArrayList<>(lista.subList(i, Math.min(i + size, lista.size()))));
//
//        }
//
//        return partes;
//    }
//}
///*
// *
// * git commit -m "PSP - Terminada la práctica1 de los metadatos de rutas. NOTA: He usado IA para crearme el adaptador de float a la hora de recoger los datos de los archivos JSON ya que están escritos en formato español con , en vez de punto y me ha corregido la función de dividir la lista y demás detalles que no afectan al funcionamiento del programa. Lo demás es legit y propiedad de hecprooll"
// * */