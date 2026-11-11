package Estudio.repasoejs;

import java.util.Random;

public class ej3rep {
    static void main() {

        Random random = new Random();
        Cuenta cuenta = new Cuenta(1000);

        for (int i = 0; i < 5; i++) {

            Thread hiloOperador = new Thread(new Operador(cuenta, "Hilo_"+i, random.nextInt(1, 3)));
            hiloOperador.start();

        }

    }
}

class Cuenta {

    private double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public synchronized double getSaldo() {
        return saldo;
    }

    public synchronized void ingresar(int cant) {

        Random rando = new Random();

        try {

            Thread.sleep(rando.nextInt(100, 501));
            this.saldo += cant;


        } catch (InterruptedException e) {

            System.out.println("Interrupción al ingresar dinero!");

        }

    }

    public synchronized void retirar(int cant) {

        Random rando = new Random();

        try {

            Thread.sleep(rando.nextInt(100, 501));
            if (this.saldo < cant) {

                System.out.println("Saldo Insuficiente!");

            } else {

                this.saldo -= cant;

            }

        } catch (InterruptedException e) {

            System.out.println("Interrupción al retirar dinero!");

        }

    }
}

class Operador implements Runnable {

    Cuenta cuenta;
    String nombre;
    int operacion;

    public Operador(Cuenta cuenta, String nombre, int operacion) {
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.operacion = operacion;
    }

    @Override
    public void run() {

        Random random = new Random();
        int cantidad = random.nextInt(10, 901);

        synchronized (cuenta) {

            switch (operacion){

                case 1:

                    System.out.println(nombre + " Ingresando: " + cantidad + " Saldo actual: " + cuenta.getSaldo());
                    cuenta.ingresar(cantidad);
                    System.out.println(nombre + " finalizado, nuevo saldo: " + cuenta.getSaldo());
                    break;

                case 2:

                    System.out.println(nombre + " Retirando: " + cantidad + " Saldo actual: " + cuenta.getSaldo());
                    cuenta.retirar(cantidad);
                    System.out.println("Nuevo Saldo: " + cuenta.getSaldo());
                    break;

                default:
                    System.out.println("xd");
                    break;
            }

        }

    }
}