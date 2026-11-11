package org.iesch.PracticaTema1PSP.ThreadPool;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcularItem implements Callable<Map<Integer, Dato>> {

    private static final Pattern FECHA = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");

    private List<Path> lista;

    public CalcularItem(List<Path> lista) {
        this.lista = lista;
    }

    @Override
    public Map<Integer, Dato> call() {

        Map<Integer, Dato> datos = new HashMap<>();

        Gson gson = new Gson();

        for (Path fichero : lista) {
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

            Float max = item.getTmax();
            Float min = item.getTmin();

            Float datoMax = dato.getItemMax().getTmax();
            Float datoMin = dato.getItemMin().getTmin();


            if (max != null && (datoMax == null || max > datoMax)) {

                dato.setItemMax(item);

            }

            if (min != null && (datoMin == null || min < datoMin)) {

                dato.setItemMin(item);

            }

        }

        return datos;

    }
}
