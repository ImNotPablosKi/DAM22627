package Pruebas;

import java.lang.Runnable;
import java.util.concurrent.atomic.AtomicInteger;

public class Pruebas {
    static void main() {
        Cont count = new Cont();
        for (int i = 0; i < 10; i++) {
            Thread h;
            if (i<5) {
                h = new Thread(new Hilo(count, 1));
            } else {
                h = new Thread(new Hilo(count, -1));
            }
            h.start();
        }
    }
}

class Hilo implements Runnable {

    Cont contador;
    Integer suma;

    public Hilo(Cont contador, Integer suma) {
        this.contador = contador;
        this.suma = suma;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 2; i++) {
                if (suma>0){
                    contador.sumar();
                } else {
                    contador.restar();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Cont {
    Integer cont = 10;
    Object lock1 = new Object();
    Object lock2 = new Object();
    AtomicInteger c = new AtomicInteger(10);

    public void sumar() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(" ++++++++++ SUMANDO ++++++++++ ");
        System.out.println(c.incrementAndGet());
        System.out.println(" ++++++++++ SUMA TERMINADA ++++++++++ ");
    }

    public void restar() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(" ---------- RESTANDO ---------- ");
        System.out.println(c.decrementAndGet());
        System.out.println(" ---------- RESTA TERMINADA ---------- ");
    }


    /*

        public synchronized void sumar() throws InterruptedException {
        Thread.sleep(1000);
        notifyAll();
        System.out.println(" ++++++++++ SUMANDO ++++++++++ ");
        System.out.println(++cont);
        System.out.println(" ++++++++++ SUMA TERMINADA ++++++++++ ");
        wait();
    }

    public synchronized void restar() throws InterruptedException {
        Thread.sleep(1000);
        notifyAll();
        System.out.println(" ---------- RESTANDO ---------- ");
        System.out.println(--cont);
        System.out.println(" ---------- RESTA TERMINADA ---------- ");
        wait();
    }

    public void sumar() throws InterruptedException {
        synchronized (lock1) {
            Thread.sleep(1000);
            System.out.println(" ++++++++++ SUMANDO ++++++++++ ");
            System.out.println(++cont);
            System.out.println(" ++++++++++ SUMA TERMINADA ++++++++++ ");
        }
    }

    public void restar() throws InterruptedException {
        synchronized (lock2) {
            Thread.sleep(1000);
            System.out.println(" ---------- RESTANDO ---------- ");
            System.out.println(--cont);
            System.out.println(" ---------- RESTA TERMINADA ---------- ");
        }
    }
    */
}

