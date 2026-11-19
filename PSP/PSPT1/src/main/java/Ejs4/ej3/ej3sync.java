package Ejs4.ej3;

import java.util.Random;

public class ej3sync {
    static void main() throws InterruptedException {
        Cuenta2 cuenta = new Cuenta2(1000);

        Thread h1 = new Thread(new Hilo12(cuenta));
        Thread h2 = new Thread(new Hilo22(cuenta));
        Thread h3 = new Thread(new Hilo32(cuenta));
        Thread h4 = new Thread(new Hilo42(cuenta));
        Thread h5 = new Thread(new Hilo52(cuenta));

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

class Cuenta2 {
    private double saldo;

    private Object lock1 = new Object();

    public Cuenta2(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        synchronized (lock1){
            return saldo;
        }
    }

    public void ingresar(double ingreso) throws InterruptedException {
        synchronized (lock1) {
            Thread.sleep(new Random().nextInt(100, 500));
            saldo += ingreso;
        }
    }

    public void retirar(double retirado) throws InterruptedException {
        synchronized (lock1) {
            Thread.sleep(new Random().nextInt(100, 500));
            saldo -= retirado;
        }
    }
}

class Hilo12 implements Runnable {
    private Cuenta2 cuenta;

    public Hilo12(Cuenta2 cuenta) {
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

class Hilo22 implements Runnable {
    private Cuenta2 cuenta;

    public Hilo22(Cuenta2 cuenta) {
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

class Hilo32 implements Runnable {
    private Cuenta2 cuenta;

    public Hilo32(Cuenta2 cuenta) {
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

class Hilo42 implements Runnable {
    private Cuenta2 cuenta;

    public Hilo42(Cuenta2 cuenta) {
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

class Hilo52 implements Runnable {
    private Cuenta2 cuenta;

    public Hilo52(Cuenta2 cuenta) {
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