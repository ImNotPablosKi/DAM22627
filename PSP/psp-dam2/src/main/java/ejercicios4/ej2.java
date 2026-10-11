package ejercicios4;

import java.util.List;

public class ej2 {
    static void main(String[] args) {

        Thread hiloMensajes = new Thread(new HiloMensajes());
        hiloMensajes.start();

        int cont = 0;

        try {

            while (hiloMensajes.isAlive()) {

                System.out.println("Hilo Principal esperando...");
                Thread.sleep(1000);
                cont++;

                if (cont >= Integer.parseInt(args[0])) {

                    hiloMensajes.interrupt();
                    break;

                };

            }

        } catch (InterruptedException e) {

            System.out.println("[main] Hilo principal eplota");

        }

        System.out.println("Tiempo de ejecución total: Aproximadamente " + cont + " segundos.");
    }

    static class HiloMensajes implements Runnable {

        @Override
        public void run() {

            List<String> lista = List.of("Procesos", "Servicios", "Multihilo", "Sincronización", "Fin del Programa");
            int cont = 0;

            try {

                for (String s: lista) {

                    System.out.println( "[hilo]" + s );
                    Thread.sleep(3000);
                    cont++;

                }

            } catch (InterruptedException e) {

                for (String s: lista.subList(cont, lista.size())) {

                    System.out.println("[hilo]" + s);

                }

                System.out.println("hilo de mensajes explota");

            }

        }
    }
}
