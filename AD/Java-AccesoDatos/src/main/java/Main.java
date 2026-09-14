import java.util.*;

public class Main {

    public static void imprimirInteger(Contenedor<? extends  Integer> objeto) {

        System.out.println(objeto.getObjeto());

    }

    static void main() {

        Contenedor<Integer> contenedor1 = new Contenedor<>(33);

        imprimirInteger(contenedor1);

        List<String> miLista = new ArrayList<>();

        miLista.add("Hola");
        miLista.add("Adios");
        miLista.add("Nose");

        List<Coche> miListaCoches = new ArrayList<>();

        Coche coche1 = new Coche("1234ABC", "Nigga6776", "Colega", 135);
        Coche coche2 = new Coche("1684AKl", "OhShitBro67", "Pascual", 90);
        Coche coche3 = new Coche("1116KKK", "GODDAMN", "Hecprooll", 456);

        miListaCoches.addAll(Arrays.asList(coche2,coche1,coche3));

        // Modifica y ordena la lista
        Collections.sort(miListaCoches);

        System.out.println(miListaCoches);


    }


}
