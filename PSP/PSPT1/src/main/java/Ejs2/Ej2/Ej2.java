package Ejs2.Ej2;

import java.io.File;
import java.io.IOException;

public class Ej2 {
    static void main() {
        try {

            File log = new File("src/Ejs2/Ej2/Salida.txt");
//            Process proceso = new ProcessBuilder("src/Ejs2/Ej2/Script.bat").redirectOutput(log).start();

            // Inicializar el ProcessBuilder con cmd.exe, /c y el comando que se pueden ejecutar varios con & o && para que pare si hay un error
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "echo Usuario actual: & whoami & echo Directorio actual: & cd & echo Contenido del directorio: & dir");

            pb.redirectOutput(log);

            pb.start();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
