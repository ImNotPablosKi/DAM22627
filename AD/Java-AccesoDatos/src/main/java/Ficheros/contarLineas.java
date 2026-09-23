package Ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class contarLineas {
    static void main() throws IOException {

        long lineas = Files.lines(Path.of("src/main/java/Ficheros/texto.txt")).count();
        System.out.println("El archivo tiene " + lineas + " lineas");

    }
}
