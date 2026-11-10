package Estudio;

import java.util.concurrent.locks.ReentrantLock;

public class LockBasico {
    static void main() throws InterruptedException {
        Contador contador = new Contador();
        for (int i = 0; i < 10; i++) {
            new Thread(new HiloCont("Hilo "+i,contador)).start();
        }

    }
}

class Contador {
    Integer contador = 0;

    ReentrantLock lock = new ReentrantLock();

    public void sumar(String nom) throws InterruptedException {
        lock.lock();
        System.out.println("["+nom+"] - Sumando 1...");
        Thread.sleep(1000);
        System.out.println("["+nom+"] - Ha sumado 1 - "+(++contador));
        lock.unlock();
    }
}

class HiloCont implements Runnable {
    String nombre;
    Contador contador;

    public HiloCont(String nombre, Contador contador) {
        this.nombre = nombre;
        this.contador = contador;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                contador.sumar(nombre);

                // Para evitar que un hilo acapare el metodo Tod0 el rato
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}