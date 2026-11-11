package Estudio.ejs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;


public class ej4_4 {
    static void main() {
        ColaNums colaNums = new ColaNums();

        for (int i = 0; i < 4; i++) {
            new Thread(new HProductor(colaNums, "[Productor"+i+"]")).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(new HConsumidor(colaNums, "[Consumidor"+i+"]")).start();
        }
    }
}

class ColaNums {
    Integer tamano = 5;
    Queue<Integer> cola = new ArrayDeque<>(tamano);

    public void producir(String nombre, Integer num){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (this){
            boolean anadido =  true;
            while (anadido) {
                if (cola.size() != tamano) {
                    System.out.println(nombre + " - Añade: " + num);
                    cola.add(num);
                    anadido=false;
                    notifyAll();
                } else {
                    System.out.println(nombre + " - Espera");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void consumir(String nombre){
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (this){
            boolean consumido =  true;
            while (consumido) {
                if (!cola.isEmpty()) {
                    System.out.println(nombre + " - Consume: " + cola.poll());
                    consumido=false;
                    notifyAll();
                } else {
                    try {
                        System.out.println(nombre + " - Espera");
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

class HConsumidor implements Runnable{
    ColaNums colaNums;
    String nombre;

    public HConsumidor(ColaNums colaNums, String nombre) {
        this.colaNums = colaNums;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            colaNums.consumir(nombre);
        }
    }
}

class HProductor implements Runnable{
    ColaNums colaNums;
    String nombre;

    public HProductor(ColaNums colaNums, String nombre) {
        this.colaNums = colaNums;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            colaNums.producir(nombre, new Random().nextInt(1, 11));
        }
    }
}