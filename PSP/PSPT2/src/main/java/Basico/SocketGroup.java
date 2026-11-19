package T2.Basico;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

// Varios clientes envian datos a un servidor
public class SocketGroup {
    static void main() {
        try (MulticastSocket socket = new MulticastSocket(54321)){

            // Lo uno al grupo
            InetAddress group = InetAddress.getByName("225.0.0.1");
            socket.joinGroup(group);

            // Ejecuto los clientes
            Thread cliente1 = new Thread(new ClienteGrupo("Mensaje 1"));
            Thread cliente2 = new Thread(new ClienteGrupo("Mensaje 2"));
            cliente1.start();
            cliente2.start();

            for (int i = 0; i < 2; i++) {
                // Hago el buffer que se asigna al paquete recibirá el paquete del cliente
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Espero a que me llegue el paquete
                socket.receive(packet);

                // Lo transformo a string y lo imprimo eliminando "impurezas"
                String info = new String(packet.getData());
                System.out.println(info.trim());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClienteGrupo implements Runnable {
    String mensajeContenido;

    public ClienteGrupo(String mensajeContenido) {
        this.mensajeContenido = mensajeContenido;
    }

    @Override
    public void run() {
        try (DatagramSocket datagramSocket = new DatagramSocket()){

            Thread.sleep(1000);

            // Hago el mensaje
            byte[] mensaje = mensajeContenido.getBytes();

            // Construyo el paquete con la ip y el puerto del server además del paquete a enviar y lo envío mediante el socket que tiene un puerto temporal
            DatagramPacket paquete = new DatagramPacket(mensaje, mensaje.length, InetAddress.getByName("225.0.0.1"), 54321);
            datagramSocket.send(paquete);

        } catch (IOException | InterruptedException e ){
            e.printStackTrace();
        }
    }
}