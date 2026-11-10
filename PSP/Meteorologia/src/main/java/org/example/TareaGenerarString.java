package org.example;

import java.util.*;

public class TareaGenerarString implements Runnable {
    List<String> listaMeses;
    Map<String, ArrayList<Registro>> registros;
    String[] resultado;
    Integer pos;

    public TareaGenerarString(List<String> listaMeses, Map<String, ArrayList<Registro>> registros, String[] resultado, Integer pos) {
        this.listaMeses = listaMeses;
        this.registros = registros;
        this.resultado = resultado;
        this.pos = pos;
    }

    @Override
    public void run() {
        StringBuilder cadResultado = new StringBuilder("");
        for(String mes: listaMeses){
            List<Registro> regs = registros.get(mes);

            Registro regTmax = regs.stream().filter(a->a.getTmax()!=null).max(Comparator.comparing(Registro::getTmax)).get();
            Registro regTmin = regs.stream().filter(a->a.getTmin()!=null).min(Comparator.comparing(Registro::getTmin)).get();

            cadResultado.append(
                    "\n<=============== "+mes+" ===============>\n"+
                    "> Registro con temperatura máxima: "+regTmax+
                    "\n> Registro con temperatura mínima: "+regTmin+
                    "\n<============================================>");
        }
        resultado[pos] = cadResultado.toString();
    }
}
