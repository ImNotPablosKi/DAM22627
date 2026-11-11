package Estudio.repasoejs;

public class ej1rep {
    static void main() {

        Thread hiloHola = new Thread(new hiloTexto("HOLA", "HILOHOLA"));
        Thread hiloDam = new Thread(new hiloTexto("DAM", "HILODAM"));

        try {

            hiloHola.start();
            Thread.sleep(50);

            hiloDam.start();

//            hiloHola.join();
//            hiloDam.join();

            Thread.sleep(5000);
            hiloHola.interrupt();
            hiloDam.interrupt();

        } catch (InterruptedException e) {

            System.out.println("Hilo main interrumpido");

        }

    }
}

class hiloTexto implements Runnable {

    private String texto;
    private String nombre;

    public hiloTexto(String texto, String nombre) {
        this.texto = texto;
        this.nombre = nombre;
    }

    @Override
    public void run() {

        try {

            for (int i = 0; i < 10; i++) {

                System.out.println("[" + nombre + "]: " + texto);
                Thread.sleep(1000);

            }

        } catch (InterruptedException e) {

            System.out.println("Hilo " + nombre + " interrumpido!");

        }

    }
}
