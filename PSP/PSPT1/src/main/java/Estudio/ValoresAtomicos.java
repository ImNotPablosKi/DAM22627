package Estudio;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ValoresAtomicos {
    static void main() throws InterruptedException {
        ContadorAtomico contador = new ContadorAtomico();
        for (int i = 0; i < 10; i++) {
            new Thread(new HiloContAtomico("Hilo "+i,contador)).start();
        }

    }
}

class ContadorAtomico {
    AtomicInteger contador = new AtomicInteger(0);

    public void sumar(String nom) throws InterruptedException {

        System.out.println("["+nom+"] - Sumando 1...");
        System.out.println("["+nom+"] - Ha sumado 1 - "+contador.incrementAndGet());

    }
}

class HiloContAtomico implements Runnable {
    String nombre;
    ContadorAtomico contador;

    public HiloContAtomico(String nombre, ContadorAtomico contador) {
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