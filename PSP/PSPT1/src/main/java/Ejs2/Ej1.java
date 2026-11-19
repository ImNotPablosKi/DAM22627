package Ejs2;

import java.io.IOException;
import java.util.Scanner;

public class Ej1 {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Que quieres abrir\n> ");

        try {

            Process proceso = new ProcessBuilder(sc.nextLine()).start();
            proceso.waitFor();
            System.out.println("Proceso finalizado - "+proceso.exitValue());

        }catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
