package Ejs4.ej3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ej3 {
    static void main() throws InterruptedException {
        Cuenta cuenta = new Cuenta(1000);

        Thread h1 = new Thread(new Hilo1(cuenta));
        Thread h2 = new Thread(new Hilo2(cuenta));
        Thread h3 = new Thread(new Hilo3(cuenta));
        Thread h4 = new Thread(new Hilo4(cuenta));
        Thread h5 = new Thread(new Hilo5(cuenta));

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();

        h1.join();
        h2.join();
        h3.join();
        h4.join();
        h5.join();

        System.out.println("Saldo final: "+ cuenta.getSaldo());
    }
}

class Cuenta {
    private double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingresar(double ingreso) throws InterruptedException {
        Thread.sleep(new Random().nextInt(100, 500));
        saldo+=ingreso;
    }

    public void retirar(double retirado) throws InterruptedException {
        Thread.sleep(new Random().nextInt(100, 500));
        saldo-=retirado;
    }
}

class Hilo1 implements Runnable {
    private Cuenta cuenta;

    public Hilo1(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                double cant = 100;
                double saldoAnt = cuenta.getSaldo();
                cuenta.ingresar(cant);
                System.out.println("[Hilo 1] - Ingreso - "+cant+" - Saldo anterior: "+saldoAnt+" - Saldo posterior: "+cuenta.getSaldo());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Hilo2 implements Runnable {
    private Cuenta cuenta;

    public Hilo2(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                double cant = 200;
                double saldoAnt = cuenta.getSaldo();
                cuenta.retirar(cant);
                System.out.println("[Hilo 2] - Gasto - "+cant+" - Saldo anterior: "+saldoAnt+" - Saldo posterior: "+cuenta.getSaldo());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Hilo3 implements Runnable {
    private Cuenta cuenta;

    public Hilo3(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                double cant = 100;
                double saldoAnt = cuenta.getSaldo();
                cuenta.retirar(cant);
                System.out.println("[Hilo 3] - Gasto - "+cant+" - Saldo anterior: "+saldoAnt+" - Saldo posterior: "+cuenta.getSaldo());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Hilo4 implements Runnable {
    private Cuenta cuenta;

    public Hilo4(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                double cant = 200;
                double saldoAnt = cuenta.getSaldo();
                cuenta.ingresar(cant);
                System.out.println("[Hilo 4] - Ingreso - "+cant+" - Saldo anterior: "+saldoAnt+" - Saldo posterior: "+cuenta.getSaldo());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Hilo5 implements Runnable {
    private Cuenta cuenta;

    public Hilo5(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                double cant = 100;
                double saldoAnt = cuenta.getSaldo();
                cuenta.ingresar(cant);
                System.out.println("[Hilo 5] - Ingreso - "+cant+" - Saldo anterior: "+saldoAnt+" - Saldo posterior: "+cuenta.getSaldo());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}