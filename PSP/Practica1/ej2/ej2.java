package Practica1.ej2;



import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ej2 {
    static void main() throws InterruptedException {
        ColaTareas tareas = new ColaTareas();

        Thread h1 = new Thread(new Productor(tareas,"Productor" ));
        Thread h2 = new Thread(new Consumidor(tareas,"Consumidor - 1" ));
        Thread h3 = new Thread(new Consumidor(tareas,"Consumidor - 2"));

        h1.start();
        h2.start();
        h3.start();

        h1.join();
        h2.join();
        h3.join();
    }
}

class ColaTareas {
    Integer cont = 0;

    Queue<Integer> cola = new ArrayBlockingQueue<>(3);

    public Integer getCont() {
        return cont;
    }

    public synchronized void producir(Integer num, String nombre) throws InterruptedException {
        boolean terminado = true;
        while (terminado && cont<10) {
            if (!cola.offer(num)) {
                System.out.println("[" + nombre + "] - En espera");
                wait();
            } else {
                System.out.println("[" + nombre + "] - Ha producido: " + num);
                notifyAll();
                terminado = false;
            }
            //Thread.sleep(500);
        }
    }

    public synchronized void consumir(String nombre) throws InterruptedException {
        boolean terminado = true;
        while (terminado && cont<10) {
            Integer num = cola.poll();
            if (num == null){
                System.out.println("[" + nombre + "] - En espera");
                wait();
            } else {
                System.out.println("["+nombre+"] - Ha consumido: "+num);
                notifyAll();
                terminado = false;
                cont++;
            }
            //Thread.sleep(800);
        }
    }
}

class Productor implements Runnable {
    private ColaTareas cola;
    private String nombre;

    public Productor(ColaTareas cola, String nombre) {
        this.cola = cola;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(500);
                cola.producir(i, nombre);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Consumidor implements Runnable {
    private ColaTareas cola;
    private String nombre;

    public Consumidor(ColaTareas cola, String nombre) {
        this.cola = cola;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            while (cola.getCont()<10) {
                Thread.sleep(800);
                cola.consumir(nombre);
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}