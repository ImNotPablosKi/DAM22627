package ejercicios3;

public class ej3 {

    static void main() {

        hola hiloHola = new hola();
        mundo hiloMundo = new mundo();

        hiloHola.start();

        try {

            Thread.sleep(20);

        } catch (InterruptedException e) {

            System.out.println("xd");

        }

        hiloMundo.start();

        try {

            Thread.sleep(5000);

        } catch (InterruptedException e) {

            System.out.println("xd");

        }

        System.out.println("Interrumpiendo el primer hilo de Hola");
        hiloHola.interrupt();

    }

    static class hola extends Thread {

        @Override
        public void run() {

            try {

                for (int i = 0; i < 15; i++) {

                    System.out.println("Hola ");
                    Thread.sleep(2000);

                }

            } catch (InterruptedException e) {

                System.out.println("hilo interrumpido");

            }

        }

    }

    static class mundo extends Thread {

        @Override
        public void run() {

            try {

                for (int i = 0; i < 15; i++) {

                    System.out.println(" mundo!");
                    Thread.sleep(2000);

                }

            } catch (InterruptedException e) {

                System.out.println("hilo 2 interrumpido");

            }

        }
    }
}
