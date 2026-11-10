package org.example.apano;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TareaOrganizarRegistros implements Runnable {
    List<Path> archivos;
    MapaSincronizado mapa;
    //Integer cont = 0;

    public TareaOrganizarRegistros(List<Path> archivos, MapaSincronizado mapa) {
        this.archivos = archivos;
        this.mapa = mapa;
    }

    public TareaOrganizarRegistros(List<Path> archivos) {
        this.archivos = archivos;
    }

    @Override
    public void run() {
        for (Path archivo: archivos) {
            try {
                // Consigo transformar las , de separación por ' de forma temporal para poder cambiar las , de los float por . y así evitar el fallo del formato de los float
//                Matcher matcher = Pattern.compile("\",\"").matcher(Files.readString(archivo));
//                String cad = matcher.replaceAll("\"'\"");
//                cad = cad.replace(",", ".").replace("'", ",");
                String cad = Files.readString(archivo).replaceAll("(\\d),(\\d)", "$1.$2");

                // Una vez formateada la cadena json la paso a un objeto Registro
                Gson gson = new Gson();
                Registro reg = gson.fromJson(cad, Registro.class);
                // Calculo su fecha aquí porque en el constructor no funcióna
                // Este cálculo permite su posterior almacenamiento
                reg.calcularFecha();

                //System.out.println((++cont)+" - "+reg);

                // Lo añado de forma sincronizada a un mapa que los ordenará por més
                mapa.anadirRegistro(reg);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //System.out.println("Terminado");
    }
}
