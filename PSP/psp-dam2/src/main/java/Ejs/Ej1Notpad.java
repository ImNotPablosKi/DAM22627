package Ejs;

import java.io.IOException;

public class Ej1Notpad {
    static void main() {
//        try {
//            // Esto crea un proceso que tiene y ejecuta un comando
//            Process notepad = new ProcessBuilder("C:\\Program Files\\Notepad++\\notepad++.exe").start();
//        } catch (IOException e){
//            e.printStackTrace();
//        }
        try {
            // Esto crea un proceso que tiene y ejecuta un comando que abre un archivo
            Process notepad = new ProcessBuilder("C:\\Program Files\\Notepad++\\notepad++.exe", "src/Ejs/cosa.txt").start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
