package Estudio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorBasico {
    static void main() {

        List<TareaSumar> listaSumas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            listaSumas.add(new TareaSumar(Arrays.asList(random.nextInt(0, 11),random.nextInt(0, 11),random.nextInt(0, 11))));
        }

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultados;

        try {
            resultados = executor.invokeAll(listaSumas);
            executor.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        resultados.forEach(a -> {
            try {
                System.out.println(a.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

class TareaSumar implements Callable<Integer> {
    List<Integer> numeros;

    public TareaSumar(List<Integer> numeros) {
        this.numeros = numeros;
    }

    @Override
    public Integer call() throws Exception {
        return numeros.stream().reduce((a, b)->a+b).get();
    }
}