package Ejs4.ej1;

public class ej1{
    static void main() throws InterruptedException {
        Thread h1 = new Thread(new Hilo1());
        Thread h2 = new Thread(new Hilo2());

        h1.start();

        Thread.sleep(50);

        h2.start();

        Thread.sleep(5000);

        h1.interrupt();
        h2.interrupt();

        h1.join();
        h2.join();

        System.out.println("Programa finalizado");
    }
}

class Hilo1 implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hilo-Hola: Hola");
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Hilo-Hola: Finalizado");
        }
    }
}

class Hilo2 implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hilo-DAM: DAM");
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Hilo-Hola: Finalizado");
        }
    }
}