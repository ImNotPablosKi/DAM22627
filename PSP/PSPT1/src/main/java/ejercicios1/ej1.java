package ejercicios1;

import java.io.IOException;

public class ej1 {
    static void main() {

        try {

            Process abrirNotepad = new ProcessBuilder("\"C:\\Program Files\\Notepad++\\notepad++.exe\"",
                    "\"C:\\Users\\dam2\\Documents\\cosa.txt\"" ).start();

        } catch (IOException e) {

            System.out.println("vaya");

        }

    }
}
