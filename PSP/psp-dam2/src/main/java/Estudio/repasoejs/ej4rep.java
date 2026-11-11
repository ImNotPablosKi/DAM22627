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

    synchronized void producir(String nombre, int numero) {
        try {

            while (cola.size() == MAX) {

                System.out.println(nombre + " espera a producir...");
                wait();

            }

            System.out.println(nombre + " va a añadir " + numero);
            cola.add(numero);
            notifyAll();
            Thread.sleep(500);

        } catch (InterruptedException e) {

            System.out.println("Producción Interrumpida");

        }

    }

    synchronized void consumir(String nombre) {
        try {

            while (cola.isEmpty()) {

                System.out.println(nombre + " está en espera para poder acceder...");
                wait();

            }

            System.out.println(nombre + " consume");
            cola.poll();
            notifyAll();
            Thread.sleep(800);

        } catch (InterruptedException e) {

            System.out.println("Consumición interrumpida");

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
