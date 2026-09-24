package ejercicios1.bis;

import java.io.IOException;
import java.util.Scanner;

public class ej1 {
    static void main() throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dime la ruta absoluta de un archivo");
        String path = sc.nextLine();

        try {

            Process proceso = new ProcessBuilder(path).start();
            proceso.waitFor();

        } catch (InterruptedException e) {

            System.out.println("ni idea");

        } catch (IOException e) {

            System.out.println("ni idea bro");

        }

    }
}
