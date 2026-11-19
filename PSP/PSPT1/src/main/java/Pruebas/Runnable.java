package Pruebas;

public class Runnable implements java.lang.Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hola");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){
                System.out.println("Interrumpido");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable());
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }
}
