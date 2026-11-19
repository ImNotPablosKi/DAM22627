package ejercicios1.bis;

import java.io.File;
import java.io.IOException;

public class ej2 {
    static void main() {

        File archivoOutput = new File("src/main/java/ejercicios1/dump/salida.txt");
        File archivoErrores = new File("src/main/java/ejercicios1/dump/errores.txt");

        try {

            Process process = new ProcessBuilder("cmd")
                    .redirectOutput(archivoOutput)
                    .redirectError(archivoErrores)
                    .start();


        } catch (IOException e) {

            System.out.println("xd");

        }

    }
}
