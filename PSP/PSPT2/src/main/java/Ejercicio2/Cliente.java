package Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Cliente {
    static void main() {

        // Scanner para leer los datos del propio cliente por el teclado
        Scanner sc = new Scanner(System.in);

        try (
                Socket server = new Socket("127.0.0.1", 5324); // IP y puerto
                DataOutputStream outServer = new DataOutputStream(server.getOutputStream()); // Mandar datos al servidor
                DataInputStream inServer = new DataInputStream(server.getInputStream()); // Recoger datos del servidor
        ) {

            String op = "";

            // Mientras no quiera salir
            while (!(op.equals("0"))) {

                System.out.println("=======================");
                System.out.println("0 - Salir");
                System.out.println("1 - Listar imágenes");
                System.out.println("2 - Descargar imagen");
                System.out.print("> ");
                op = sc.nextLine().trim(); // Limpiar un poco

                switch (op) {

                    case "0":

                        outServer.writeUTF("salir");
                        break;

                    case "1":

                        listarImagenes(outServer, inServer);
                        break;

                    case "2":

                        System.out.println("Que imagen quieres descargar?\n> ");
                        descargarImagen(sc.nextLine().trim(), outServer, inServer);
                        break;

                    default:

                        outServer.writeUTF("Opción NO válida!");
                        break;
                }

            }

        } catch (IOException e) {

            System.out.println("Error de comunicación con el server " + e.getMessage());

        }

    }

    static void listarImagenes(DataOutputStream outServer, DataInputStream inServer) throws IOException {

        outServer.writeUTF("listar");

        // Lo q me responda el server siempre será ok o error
        if (!inServer.readUTF().equals("ok")) {

            System.out.println(inServer.readUTF()); // Esto me dirá porqué cojones ha fallado

        }

        int cantidad = inServer.readInt();

        System.out.println("===== Imagenes =====");
        for (int i = 0; i < cantidad; i++) {

            System.out.println(inServer.readUTF() + "\n"); // Acordarme de hacer el salto de linea para q no salga pegado

        }
    }

    static void descargarImagen(String nombre, DataOutputStream outServer, DataInputStream inServer) throws IOException {

        outServer.writeUTF("descargar");
        outServer.writeUTF(nombre);

        if (!inServer.readUTF().equals("ok")) {

            System.out.println(inServer.readUTF());

        }

        long tamanio = inServer.readLong();

        byte[] datos = new byte[(int) tamanio];
        // readFully lee de una todos los bytes de un stream de datos
        inServer.readFully(datos);

        Path descargas = Files.createDirectories(Path.of("descargas"));
        Path destino = descargas.resolve(nombre); // Meter la ruta de la imagen a la carpeta de descargas
        Files.write(destino, datos);

        System.out.println("Imagen descargada! " + destino.toAbsolutePath() + " " + tamanio + " bytes");
    }
}

