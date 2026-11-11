package org.iesch.PracticaTema1PSP.ForkJoin;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.*;
import org.iesch.PracticaTema1PSP.ThreadPool.Item;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class CalcularItem extends RecursiveTask<Map<Integer, Dato>> {

    private static final Pattern FECHA = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");

    private final Integer THRESHOLD;
    private List<Path> rutas;

    Integer first;
    Integer length;

    private Map<Integer, Dato> dividir() {

//        Main.num.incrementAndGet();

        int mid = length / 2;
        CalcularItem task1 = new CalcularItem(THRESHOLD, rutas, first, mid);
        CalcularItem task2 = new CalcularItem(THRESHOLD, rutas, first + mid, length - mid);

//      Tree map para que se ordene por meses
        Map<Integer, Dato> total = new TreeMap<>();

        invokeAll(task1, task2);

        Map<Integer, Dato> datos1 = task1.join();
        Map<Integer, Dato> datos2 = task2.join();

        for (int i = 1; i < 13; i++) {

            Dato nuevoDato = Dato.builder().mes(i).build();

            Dato e = datos1.get(i);
            Dato f = datos2.get(i);

            if (e == null && f == null) {

                continue;

            }

            nuevoDato.setItemMax(
                    getMaxItem(e == null ? null : e.getItemMax(), f == null ? null : f.getItemMax())
            );

            nuevoDato.setItemMin(
                    getMinItem(e == null ? null : e.getItemMin(), f == null ? null : f.getItemMin())
            );

            total.put(i, nuevoDato);

        }

        return total;

    }

    private Map<Integer, Dato> hacer() {

        Map<Integer, Dato> datos = new HashMap<>();

        Gson gson = new Gson();

        for (int i = first; i < first + length; i++) {
            Path fichero = rutas.get(i);
            Item item;
            String contenido = "";
            try {

                contenido = Files.readString(fichero);
                contenido = contenido.replaceAll("([0-9]+),([0-9]+)", "$1.$2");
                contenido = contenido.replaceAll("(\"prec\":)(\"[A-Za-z]+\")", "$1null");

                item = gson.fromJson(contenido, Item.class);

                if (item == null) continue;

            } catch (NumberFormatException | IOException | JsonSyntaxException ex) {

                System.err.println("Fichero mal hecho con errores de JSON: " + fichero);
                System.err.println(contenido);
                continue;

            }

            Integer mes;
            Matcher findMes = FECHA.matcher(item.getFecha());

            if (!findMes.matches()) continue;

            mes = Integer.parseInt(findMes.group(2));

            Dato dato = datos.get(mes);

            if (dato == null) {

                datos.put(mes, new Dato(mes, item, item));
                continue;

            }

            dato.setItemMax(getMaxItem(item, dato.getItemMax()));

            dato.setItemMin(getMinItem(item, dato.getItemMin()));

        }

        return datos;

    }

    @Override
    protected Map<Integer, Dato> compute() {

        if (length > THRESHOLD) {

            return dividir();

        } else {

            return hacer();

        }

    }

    private Item getMaxItem(Item e, Item f) {

        if (e == null) return f;
        if (f == null) return e;
        if (e.getTmax() == null) return f;
        if (f.getTmax() == null) return e;

        return e.getTmax() > f.getTmax() ? e : f;

    }

    private Item getMinItem(Item e, Item f) {

        if (e == null) return f;
        if (f == null) return e;
        if (e.getTmin() == null) return f;
        if (f.getTmin() == null) return e;

        return e.getTmin() < f.getTmin() ? e : f;

    }

}
