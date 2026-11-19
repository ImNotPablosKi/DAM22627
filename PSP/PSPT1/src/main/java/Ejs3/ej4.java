package Ejs3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ej4 {
    static void main() {
        Thread hilo = new Thread(new hilo());

        hilo.start();

        for (int i = 0; i < 16; i++) {
            System.out.println("Hilo main: Total esperado: "+i+"s");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        hilo.interrupt();
    }
}

class hilo implements Runnable{
    @Override
    public void run() {
        int i = 0;
        List<String> palabras = new ArrayList<>(Arrays.asList("Programas", "Procesos", "Servicios", "Hilos", "Pascualas", "Luis", "Carlos Casado"));
        try {
            for (i = 0; i < palabras.toArray().length; i++) {
                Thread.sleep(4000);
                System.out.println("Hilo secundario: "+palabras.get(i));
            }
        }catch (InterruptedException e){
            System.out.println("Hilo secundario: Parado!!!");
            for (; i < palabras.toArray().length; i++) {
                System.out.println("Hilo secundario: "+palabras.get(i));
            }
        }
    }
}