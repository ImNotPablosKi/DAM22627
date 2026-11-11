package Estudio.ejs;

public class Ej1_4 {
    static void main() {
        Thread h1 = new Thread(new hiloMostrarTexto("HOLA"));
        Thread h2 = new Thread(new hiloMostrarTexto(" DAM\n"));

        h1.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        h2.start();

//        try {
//            h1.join();
//            h2.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        try {
            Thread.sleep(5000);
            h1.interrupt();
            h2.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final del programa");
    }
}

class hiloMostrarTexto implements Runnable{

    String texto;

    public hiloMostrarTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(texto);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("El hilo que imprime "+texto+" ha sido interrumpido");
                return;
            }
        }
        System.out.println("El hilo que imprime "+texto+" ha finalizado con éxito");
    }
}
