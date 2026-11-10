package Ejs3;

public class ej3 {
    static void main() {
        Thread hiloUno = new Thread(new hilo1());
        Thread hiloDos = new Thread(new hilo2());

        hiloUno.start();
        hiloDos.start();

        try {
            Thread.sleep(5000);
            hiloUno.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class hilo2 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 15; i++) {
            System.out.println("mundo!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class hilo1 implements Runnable{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 15; i++) {
                System.out.println("Hola");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e){
            return;
        }

    }
}

