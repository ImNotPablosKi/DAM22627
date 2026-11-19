package ejercicios1;

import java.io.File;
import java.io.IOException;

public class ej2 {
    static void main() {

        try {

            // Crear las rutas de archivo previamente, esto es necesario
            File archivo = new File("src/main/java/ejercicios1/dump/logs.txt");
            File archivoErrores = new File("src/main/java/ejercicios1/dump/logsErrores.txt");

            // Crear proceso y redirigir cada cosa a su lugar con el archivo correspondiente
            Process redirigir = new ProcessBuilder("src/main/java/ejercicios1/dump/ejecutable.bat").
                    redirectInput(archivo).
                    redirectOutput(archivo).
                    redirectError(archivoErrores).start();

        } catch (IOException e) {

            System.out.println("mola");

        }

    }
}
