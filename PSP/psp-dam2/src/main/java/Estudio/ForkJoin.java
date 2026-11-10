package Estudio;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin {
    static void main() {
        TareaDividirCont tarea = new TareaDividirCont(27);

        ForkJoinPool pool = new ForkJoinPool();
        String res = pool.invoke(tarea);

        System.out.println(res);
    }
}

class TareaDividirCont extends RecursiveTask<String> {
    int valor;
    int cont;

    public TareaDividirCont(int valor, int cont) {
        this.valor = valor;
        this.cont = cont;
    }

    public TareaDividirCont(int valor) {
        this.valor = valor;
        this.cont = 0;
    }

    @Override
    protected String compute() {
        if (valor>1){
            System.out.println(valor+"-"+cont);
            TareaDividirCont tarea1 = new TareaDividirCont(valor/2, cont+1);
            TareaDividirCont tarea2 = new TareaDividirCont(valor/2, cont+1);

            tarea1.fork();
            tarea2.fork();

            return "["+tarea1.join()+"-"+tarea2.join()+"]";
        } else {
            System.out.println(valor+"-"+cont);
            return String.valueOf(cont);
        }
    }
}