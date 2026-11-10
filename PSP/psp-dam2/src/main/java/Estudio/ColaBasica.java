package Estudio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ColaBasica {
    static void main() {
        Cola cola = new Cola();
        for (int i = 0; i < 3; i++) {
            Thread h = new Thread(new HiloCreador("[ Creador "+i+" ]", cola));
            if (i==2) h.setPriority(8);
            h.start();
        }

        for (int i = 0; i < 1; i++) {
            Thread h = new Thread(new HiloConsumidor("[ Consumidor "+i+" ]", cola));
            h.start();
        }
    }
}

class Cola {
    final Integer TAMANO = 3;
    Queue<String> cola = new ArrayBlockingQueue<>(TAMANO);

    public synchronized void crear(String nombre, String elemento) throws InterruptedException {

        while (true) {
            if (cola.size() == TAMANO) {
                System.out.println("<==============> " + nombre + " BLOQUEADO <============================================>"+grafico());
                wait();
            } else {
                cola.offer(elemento);

                System.out.println("++++++++++++++++ " + nombre + " - Ha añadido - " + elemento + " +++++++++++++++++++++"+grafico());

                notifyAll();
                break;
            }
        }
    }

    public synchronized void consumir(String nombre) throws InterruptedException {
        while (true) {
            if (cola.isEmpty()) {
                System.out.println("<==============> " + nombre + " BLOQUEADO <============================================>"+grafico());
                wait();
            } else {
                String elemento = cola.poll();

                System.out.println("---------------- " + nombre + " - Ha eliminado - " + elemento + " ----------------"+grafico());

                notifyAll();
                break;
            }
        }
    }

    String grafico(){
        StringBuilder cad = new StringBuilder("[");

        for (int i = 0; i < TAMANO; i++) {
            if (i<cola.size()){
                cad.append("O");
            }else {
                cad.append("X");
            }
        }
        return cad.append("]").toString();
    }
}

class HiloCreador implements Runnable {
    String nombre;
    Cola cola;

    public HiloCreador(String nombre, Cola cola) {
        this.nombre = nombre;
        this.cola = cola;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(2000);
                cola.crear(nombre,nombre+" - ("+i+")");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(nombre+" <TERMINADO> ");
    }
}

class HiloConsumidor implements Runnable {
    String nombre;
    Cola cola;

    public HiloConsumidor(String nombre, Cola cola) {
        this.nombre = nombre;
        this.cola = cola;
    }

    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(1000);
                cola.consumir(nombre);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}