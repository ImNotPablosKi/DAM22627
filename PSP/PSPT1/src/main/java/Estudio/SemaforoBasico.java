package Estudio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class SemaforoBasico {
    static void main() {
        ColaSemaforo cola = new ColaSemaforo();
        for (int i = 0; i < 10; i++) {
            Thread h = new Thread(new HiloCreadorSemaforo("[ Creador "+i+" ]", cola));
            h.start();
        }

        for (int i = 0; i < 3; i++) {
            Thread h = new Thread(new HiloConsumidorSemaforo("[ Consumidor "+i+" ]", cola));
            h.start();
        }
    }
}

class ColaSemaforo {
    final Integer TAMANO = 10;
    Queue<String> cola = new ArrayBlockingQueue<>(TAMANO);
    Semaphore semaforoCrear = new Semaphore(3);
    Semaphore semaforoConsumir = new Semaphore(1);

    public void crear(String nombre, String elemento) throws InterruptedException {
        // Aquí le pido pasar si hay hueco
        semaforoCrear.acquire();
        Thread.sleep(3000);
        while (true) {
            if (cola.size() == TAMANO) {
                // Como no uso synchronized no puedo usar wait
                System.out.println("<==============> " + nombre + " BLOQUEADO <============================================>"+grafico());
                Thread.sleep(3000);
                System.out.println("<==============> " + nombre + " DESBLOQUEADO <=========================================>"+grafico());
            } else {
                cola.offer(elemento);

                System.out.println("++++++++++++++++ " + nombre + " - Ha añadido - " + elemento + " +++++++++++++++++++++"+grafico());
                // Lo libero para que otros entren, si no se libera nunca habran más huecos
                semaforoCrear.release();
                break;
            }
        }
    }

    public void consumir(String nombre) throws InterruptedException {
        semaforoConsumir.acquire();
        Thread.sleep(2000);
        while (true) {
            if (cola.isEmpty()) {
                System.out.println("<==============> " + nombre + " BLOQUEADO <============================================>"+grafico());
                Thread.sleep(3000);
                System.out.println("<==============> " + nombre + " DESBLOQUEADO <=========================================>"+grafico());
            } else {
                String elemento = cola.poll();

                System.out.println("---------------- " + nombre + " - Ha eliminado - " + elemento + " ----------------"+grafico());
                semaforoConsumir.release();
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

class HiloCreadorSemaforo implements Runnable {
    String nombre;
    ColaSemaforo cola;

    public HiloCreadorSemaforo(String nombre, ColaSemaforo cola) {
        this.nombre = nombre;
        this.cola = cola;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            try {
                cola.crear(nombre,nombre+" - ("+i+")");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(nombre+" <TERMINADO> ");
    }
}

class HiloConsumidorSemaforo implements Runnable {
    String nombre;
    ColaSemaforo cola;

    public HiloConsumidorSemaforo(String nombre, ColaSemaforo cola) {
        this.nombre = nombre;
        this.cola = cola;
    }

    @Override
    public void run() {

        while (true){
            try {
                // El semaforo no es justo entonces el primero que lo coge se estaría ejecutando hasta que termine si no tiene un delay entre consumición
                // Pero al añadirle delay deja que otro consumidor entre mientras no lo esté usando
                Thread.sleep(100);
                cola.consumir(nombre);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}