package ejercicios4;

public class ej1 {
    static void main() {

        HiloHola hiloHola = new HiloHola();
        HiloDAM hiloDAM = new HiloDAM();

        try {

            hiloHola.start();
            Thread.sleep(50);
            hiloDAM.start();

            Thread.sleep(5000);

            hiloHola.interrupt();
            hiloDAM.interrupt();

            hiloHola.join();
            hiloDAM.join();

        } catch (InterruptedException e) {

            System.out.println("hilo principal explota");

        }

        System.out.println("Programa principal finalizado");

    }

    static class HiloHola extends Thread {

        @Override
        public void run() {


            try {

                for (int i = 0; i < 10; i++) {

                    System.out.println("Hilo-Hola: Hola");
                    Thread.sleep(1000);

                }

            } catch (InterruptedException e) {

                System.out.println("hilo hola explota");


            }

        }
    }

    static class HiloDAM extends Thread {

        @Override
        public void run() {

            try {

                for (int i = 0; i < 10; i++) {

                    System.out.println("Hilo-DAM: DAM");
                    Thread.sleep(1000);

                }

            } catch (InterruptedException e) {

                System.out.println("Hilo DAM explota");

            }

        }
    }
}
