package Estudio.ejs;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ej5_4 {

    List<String> finalizados = new ArrayList<>();

     void main() {
        Instant inicio = Instant.now();

        Integer corredores = 5;
        Integer distancia = 20;

        List<Thread> participantes = new ArrayList<>();

        for (int i = 0; i < corredores; i++) {
            participantes.add(new Thread(new Corredor("[Corredor"+i+"]", distancia, this)));
        }

        participantes.forEach(Thread::start);

        participantes.forEach(a->{
            try {
                a.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        System.out.println("Resultados");
        finalizados.forEach(System.out::println);

        System.out.println(Duration.between(inicio, Instant.now()).toMillis()+"ms");
    }

    public synchronized void terminar(String nombre){
        finalizados.add((finalizados.size()+1)+" - "+nombre);
        System.out.println(nombre+" - Ha finalizado en el puesto: "+finalizados.size());
    }
}

class Corredor implements Runnable{
    String nombre;
    Integer distancia;
    ej5_4 meta;

    public Corredor(String nombre, Integer distancia, ej5_4 meta) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.meta = meta;
    }

    @Override
    public void run() {
        Integer progreso = 0;
        while (progreso<distancia){
            try {
                Thread.sleep(new Random().nextInt(200, 601));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Integer avance = new Random().nextInt(1,4);
            progreso+=avance;
            System.out.println(nombre+" - Avanza: "+avance+"m - Total: <"+"=".repeat(progreso)+"-".repeat(distancia-(progreso>distancia?20:progreso))+"> ("+progreso+"/"+distancia+")");
        }
        meta.terminar(nombre);
    }
}
