package ejercicios1;

import java.io.File;
import java.io.IOException;

public class ej2 {
    static void main() {

        try {

            // Crear las rutas de archivo previamente, esto es necesario
            File archivo = new File("C:\\Users\\dam2\\Documents\\logs.txt");
            File archivoErrores = new File("C:\\Users\\dam2\\Documents\\logsErrores.txt");

            // Crear proceso y redirigir cada cosa a su lugar con el archivo correspondiente
            Process redirigir = new ProcessBuilder("\"C:\\Users\\dam2\\Documents\\ejecutable.bat\"").
                    redirectInput(archivo).
                    redirectOutput(archivo).
                    redirectError(archivoErrores).start();

        } catch (IOException e) {

            System.out.println("mola");

        }

    }
}
