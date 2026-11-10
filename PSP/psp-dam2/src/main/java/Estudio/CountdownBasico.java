package Estudio;

import java.util.concurrent.CountDownLatch;

public class CountdownBasico {
    static void main() throws InterruptedException {
        CountDownLatch fase1 = new CountDownLatch(1);
        CountDownLatch fase2 = new CountDownLatch(1);
        CountDownLatch fase3 = new CountDownLatch(2);

        new Thread(new HiloSaludo("[ Saludo 1 - ", fase1, fase2, fase3)).start();
        new Thread(new HiloSaludo("Saludo 2 - ", fase2, fase3, fase3)).start();
        new Thread(new HiloSaludo("Saludo 3 ]", fase3)).start();

        System.out.println("Comenzando saludos");
        Thread.sleep(1000);
        // Al desbloquear la fase 1 el primer hilo se desbloquea
        fase1.countDown();

    }
}

class HiloSaludo implements Runnable {
    String texto;
    CountDownLatch contadorPropio;
    CountDownLatch contadorSiguiente;
    CountDownLatch contadorExtra;

    public HiloSaludo(String texto, CountDownLatch contadorPropio, CountDownLatch contadorSiguiente, CountDownLatch contadorExtra) {
        this.texto = texto;
        this.contadorPropio = contadorPropio;
        this.contadorSiguiente = contadorSiguiente;
        this.contadorExtra = contadorExtra;
    }

    public HiloSaludo(String texto, CountDownLatch contadorPropio, CountDownLatch contadorSiguiente) {
        this.texto = texto;
        this.contadorPropio = contadorPropio;
        this.contadorSiguiente = contadorSiguiente;
    }

    public HiloSaludo(String texto, CountDownLatch contadorPropio) {
        this.texto = texto;
        this.contadorPropio = contadorPropio;
    }

    @Override
    public void run() {
        try {
            contadorPropio.await();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print(texto);
        if (contadorSiguiente!=null){
            contadorSiguiente.countDown();
        }
        if (contadorExtra!=null){
            contadorExtra.countDown();
        }
    }
}
