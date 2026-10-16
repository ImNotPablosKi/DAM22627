package ejercicio1;

import java.util.Random;

public class Ejercicio1 {
    static void main() {

        GestorDescargas gestorDescargas = new GestorDescargas();

        Thread descargador1 = new Thread(new Descargador("PDF_1.pdf"));
        Thread descargador2 = new Thread(new Descargador("PDF_2.pdf"));
        Thread descargador3 = new Thread(new Descargador("PDF_3.pdf"));
        Thread descargador4 = new Thread(new Descargador("PDF_4.pdf"));
        Thread descargador5 = new Thread(new Descargador("PDF_5.pdf"));
        Thread descargador6 = new Thread(new Descargador("PDF_6.pdf"));


        try {

            descargador1.run();
            descargador2.run();
            descargador3.run();
            descargador4.run();
            descargador5.run();
            descargador6.run();

            descargador1.join();
            descargador2.join();
            descargador3.join();
            descargador4.join();
            descargador5.join();
            descargador6.join();


        } catch (InterruptedException e) {

            System.out.println("Hilo Principal interrumpido!");

        }


    }
}

class GestorDescargas {

    private static int descargasCompletadas;

    static synchronized void registrarDescargas(String nombreArchivo) {

        System.out.println(" [Descargador " + Thread.currentThread() + "]" + nombreArchivo + " descargado. Total: " + descargasCompletadas);

    }

    public int getDescargasCompletadas() {
        return descargasCompletadas;
    }
}

class Descargador implements Runnable {

    private String nombreArchivo;

    public Descargador(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    Random rando = new Random();

    @Override
    public void run() {

        try {

            Thread.sleep(rando.nextInt(500, 1501));
            GestorDescargas.registrarDescargas(nombreArchivo);
            Thread.interrupted();

        } catch (InterruptedException e) {

            System.out.println("La descarga de " + nombreArchivo + " ha sido interrumpida.");

        }

    }
}