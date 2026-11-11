package org.iesch.PracticaTema1PSP;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MaxNumberTask extends RecursiveTask<Integer> {
    // constantes para el tamaño total del array
// y el límite para la búsqueda iterativa
    final static int TOTAL = 100_000_000;
    final static int THRESHOLD = 10_000_000;
    // declaramos el array de números
    int[] numbers;
    // el valor inicial a evaluar
    int first;
    // el número de resgistros a evaluar;
    int length;

    // constructor
    public MaxNumberTask(int[] numbers, int first, int length) {
        this.numbers = numbers;
        this.first = first;
        this.length = length;
    }

    // obtenemos el máximo de manera iterativa
    private int getMaxIterative() {
        int max = Integer.MIN_VALUE;
// recorremos el número de elementos indicado (length)
// desde el primero (first)
        int high = first + length;
        for (int i = first; i < high; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    // obtenemos el máximo de manera recursiva
    private int getMaxRecursive() {
// dividimos el intervalo y lanzamos una tarea para cada mitad
        int mid = length / 2;
        MaxNumberTask task1 = new MaxNumberTask(numbers, first, mid);
        task1.fork();
        MaxNumberTask task2 =
                new MaxNumberTask(numbers, first + mid, length - mid);
        task2.fork();
// el resultado será el máximo de los valores
// máximos de cada intervalo
        return Math.max(task1.join(), task2.join());
    }

    static int[] generateArray(int size) {
        int[] numbers = new int[size];
// preparamos el objeto Ramdom
        Random r = new Random(System.currentTimeMillis());
// rellenamos con números aleatorios
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt();
        }
        return numbers;
    }

    @Override
    protected Integer compute() {
// si estamos por arriba del umbral
// aplicamos recursividad
// si no recorremos el array y devolvemos el mayor
        Integer max = 0;
        if (length > THRESHOLD) {
            max = getMaxRecursive();
        } else {
            max = getMaxIterative();
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numbers = generateArray(TOTAL);
// Creamos la tarea a realizar
        MaxNumberTask task = new MaxNumberTask(numbers, 0, TOTAL);
// búsqueda secuencial
        long start = System.currentTimeMillis();
        int max = task.getMaxIterative();
        long end = System.currentTimeMillis();
        System.out.println("Max number (" + max
                + ") iterative found in " + (end - start));
// busqueda recursiva en paralelo con fork - join
        ForkJoinPool pool = new ForkJoinPool();
        start = System.currentTimeMillis();
        Integer res = pool.invoke(task);
        end = System.currentTimeMillis();
        System.out.println("Max number (" + res
                + ") recursive parallel found in " + (end - start));

    }
}