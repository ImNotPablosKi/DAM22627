package Ejercicio2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    static void main() {

        // Scanner para leer los datos del propio cliente
        Scanner sc = new Scanner(System.in);

        try (
                Socket server = new Socket("127.0.0.1", 5324); // IP y puerto
                PrintWriter outServer = new PrintWriter(server.getOutputStream(), true); // Recoger datos del servidor
                Scanner inServer = new Scanner(server.getInputStream()); // Mandar datos al servidor
        ) {

            while (true) {

                String respuesta;
                while (!(respuesta = inServer.nextLine()).equals("0")) {

                    System.out.println(respuesta);

                 }

            }

        } catch (IOException e) {

            System.out.println("Error al leer o escribir las imágenes");

        }

    }
}
