package Ejs4.ej4;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class ej4 {
    static void main() {
        ColaTrabajos cola = new ColaTrabajos();

        Thread h1 = new Thread(new HiloAnadir(cola, "Productor-1"));
        Thread h2 = new Thread(new HiloAnadir(cola, "Productor-2"));
        Thread h3 = new Thread(new HiloAnadir(cola, "Productor-3"));

        Thread he1 = new Thread(new HiloExtraer(cola, "Consumidor-1"));
        Thread he2 = new Thread(new HiloExtraer(cola, "Consumidor-2"));
        Thread he3 = new Thread(new HiloExtraer(cola, "Consumidor-3"));

        h1.start();
        h2.start();

        he1.start();
        he2.start();
    }
}

class ColaTrabajos {
    Queue<Integer> cola = new ArrayBlockingQueue<>(5);;

    public synchronized boolean introducir(Integer num){
        return cola.offer(num);
    }

    public synchronized Integer retirar(){
        try {
            return cola.poll();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}

class HiloAnadir implements Runnable {
    private ColaTrabajos cola;
    private String nombre;

    public HiloAnadir(ColaTrabajos cola, String nombre) {
        this.cola = cola;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Integer num = new Random().nextInt(1, 10);
                while (true) {
                    if (cola.introducir(num)) break;
                    System.out.println("[" + nombre + "] Número " + num + " no introducido XXXXX");
                    Thread.sleep(500);
                }
                System.out.println("[" + nombre + "] Número " + num + " introducido OOOOO");
                Thread.sleep(500);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class HiloExtraer implements Runnable {
    private ColaTrabajos cola;
    private String nombre;

    public HiloExtraer(ColaTrabajos cola, String nombre) {
        this.cola = cola;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Integer num = 0;
                while (true) {
                    num = cola.retirar();
                    if (num != null) break;
                    System.out.println("[" + nombre + "] Número no extraido XXXXX");
                    Thread.sleep(500);
                }
                System.out.println("[" + nombre + "] Número " + num + " extraido OOOOO");
                Thread.sleep(800);
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}