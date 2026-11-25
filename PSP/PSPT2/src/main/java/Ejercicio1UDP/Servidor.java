package Ejercicio1UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Servidor{

    public static void main(String[] args) {
        try (DatagramSocket socketUDP = new DatagramSocket(5324)) {
            while (true) {
                // Hago el buffer que se asigna al paquete recibirá el paquete del cliente, NO REUTILIZAR PAQUETES SIN INICIALIZAR ANTES
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Espero a que me llegue un paquete del cliente con la opción
                socketUDP.receive(packet);
                String info = new String(packet.getData()).trim();

                // Si es 0 cierro el servidor
                if (info.equals("0")) break;

                switch (info) {
                    case "1":
                        // Saco todos los archivos de la carpeta y los añado a un "StringBuilder" que será la respuesta
                        Path dir = Path.of("src/main/java/Ejercicio1UDP/Archivos");
                        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                            StringBuilder string = new StringBuilder();

                            string.append("<===== Archivos =====>\n");
                            for (Path path: stream) {
                                string.append(path.getFileName()+"\n");
                            }
                            string.append("<====================>\n\n");

                            // Hago la respuesta
                            byte[] mensaje = string.toString().getBytes();
                            DatagramPacket paqueteResp = new DatagramPacket(mensaje, mensaje.length, InetAddress.getByName("127.0.0.1"), 5325);
                            socketUDP.send(paqueteResp);

                        } catch (IOException | DirectoryIteratorException x) {
                            System.err.println(x);
                        }

                        break;
                    case "2":
                        // Si es 2 necesito otro paquete
                        socketUDP.receive(packet);
                        String archivo = new String(packet.getData()).trim();

                        try {

                            String contenido =  Files.readString(Path.of("src/main/java/Ejercicio1/Archivos/"+archivo));

                            StringBuilder string = new StringBuilder();

                            string.append("<===== Contenido =====>\n");
                            string.append(contenido+"\n");
                            string.append("<=====================>\n\n");

                            byte[] mensaje = string.toString().getBytes();
                            DatagramPacket paqueteResp = new DatagramPacket(mensaje, mensaje.length, InetAddress.getByName("127.0.0.1"), 5325);
                            socketUDP.send(paqueteResp);

                        }catch (IOException e){
                            // Si no existe le envío el error
                            byte[] mensaje = "Atchivo no encontrado".getBytes();
                            DatagramPacket paqueteResp = new DatagramPacket(mensaje, mensaje.length, InetAddress.getByName("127.0.0.1"), 5325);
                            socketUDP.send(paqueteResp);
                        }
                }
            }

    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
