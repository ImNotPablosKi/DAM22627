package Ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ej1 {
    static void main() {

        String filePath = "texto.txt";
        int lineCount = countLines(filePath);
        System.out.println("Lineas de fichero: " + lineCount);

    }

    public static int countLines(String filePath) {

        int lines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){

            while (br.readLine() != null) {

                // Mientras el readLine() no sea nulo, será que hay líneas no?
                lines++;

            }

        } catch (FileNotFoundException e) {

            System.out.println("lol");

        } catch (IOException e) {

            System.out.println("lmao");

        }

        return lines;

    }
}
