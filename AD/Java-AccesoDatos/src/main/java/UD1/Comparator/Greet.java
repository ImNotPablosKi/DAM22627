package UD1.Comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Greet {

    interface Greeting {
        void sayHello(String name);
    }

    static void main() {

        Greeting greeting = (name) -> System.out.println("Hello, " + name);
        greeting.sayHello("Alice");

        ordena();
    }

    public static void ordena() {

        List<String> list= Arrays.asList("Dog", "Elephant", "Cat", "Rabbit", "Butterfly");

        // Collections.sort() ordena alfabéticamente por defecto
        // Podemos personalizar el tipo de ordenación
        // Coje el objeto actual s1 y lo compara con el siguiente s2
        Collections.sort(list, (s1,s2) -> s1.length() - s2.length());

        System.out.println("Ordenado por longitud:");
        System.out.println(list);

    }

    // Otra manera
    class StringLengthComparator implements Comparator<String> {

        public int compare (String s1, String s2) {

            return s1.length() - s2.length();

        }

    }

}
