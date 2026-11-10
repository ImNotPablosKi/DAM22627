package Ejs4.ej2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ej2 {
    static void main(String[] args) throws InterruptedException {
        int cont = 0;

        Thread h1 = new Thread(new Hilo1());

        h1.start();

        while (h1.isAlive()){
            Thread.sleep(1000);
            System.out.println("[main] Hilo principal esperando...");
            if (++cont >= Integer.parseInt(args[0])){
                h1.interrupt();
                break;
            }
        }

        h1.join();

        System.out.println("[main] Hilo principal finalizado  en aproximadamente "+cont+" segundos");
    }
}

class Hilo1 implements Runnable {
    @Override
    public void run() {
        List<String> elementos = new ArrayList<>(Arrays.asList("Inicio del programa","Procesos","Servicios","Multihilo","Sincronización","Fin del programa"));
        Integer cont = 0;
        try {
            for (String elemento: elementos) {
                Thread.sleep(3000);
                System.out.println("[Secundario] "+elemento);
                cont++;
            }
        } catch (InterruptedException e) {
            for (String elemento: elementos.subList(cont, elementos.size())){
                System.out.println("[Secundario] "+elemento);
            }
            System.out.println("[Secundario] Hilo secundario finalizado");
        }
    }
}