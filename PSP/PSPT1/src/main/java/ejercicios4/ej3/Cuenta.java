package ejercicios4.ej3;

import java.util.Random;

class ej3 {

    static Random random = new Random();

    static Cuenta cuenta = new Cuenta(6767);

    static void main(String[] args) {

        Thread hilo1 = new Thread(new hilo1());
        Thread hilo2 = new Thread(new hilo2());
        Thread hilo3 = new Thread(new hilo3());
        Thread hilo4 = new Thread(new hilo4());
        Thread hilo5 = new Thread(new hilo5());

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();

        try {

            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
            hilo5.join();

        } catch (InterruptedException e) {

            System.out.println("Hilo principal interrupido");

        }

    }
}

public class Cuenta {

    Object object = new Object();

    private double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {

        synchronized (object) {

            return saldo;

        }

    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                '}';
    }

    public void ingresarSaldo(double cantidad) {

        Random random = new Random();

        synchronized (object) {

            try {

                // Mostrar el nombre del hilo actual o el que ha llamado al método
                System.out.println(Thread.currentThread().getName());
                System.out.println("OPERACIÓN: INGRESO");
                System.out.println("CANTIDAD: " + cantidad);
                System.out.println("SALDO ACTUAL: " + this.saldo);
                Thread.sleep(random.nextInt(100, 500));
                this.saldo += cantidad;
                System.out.println("NUEVO SALDO: " + this.saldo);

            } catch (InterruptedException e) {

                System.out.println("Interrupcion al ingresar saldo");

            }

        }

    }

    public void retirarSaldo(double cantidad) {

        synchronized (object) {

            if (cantidad > this.saldo) {

                System.out.println("Saldo insuficiente");

            } else {

                try {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("OPERACIÓN: RETIRADA");
                    System.out.println("CANTIDAD: " + cantidad);
                    System.out.println("SALDO ACTUAL: " + this.saldo);
                    Random random = new Random();
                    Thread.sleep(random.nextInt(100, 500));
                    this.saldo -= cantidad;
                    System.out.println("NUEVO SALDO: " + this.saldo);

                } catch (InterruptedException e) {

                    System.out.println("Interrupción al retirar saldo");

                }

            }

        }

    }
}

class hilo1 implements Runnable {

    @Override
    public void run() {

        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.retirarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.retirarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));

    }
}

class hilo2 implements Runnable {

    @Override
    public void run() {

        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.retirarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.retirarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));

    }
}

class hilo3 implements Runnable {

    @Override
    public void run() {

        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.retirarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.retirarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));

    }
}

class hilo4 implements Runnable {

    @Override
    public void run() {

        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.retirarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.retirarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));

    }
}

class hilo5 implements Runnable {

    @Override
    public void run() {

        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.retirarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.retirarSaldo(ej3.random.nextInt(0, 1000));
        ej3.cuenta.ingresarSaldo(ej3.random.nextInt(0, 1000));

    }
}