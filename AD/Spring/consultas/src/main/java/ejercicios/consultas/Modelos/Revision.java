package ejercicios.consultas.Modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Revision {
    @Id
    String codigo;

    Boolean cambio_filtro = false;
    Boolean cambio_aceite = false;

    Double coste;

    @ManyToOne(optional = false)
    @JoinColumn(name = "coche_id")
    Coche coche_id;

}
