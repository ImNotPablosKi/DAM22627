package Pruebas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class EjemploThreadPool {

    // Callable<Integer>: como Runnable, pero call() DEVUELVE un resultado
    static class Multiplication implements Callable<Integer> {
        private final int id;
        private final int a;
        private final int b;

        Multiplication(int id, int a, int b) {
            this.id = id;
            this.a = a;
            this.b = b;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println("[" + Thread.currentThread().getName() + "] Tarea " + id
                    + " -> calculando " + a + " x " + b);
            Thread.sleep(1000);          // simula trabajo para ver cómo se reparten las tareas
            return a * b;
        }

        @Override
        public String toString() {
            return a + " x " + b;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Pool con un máximo de 3 hilos: si hay más tareas, esperan en cola
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        Random random = new Random();

        // Lista de 10 multiplicaciones al azar
        List<Multiplication> tareas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            tareas.add(new Multiplication(i, random.nextInt(1, 101), random.nextInt(1, 101)));
        }

        try {
            // invokeAll BLOQUEA hasta que terminan las 10 tareas.
            // Devuelve una lista de Future en el MISMO orden que la lista de tareas.
            List<Future<Integer>> resultados = executor.invokeAll(tareas);

            System.out.println("\n===== RESULTADOS =====");
            for (int i = 0; i < resultados.size(); i++) {
                // get() devuelve el valor (ya está calculado, no espera más)
                System.out.println("Tarea " + (i + 1) + ": " + tareas.get(i)
                        + " = " + resultados.get(i).get());
            }

            System.out.println("\nTareas completadas por el pool: " + executor.getCompletedTaskCount());
            System.out.println("Hilos máximos del pool: " + executor.getPoolSize());
        } catch (ExecutionException e) {
            // Si call() lanzó una excepción, get() la envuelve en ExecutionException
            System.out.println("Una tarea falló: " + e.getCause());
        } finally {
            executor.shutdown();             // sin esto el programa no termina
        }
    }
}