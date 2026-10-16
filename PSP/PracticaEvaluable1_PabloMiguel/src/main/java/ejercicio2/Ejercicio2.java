package ejercicio2;

import java.util.PriorityQueue;
import java.util.Queue;

public class Ejercicio2 {
}

class ColaTareas {

    private static Queue<Integer> cola = new PriorityQueue<>();
    private final int max = 3;

    public ColaTareas(Queue<Integer> cola) {
        this.cola = cola;
    }

    synchronized void producir(int tarea) {

        while (cola.size() >= 3) {

            try {

                wait();

            } catch (InterruptedException e) {

                System.out.println("Producción interrumpida");

            }

        }

        cola.add(tarea);
        System.out.println("Se ha producido una nueva tarea");
        notifyAll();

    }

    synchronized int consumir() {

        while (cola.size() == 0) {


            try {

                wait();

            } catch (InterruptedException e) {

                System.out.println("Consumición interrumpida");

            }

        }

        System.out.println("Se ha consumido una tarea");
        notifyAll();
        return cola.remove();

    }

}

class Productor implements Runnable {

    static private ColaTareas cola;

    public Productor(ColaTareas cola) {
        this.cola = cola;
    }

    @Override
    public void run() {

        try {

            for (int i = 1; i < 11; i++) {

                cola.producir(i);
                Thread.sleep(500);

            }

        } catch (InterruptedException e) {

            System.out.println("El Productor ha sido interrumpido");

        }

    }
}

class Consumidor implements Runnable {

    static private ColaTareas cola;

    public Consumidor() {
    }

    @Override
    public void run() {

        try {

            int tarea = cola.consumir();
            Thread.sleep(800);

        } catch (InterruptedException e) {

            System.out.println("Consumidor Interrumpido!");

        }

    }
}