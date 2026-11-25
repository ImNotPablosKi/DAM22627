package Basico;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// Un cliente envia datos a un servidor
public class SocketBasico {
    static void main() {
        try (DatagramSocket socketUDP = new DatagramSocket(5324)) {

            // Ejecuto el cliente que mandará una cadena en 1 segundo
            Thread cliente = new Thread(new ClienteBasico());
            cliente.start();

            // Hago el buffer que se asigna al paquete que recibirá el cliente
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Espero a que me llegue el paquete
            socketUDP.receive(packet);

            // Lo transformo a string y lo imprimo eliminando "impurezas"
            String info = new String(packet.getData());
            System.out.println(info.trim());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClienteBasico implements Runnable {

    @Override
    public void run() {
        try (DatagramSocket datagramSocket = new DatagramSocket()) {

            Thread.sleep(1000);

            // Hago el mensaje
            byte[] mensaje = "yo cuando uhh ... :P".getBytes();

            // Construyo el paquete con la ip y el puerto del server además del paquete a enviar y lo envío mediante el socket que tiene un puerto temporal
            DatagramPacket paquete = new DatagramPacket(mensaje, mensaje.length, InetAddress.getByName("127.0.0.1"), 5324);
            datagramSocket.send(paquete);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}