package Ejs4.ej5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ej5 {
    static void main() throws InterruptedException {
        Clasificacion clasificacion = new Clasificacion();

        Thread h1 = new Thread(new Hilo1("1", clasificacion));
        Thread h2 = new Thread(new Hilo1("2", clasificacion));
        Thread h3 = new Thread(new Hilo1("3", clasificacion));
        Thread h4 = new Thread(new Hilo1("4", clasificacion));
        Thread h5 = new Thread(new Hilo1("5", clasificacion));

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

        clasificacion.finalizar();
    }
}

class Clasificacion {
    Integer pos = 0;
    List<String> lista = new ArrayList<>();

    public synchronized void terminar(String nombre){
        System.out.println("[Corredor-"+nombre+"] HA terminado en posición: "+(++pos));
        lista.add(nombre);
    }

    public void finalizar(){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Corredor - "+lista.get(i)+" ha quedado "+(i+1));
        }
    }
}

class Hilo1 implements Runnable {
    String nombre;
    Clasificacion clasificacion;

    public Hilo1(String nombre, Clasificacion clasificacion) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20;) {
                Thread.sleep(new Random().nextInt(200, 601));
                Integer r = new Random().nextInt(1, 4);
                i+=r;
                System.out.println("[Corredor-"+nombre+"] Ha avanzado "+r+"m | "+i+"/20");
            }
            clasificacion.terminar(nombre);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}