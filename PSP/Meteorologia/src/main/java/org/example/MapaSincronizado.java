package org.example;

import java.util.*;

public class MapaSincronizado {
    // Aquí se agruparan los registros por su més <Mes, Registros>, TreeMap ordena por laclave
    Map<String, ArrayList<Registro>> registros = new TreeMap<>();
    Integer contAnadidos = 0;

    public synchronized void anadirRegistro(Registro r){
        if (registros.get(r.getMesYAno())==null){
            registros.put(r.getMesYAno(), new ArrayList<>(List.of(r)));
        } else {
            registros.get(r.getMesYAno()).add(r);
        }
        contAnadidos++;
        //System.out.println(contAnadidos);
    }

    public Map<String, ArrayList<Registro>> getRegistros() {
        return registros;
    }

    public void setRegistros(Map<String, ArrayList<Registro>> registros) {
        this.registros = registros;
    }

    public Integer getContAnadidos() {
        return contAnadidos;
    }

    public void setContAnadidos(Integer contAnadidos) {
        this.contAnadidos = contAnadidos;
    }
}
