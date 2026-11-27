package Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {

    static final Path CARPETA = Path.of("src/main/java/Ejercicio2/imagenes");

    static void main() {

        // Conjunto de hilos para que cada cliente que se conecte siempre sea atendido por un hilo del pool
        ExecutorService pool = Executors.newCachedThreadPool();

        try (ServerSocket server = new ServerSocket(5324)) {

            System.out.println("Servidor escuchando");

            while (true) {

                // En el hilo main solo voy a aceptar conexiones pq lo demás se lo encargo a otros hilos
                Socket cliente = server.accept();
                // Una vez se acepte la conexion dirijo a un hilo para que atienda al cliente q se ha conectado
                pool.execute(new AtenderCliente(cliente));

            }

        } catch (IOException e) {

            System.out.println("Error del server");
            e.printStackTrace();

        } finally {

            // Cerrar el pool una vez todo esté terminado
            pool.shutdown();

        }

    }
}

// PLAN: Esto es lo que debe hacer cada hilo del pool, debe atender a un solo cliente durante toda la conexión o sesión
// Debo de hacer que se puedan enviar bytes y crear las funciones para listar las imágenes y descargarlas y enviarlas
// Meterlo dentro de la clase de Servidor principal funciona tmb pero Ángel va a meter hilos con total seguridad por lo que
// es mejor que me lo aprenda así, además queda bonito
// Pablo del futuro: COMPROBAR QUE TIENE UNA EXTENSIÓN DE IMAGEN!!
// ENVIARLE EL ERROR
class AtenderCliente implements Runnable {

    // Instanciar al cliente que vamos a atender
    private final Socket cliente;

    public AtenderCliente(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {

        // Coger el nombre del hilo en el cual estamos trabajando
        String hilo = Thread.currentThread().getName();
        System.out.println("[" + hilo + "] Cliente: " + cliente.getRemoteSocketAddress());

        try (
                cliente; // Coger el cliente
                DataInputStream inCliente = new DataInputStream(cliente.getInputStream()); // Recibir lo que nos pase el cliente
                DataOutputStream outCliente = new DataOutputStream(cliente.getOutputStream()) // Enviarle cosas al cliente
        ) {

            String peticion = "";
            // Mientras el cliente no mande 0 que luego es el codigo para salir
            while (!peticion.equals("salir")) {

                peticion = inCliente.readUTF();

                switch (peticion) {

                    case "listar":

                        listarImagenes(outCliente);
                        break;
                    case "descargar":

                        enviarImagen(inCliente.readUTF(), outCliente);
                        break;

                    case "salir":
                        break;

                    default:
                        error(outCliente, "Opción NO válida!");
                        break;
                }

            }

        } catch (EOFException e) {

            System.out.println("El cliente ha cerrado la conexión inesperadamente");

        } catch (IOException e) {

            System.out.println("[" + hilo + "]" + " Error al atender al cliente! " + e.getMessage());

        }

        System.out.println("[" + hilo + "] Cliente DESCONECTADO!");
    }

    void listarImagenes(DataOutputStream outCliente) throws IOException {

        List<String> nombres = new ArrayList<>();

        try (

                // Esta barbaridad lee una carpeta que le pases y filtra SOLO los archivos que cumplan X condición
                // En este caso es que sean un archivo legible (que no sea binario vaya) y que sea de tipo png o jpg
                DirectoryStream<Path> stream = Files.newDirectoryStream(Servidor.CARPETA,
                        ruta -> Files.isRegularFile(ruta)  && tieneExtensionImagen(ruta.getFileName().toString()))

        ) {

            for (Path ruta: stream) {

                nombres.add(ruta.getFileName().toString());

            }

        } catch (IOException e) {

            error(outCliente, "Error al leer la carpeta con las imágenes");

        }

        // Ordenarlos
        Collections.sort(nombres);

        outCliente.writeUTF("ok"); // Decirle que todo ha ido bien
        outCliente.writeInt(nombres.size());

        for (String imagen: nombres) {

            outCliente.writeUTF(imagen);

        }

    }

    void enviarImagen(String nombre, DataOutputStream outCliente) throws IOException {

        // El nombre lo escribe el usuario y solo se meten nombres simples (sin rutas)
        // para que yo no vuelva a hacer el imbécil al pasarle la ruta y me salga del directorio porque cachy es gracioso
        if (nombre.contains("/") || nombre.contains("\\") || !tieneExtensionImagen(nombre)) {

            error(outCliente, "Nombre de imagen no válido");
            return;

        }

        byte[] datos;

        try {

            Path ruta = Servidor.CARPETA.resolve(nombre);

            if (!Files.isRegularFile(ruta)) {

                error(outCliente, "La imagen " + nombre + " no existe o está corrupta");
                return;

            }

            datos = Files.readAllBytes(ruta);

        } catch (InvalidPathException | IOException e) {

            error(outCliente, "No se ha podido leer la imagen " +  nombre);
            return;

        }

        outCliente.writeUTF("ok");
        // El cliente debe saber cuantas cosas tiene que leer
        outCliente.writeLong(datos.length);
        outCliente.write(datos);
    }

    // Sacar si es una imagen valida o no porque ocurren cosas
    private static boolean tieneExtensionImagen(String nombre) {

        String minusculas = nombre.toLowerCase();
        return minusculas.endsWith(".jpg") || minusculas.endsWith(".png") || minusculas.endsWith(".gif");

    }

    // Enviarle un codigo de error al cliente para que sepa que está en problemas
    private void error(DataOutputStream out, String motivo) throws IOException {

        out.writeUTF("error");
        out.writeUTF(motivo);

    }
}
