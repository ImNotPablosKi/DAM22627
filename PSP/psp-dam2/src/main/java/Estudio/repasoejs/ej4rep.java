package Estudio.repasoejs;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ej4rep {
    static void main() {

        ColaTrabajos colaTrabajos = new ColaTrabajos();

        for (int i = 0; i < 2; i++) {

            new Thread(new HiloProductor(colaTrabajos, "[PRODUCTOR " + i + "]")).start();

        }

        for (int i = 0; i < 2; i++) {

            new Thread(new HiloConsumidor(colaTrabajos, "[CONSUMIDOR " + i + "]")).start();

        }

    }
}

class ColaTrabajos {

    Queue<Integer> cola = new PriorityQueue<>();

    static final int MAX = 5;

    void producir(String nombre, int numero) {

        synchronized (this) {

            try {

                boolean producido = false;

                while (!producido) {

                    if (cola.size() != MAX) {

                        System.out.println(nombre + " va a añadir " + numero);
                        cola.add(numero);
                        producido = true;
                        notifyAll();
                        Thread.sleep(500);

                    } else {

                        System.out.println(nombre + " espera a producir...");
                        wait();

                    }

                }

            } catch (InterruptedException e) {

                System.out.println("Producción Interrumpida");

            }

        }

    }

    void consumir(String nombre) {

        synchronized (this) {

            try {

                boolean consumido = false;

                while (!consumido) {

                    if (!cola.isEmpty()) {

                        System.out.println(nombre + " consume");
                        cola.poll();
                        consumido = true;
                        notifyAll();
                        Thread.sleep(800);

                    } else {

                        System.out.println(nombre + " está en espera para poder acceder...");
                        wait();

                    }

                }

            } catch (InterruptedException e) {

                System.out.println("Consumición interrumpida");

            }

        }

    }

}

class HiloProductor implements Runnable {

    ColaTrabajos cola;
    String nombre;

    public HiloProductor(ColaTrabajos cola, String nombre) {
        this.cola = cola;
        this.nombre = nombre;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            cola.producir(nombre, new Random().nextInt(1, 11));

        }

    }
}


class HiloConsumidor implements Runnable {

    ColaTrabajos cola;
    String nombre;

    public HiloConsumidor(ColaTrabajos cola, String nombre) {
        this.cola = cola;
        this.nombre = nombre;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            cola.consumir(nombre);

        }

    }
}
