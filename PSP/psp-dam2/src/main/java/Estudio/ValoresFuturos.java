package Estudio;

import java.util.*;
import java.util.concurrent.*;

public class ValoresFuturos {
    static void main() {
        int cant = 10;

        int posObjetivo = new Random().nextInt(0, cant);

        ArrayList<Datos> tareas = new ArrayList<>();

        for (int i = 0; i < cant; i++) {
            ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(
                    new Random().nextInt(0, 10),
                    new Random().nextInt(0, 10),
                    new Random().nextInt(0, 10),
                    new Random().nextInt(0, 10),
                    new Random().nextInt(0, 10),
                    new Random().nextInt(0, 10)
            ));

            if (i == posObjetivo) numeros.add(10);

            tareas.add(new Datos(numeros));
        }

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        List<Future<Integer>> futuros = new ArrayList<>();
        try {
            futuros = threadPoolExecutor.invokeAll(tareas);

            threadPoolExecutor.shutdown();
            if(threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS)){
                System.out.println("Se han procesado los datos a tiempo");
            }else {
                System.out.println("No se han procesado los datos a tiempo");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < futuros.size(); i++) {
            try {
                if(futuros.get(i).get()==10) System.out.println("El número 10 estaba en la taréa "+(i+1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < futuros.size(); i++) {
            try {
                System.out.println((i+1)+"-"+futuros.get(i).get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Datos implements Callable<Integer> {
    ArrayList<Integer> lista;

    public Datos(ArrayList<Integer> lista) {
        this.lista = lista;
    }

    @Override
    public Integer call(){
        return lista.stream().max(Comparator.comparing(Integer::intValue)).get();
    }
}