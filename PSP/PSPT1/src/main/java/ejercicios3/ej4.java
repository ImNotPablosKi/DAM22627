package ejercicios3;

import java.util.ArrayList;
import java.util.List;

public class ej4 {

    static void main() {

        HiloMensajes hiloMensajes = new HiloMensajes();
        int cont = 0;

        hiloMensajes.start();

        while (hiloMensajes.isAlive()) {

            try {

                Thread.sleep(1000);
                cont++;
                System.out.println("Esperando a q el hilo de mensajes termine (Segundo: " + cont + ")");

            } catch (InterruptedException e) {

                System.out.println("hilo main interrumpido");

            }

        }

        System.out.println("Han terminado todos los hilos");

    }

    static class HiloMensajes extends Thread {

        @Override
        public void run() {

            List<String> lista = new ArrayList<>(List.of("Programas", "Procesos", "Servicios", "Hilos"));

            try {

                for (String p: lista) {

                    System.out.println(p);
                    Thread.sleep(4000);

                }

            } catch (InterruptedException e) {

                System.out.println("xd");

            }

        }
    }

}
