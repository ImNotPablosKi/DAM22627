package UD1.Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void calculaCuadrados() {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> cuadradosPares = numbers.stream()
                .filter(n -> n%2 == 0)
                    .map(n -> n*n).toList();

        cuadradosPares.forEach(System.out::println);

        Collections.sort(cuadradosPares, (n1, n2) -> n1 - n2);
    }

}
