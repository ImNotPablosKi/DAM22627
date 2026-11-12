package Estudio.ejs.CunentaVancariaLock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ej3_4 {
    static void main() {
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        for (int i = 0; i < 5; i++) {
            Thread hilo = new Thread(new HiloOperar("[Hilo"+i+"]", new Random().nextInt(0, 2)==1?-1:1, cuentaBancaria));
            hilo.start();
        }
    }
}

class CuentaBancaria {
    Integer saldo = 500;
    ReentrantLock lock = new ReentrantLock();

    public void operar(Integer cant, String nombre){

        lock.lock();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        System.out.println("<=======================================================================>");
        System.out.println(nombre + " - " + (cant >= 0 ? "Ingresa" : "Retira") + ": " + cant);
        System.out.println("Saldo anterior: " + saldo);
        saldo += cant;
        System.out.println("Saldo posterior: " + saldo);
        System.out.println("<=======================================================================>");

        lock.unlock();

    }

}

class HiloOperar implements Runnable{
    String nombre;
    Integer operacion;

    CuentaBancaria cuentaBancaria;

    public HiloOperar(String nombre, Integer operacion, CuentaBancaria cuentaBancaria) {
        this.nombre = nombre;
        this.operacion = operacion;
        this.cuentaBancaria = cuentaBancaria;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            cuentaBancaria.operar(new Random().nextInt(0, 101)*operacion, nombre);
        }
    }
}