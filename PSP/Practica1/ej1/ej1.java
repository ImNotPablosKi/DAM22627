package Practica1.ej1;

import java.util.Random;

public class ej1 {
    static void main() throws InterruptedException {
        GestorDescargas gestorDescargas = new GestorDescargas();

        Thread h1 = new Thread(new Descargador("1", gestorDescargas, "archivo1.pdf"));
        Thread h2 = new Thread(new Descargador("2", gestorDescargas, "archivo2.pdf"));
        Thread h3 = new Thread(new Descargador("3", gestorDescargas, "archivo3.pdf"));
        Thread h4 = new Thread(new Descargador("4", gestorDescargas, "archivo4.pdf"));
        Thread h5 = new Thread(new Descargador("5", gestorDescargas, "archivo5.pdf"));
        Thread h6 = new Thread(new Descargador("6", gestorDescargas, "archivo6.pdf"));

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        h6.start();

        // Para comprobar el funcionamiento de una supuesta interrupción
        h2.interrupt();

        h1.join();
        h2.join();
        h3.join();
        h4.join();
        h5.join();
        h6.join();

        System.out.println("Total de descargas: "+gestorDescargas.getDescargasCompletadas());
    }
}

class GestorDescargas {
    private int descargasCompletadas = 0;

    public synchronized void registrarDescarga(String nombreArchivo){
        descargasCompletadas++;
        System.out.println(nombreArchivo+" descargado. Total: "+descargasCompletadas);
    }

    public int getDescargasCompletadas() {
        return descargasCompletadas;
    }
}

class Descargador implements Runnable{
    String nombre;
    GestorDescargas ref;
    String archivo;

    public Descargador(String nombre, GestorDescargas ref, String archivo) {
        this.nombre = nombre;
        this.ref = ref;
        this.archivo = archivo;
    }

    @Override
    public void run() {
        try {

            Thread.sleep(new Random().nextInt(500, 1501));
            ref.registrarDescarga("["+nombre+"] "+archivo);

        } catch (InterruptedException e) {
            System.out.println("La descarga del archivo \""+archivo+"\" ha sido cancelada");
        }
    }
}