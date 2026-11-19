package Estudio.repasoejs;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ej2rep {

    static void main(String[] args) {

        Instant instant = Instant.now();

        Thread hiloSec = new Thread(new hiloSecundario());
        int cont = 0;

        hiloSec.start();

        try {

            while (hiloSec.isAlive()) {

                System.out.println("MAIN: Hilo principal esperando...");
                Thread.sleep(1000);

                if (++cont == Integer.parseInt(args[0])) {

                    hiloSec.interrupt();
                    hiloSec.join();

                    // Sacar los segundos de ejecución
                    System.out.println("Segundos de ejecución: " + Duration.between(instant, Instant.now()).toSeconds());

                }

            }

        } catch (InterruptedException e) {

            System.out.println("MAIN: Hilo main interrumpido!");

        }

    }

}

class hiloSecundario implements Runnable {

    List<String> lista = new ArrayList<>(List.of("[Inicio del Prorama]","[Procesos]","[Servicios]","[Multihilo]","[Sync]","[FIN]"));
    int cont = 0;

    @Override
    public void run() {

        try {

            for (String s: lista) {

                System.out.println("Hilo SEC: " + s);
                cont++;
                Thread.sleep(3000);

            }

        } catch (InterruptedException e) {

            System.out.println("Hilo Secundario Interrumpido!");

            for (String s: lista.subList(cont, lista.size())) {

                System.out.println("Hilo SEC: " + s);

            }

        }

    }
}
