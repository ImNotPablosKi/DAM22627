package Estudio.ejs;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class ej2_4 {
    static void main() {
        Instant inicio = Instant.now();
        Thread h1 = new Thread(new HiloLista());

        h1.start();

        int espera = 4;

        for (int i = 0; i < espera; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Hilo principal en espera...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        h1.interrupt();

        System.out.println(Duration.between(inicio, Instant.now()).toMillis()+"ms");
    }
}

class HiloLista implements Runnable {

    @Override
    public void run() {
        List<String> cosas = Arrays.asList("Inicio del programa", "Procesos", "Servicios", "Multihilo", "Sincronización", "Fin del programa");
        int i = 0;
        try {
            for (; i < cosas.size(); i++) {
                Thread.sleep(1000);
                System.out.println(cosas.get(i));
            }
        } catch (InterruptedException e) {
            for (; i < cosas.size(); i++) {
                System.out.println(cosas.get(i));
            }
        }
    }
}