package org.iesch.PracticaTema1PSP.ThreadPool;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Item {

    //  Requeridos
    private String fecha; // (AAAA-MM-DD)
    private String indicativo;
    private String nombre;
    private String provincia;
    private Float altitud; // Metros

    //  No requeridos
    private Float tmed; // Celsius
    private Float prec; // mm
    private Float tmin; // Celsius
    private String horatmin; // Hora y minuto UTC
    private Float tmax; // Celsius
    private String horatmax; // Hora y minuto UTC
    private Float dir; // Dirección de la racha máxima?? decenas de grado
    private Float velmedia; // Velocidad media del viento m/s
    private Float racha; // Racha máxima del viento m/s
    private String horaracha; // Hora y minuto UTC racha máxima
    private Float sol; // Horas insolación
    private Float presmax; // Presión máxima hPA
    private String horapresmax; // Hora redondeada a la más próxima en UTC
    private Float presmin; // Presión mínima hPa
    private String horapresmin; // Hora redondeada a la más próxima en UTC

}