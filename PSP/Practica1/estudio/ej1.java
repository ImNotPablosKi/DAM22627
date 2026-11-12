package Practica1.estudio;

import java.util.Random;

public class ej1 {
    static void main() {

        GestorDescargas gestorDescargas = new GestorDescargas();

//        for (int i = 0; i < 5; i++) {
//
//            Thread hilo = new Thread(new Descargador("Hilo_" + i, " Archivo_" + i, gestorDescargas));
//            hilo.start();
//
//        }

        Thread hilo = new Thread(new Descargador("Hilo_1", " Archivo_1", gestorDescargas));
        Thread hilo2 = new Thread(new Descargador("Hilo_2", " Archivo_2", gestorDescargas));
        Thread hilo3 = new Thread(new Descargador("Hilo_3", " Archivo_3", gestorDescargas));
        Thread hilo4 = new Thread(new Descargador("Hilo_4", " Archivo_4", gestorDescargas));
        Thread hilo5 = new Thread(new Descargador("Hilo_5", " Archivo_5", gestorDescargas));
        Thread hilo6 = new Thread(new Descargador("Hilo_6", " Archivo_6", gestorDescargas));

        try {

            hilo.start();
            hilo2.start();
            hilo3.start();
            hilo4.start();
            hilo5.start();
            hilo6.start();


            hilo.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
            hilo5.join();
            hilo6.join();

        } catch (InterruptedException e) {

            System.out.println("Main Interrupido");

        }

    }
}

class GestorDescargas {

    private int descargasCompletadas;

    synchronized void registrarDescarga(String nombreArchivo) {

        descargasCompletadas++;
        System.out.println(nombreArchivo + " descargado!" + "Se han completado " + descargasCompletadas + " descargas.");

    }

    public int getDescargasCompletadas() {
        return descargasCompletadas;
    }
}

class Descargador implements Runnable {

    String nombre;
    String nombreArchivo;
    GestorDescargas gestor;

    public Descargador(String nombre, String nombreArchivo, GestorDescargas gestor) {
        this.nombre = nombre;
        this.nombreArchivo = nombreArchivo;
        this.gestor = gestor;
    }

    @Override
    public void run() {

        try {

            Thread.sleep(new Random().nextInt(500, 1501));
            gestor.registrarDescarga("[" + nombre + "]" + nombreArchivo);

        } catch (InterruptedException e) {

            System.out.println("Iterrupción al registrar la descarga de " + nombreArchivo);

        }

    }
}
