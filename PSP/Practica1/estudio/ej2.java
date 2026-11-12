package Practica1.estudio;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ej2 {
    static void main() {

        ColaTareas colaTareas = new ColaTareas();

        Thread prod = new Thread(new Productor(colaTareas, "[PRODUCTOR]", 2));

        Thread cons1 = new Thread(new Consumidor(colaTareas, "[CONSUMIDOR-1]"));
        Thread cons2 = new Thread(new Consumidor(colaTareas, "[CONSUMIDOR-2]"));

        try {

            prod.start();

            cons1.start();
            cons2.start();

            prod.join();
            cons1.join();
            cons2.join();

        } catch (InterruptedException e) {

            System.out.println("Main interrumpido!");

        }

    }
}

class ColaTareas {

    private static final int MAX = 3;
    Queue<Integer> cola = new ArrayDeque<>();

    synchronized void producir(String nombre,int tarea) {

        try {

            while (cola.size() == MAX) {

                System.out.println(nombre + "Cola llena, esperando a producir...");
                wait();

            }

            cola.add(tarea);
            System.out.println(nombre + "Numero " + tarea + " añadido");
            notifyAll();

        }  catch (InterruptedException e) {

            System.out.println("Producción interrumpida!");

        }

    }

    synchronized int consumir(String nombre) {

        try {

            while (cola.isEmpty()) {

                System.out.println(nombre + "Cola vacía, esperando a que se llene...");
                wait();

            }

            System.out.println(nombre + "Se ha consumido " + cola.peek());
            notifyAll();
            return cola.poll();

        } catch (InterruptedException e) {

            System.out.println("Interrupción al consumir!");

        }

        return 0;
    }

}

class Productor implements Runnable {

    ColaTareas colaTareas;
    String nombre;

    // Para que el segundo no se quede esperando al final
    int numConsumidores;

    public Productor(ColaTareas colaTareas, String nombre, int numConsumidores) {
        this.colaTareas = colaTareas;
        this.nombre = nombre;
        this.numConsumidores = numConsumidores;
    }

    @Override
    public void run() {

        try {

            for (int i = 1; i < 10; i++) {

                colaTareas.producir(nombre, i);
                Thread.sleep(500);

            }

            // Mando tantos -1 como consumidores haya
            for (int i = 0; i < numConsumidores; i++) {

                colaTareas.producir(nombre, -1);

            }

        } catch (InterruptedException e) {

            System.out.println(nombre + " interrumpido");

        }

    }
}

class Consumidor implements Runnable {

    ColaTareas colaTareas;
    String nombre;

    public Consumidor(ColaTareas colaTareas, String nombre) {
        this.colaTareas = colaTareas;
        this.nombre = nombre;
    }

    @Override
    public void run() {

        boolean fin = false;

        while (!fin) {

            try {

                int num = colaTareas.consumir(nombre);

                if (num == -1) {

                    System.out.println(nombre + "Se ha recibido -1, terminando...");
                    fin = true;

                }

                Thread.sleep(800);

            } catch (InterruptedException e) {

                System.out.println(nombre + "interrupido!");

            }

        }

    }
}
