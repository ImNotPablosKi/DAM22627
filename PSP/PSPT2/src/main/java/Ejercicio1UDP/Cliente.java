package Ejercicio1UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op = "";
        try (DatagramSocket datagramSocket = new DatagramSocket(5325)) {
            while (true) {

                System.out.println("<"+"=".repeat(10)+">");
                System.out.println("0 - Salir");
                System.out.println("1 - Mostrar archivos");
                System.out.println("2 - Leer archivo");
                System.out.print("> ");
                op = sc.nextLine();

                // Preparo el paquete y lo envío al servidor
                byte[] buffer = op.getBytes();
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 5324);
                datagramSocket.send(paquete);

                if (op.equals("0")) break;

                switch (op){
                    case "1":
                        //Recibo la respuesta
                        buffer = new byte[1024];
                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                        datagramSocket.receive(packet);

                        String resp = new String(packet.getData()).trim();
                        System.out.println(resp);
                        break;
                    case "2":
                        // Envío otro paquete con el nombre del archivo y espero otra respuesta
                        System.out.println("¿Que archivo?");
                        System.out.print("> ");
                        op = sc.nextLine();

                        buffer = op.getBytes();
                        paquete = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 5324);

                        datagramSocket.send(paquete);

                        buffer = new byte[1024];
                        DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length);
                        datagramSocket.receive(packet2);

                        String resp2 = new String(packet2.getData()).trim();
                        System.out.println(resp2);
                        break;
                    default:
                        System.out.println("Opción ["+op+"] no encontrada");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
