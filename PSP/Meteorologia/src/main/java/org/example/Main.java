package org.example;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

// Plan
// 1 - Añadir los nombres de los archivos a una lista para despues separar y repartir esa lista <x>
// 2 - Repartir la lista entre tareas, sacar los datos de cada archivo y transformarlos a objetos, En esas mismas tareas se guardarán los objetos en un Map<String, List<Registro>> <>
// 3 - Finalmente se reparte en tareas el proceso de leer todas esas listas, organizarlas y hacer un mega String con los datos de cada més

public class Main {
    static void main() {
        Instant inicio = Instant.now();
        // <============================================= 1 - LISTA DE RUTAS =============================================>
        List<Path> archivos = new ArrayList<>();

        // Guardo las rutas en una lista
        Path dir = Path.of("src/main/java/org/example/registros");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path: stream) {
                archivos.add(path);
            }
        } catch (IOException | DirectoryIteratorException x) {
            System.err.println(x);
        }

        // <============================================= 2 - Tareas =============================================>

        MapaSincronizado mapaRegistrosPorMes = new MapaSincronizado();

        // Reparto la lista
        // Por cada hilo habrán aproximadamente 3 lotes
        Integer cantidadDelLote = 100;
        Integer cantidadDeLotes = archivos.size()/cantidadDelLote;
        Integer hilos = cantidadDeLotes/3;
        //System.out.println(lotes+" - "+hilos);

        List<TareaOrganizarRegistros> tareas = new ArrayList<>();

        for (int i = 0; i < cantidadDeLotes; i++) {
            tareas.add(new TareaOrganizarRegistros(archivos.subList(i*cantidadDelLote, (i+1)*cantidadDelLote),mapaRegistrosPorMes));

            //System.out.println(i*cantidadDelLote+"-"+(i+1)*cantidadDelLote);
        }

        // Los que sobren los añado por separado
        Integer sobrantes = archivos.size()%cantidadDelLote;
        if (sobrantes!=0){
            tareas.add(new TareaOrganizarRegistros(archivos.subList(archivos.size()-sobrantes, archivos.size()),mapaRegistrosPorMes));

            //System.out.println((archivos.size()-sobrantes+" - "+archivos.size()));
        }

        // Hago el ThreadPoool
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(hilos);

        for (Runnable tarea : tareas) {
            executor.execute(tarea);
        }

        //System.out.println(archivos.size()/lotes+1);

        try {
            // shutdown() cierra el executor entonces awaitTermination espera 1 minuto a que se procesen todas las tareas
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
            //System.out.println(mapaRegistrosPorMes.contAnadidos);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // <============================================= 3 - Creación del string de forma ordenada =============================================>

        // Saco el set de las key de las agrupaciones por més para poder asignar unos meses a cada hilo
        List<String> setMes = mapaRegistrosPorMes.registros.keySet().stream().toList();
        Map<String, ArrayList<Registro>> registros = mapaRegistrosPorMes.registros;

        // Lo mismo que arriba
        Integer cantidadDelLoteRegs = 20;
        Integer cantidadDeLotesRegs = setMes.size()/cantidadDelLoteRegs;
        Integer hilosRegs = cantidadDeLotesRegs/3;

        // En este array se guardarán los resultados de los hilos, cada pos equivale al resultado de un hilo
        String[] resultados;
        Integer sobrantesRes = setMes.size()%cantidadDelLoteRegs;
        if (sobrantesRes>0){
            resultados = new String[cantidadDeLotesRegs+1];
        } else {
            resultados = new String[cantidadDeLotesRegs];
        }

        // Reparto los meses en listas de meses para cada tarea y asigno una posición única del array de respuestas a cada tarea
        List<TareaGenerarString> tareasRes = new ArrayList<>();

        for (int i = 0; i < cantidadDeLotesRegs; i++) {
            tareasRes.add(new TareaGenerarString(setMes.subList(i*cantidadDelLoteRegs, (i+1)*cantidadDelLoteRegs), registros, resultados, i));

            //System.out.println(i*cantidadDelLoteRegs+"-"+(i+1)*cantidadDelLoteRegs);
        }

        // Los que sobren los añado por separado
        if (sobrantesRes!=0){
            tareasRes.add(new TareaGenerarString(setMes.subList(setMes.size()-sobrantesRes, setMes.size()), registros, resultados, resultados.length-1));

            //System.out.println((setMes.size()-sobrantesRes+" - "+setMes.size()));
        }

        //System.out.println(setMes.size());

        // Hago el ThreadPoool para los resultados
        ThreadPoolExecutor executorResultado = (ThreadPoolExecutor) Executors.newFixedThreadPool(hilosRegs);

        for (Runnable tarea : tareasRes) {
            executorResultado.execute(tarea);
        }

        try {
            // shutdown() cierra el executor entonces awaitTermination espera 1 minuto a que se procesen todas las tareas
            executorResultado.shutdown();
            executorResultado.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Finalmente muestro la lista de resultados

        for (String s: resultados){
            System.out.print(s);
        }
        Duration duracion = Duration.between(inicio, Instant.now());
        System.out.println("\nTiempo: " + duracion.toMillis() + " ms");
        //System.out.println(tareasRes.size());

        // <============================================= PRUEBAS =============================================>


//        System.out.println("Pruebas");

        System.out.println(archivos.size());
//       try {
//
//           String str = Files.readString(Path.of("src/main/java/org/example/registros/1a0a0e11")).toString();
//           System.out.println(str);
//
//           Matcher matcher = Pattern.compile("\",\"").matcher(Files.readString(Path.of("src/main/java/org/example/registros/1a0a0e11")).toString());
//           String cad = matcher.replaceAll("\"'\"");
//           cad = cad.replace(",",".").replace("'", ",");
//
//           System.out.println(cad);
//
//           Gson gson = new Gson();
//           Registro reg = gson.fromJson(cad, Registro.class);
//           reg.calcularFecha();
//           System.out.println(reg);
//
//       } catch (IOException e) {
//           throw new RuntimeException(e);
//       }

//        Thread hiloPrueba = new Thread(new TareaOrganizarRegistros(archivos.subList(0, 100), mapaRegistrosPorMes));
//
//        hiloPrueba.start();
//        try {
//            hiloPrueba.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println(mapaRegistrosPorMes.contAnadidos);
//        System.out.println(mapaRegistrosPorMes.registros.get("2018-10"));

//        AtomicReference<Integer> acum = new AtomicReference<>(0);
//        tareas.forEach(a->{
//            acum.updateAndGet(v -> v + a.archivos.size());
//        });
//        System.out.println(acum);
//        System.out.println(archivos.size());

//        System.out.println(mapaRegistrosPorMes.registros.keySet());


//        System.out.println(setMes.size());
//
//
//        //System.out.println(resultados.length);
//
//        //System.out.println(lotesReg+" - "+hilosReg);
//        for (String mes: setMes){
//            List<Registro> regs = mapaRegistrosPorMes.registros.get(mes);
//
//            Registro regTmax = regs.stream().filter(a->a.getTmax()!=null).max(Comparator.comparing(Registro::getTmax)).get();
//            Registro regTmin = regs.stream().filter(a->a.getTmin()!=null).min(Comparator.comparing(Registro::getTmin)).get();
//
//            System.out.println("<=============== "+mes+" ===============>\nTemperatura maxima: "+regTmax+"\nTemperatura minima: "+regTmin);
//        }
    }
}
