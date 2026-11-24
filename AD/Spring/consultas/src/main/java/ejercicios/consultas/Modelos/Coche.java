package ejercicios.consultas.Modelos;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Coche {
    @Id
    String matricula;

    @Column(unique = true, nullable = false)
    String marca;

    @Column(unique = true, nullable = false)
    String modelo;

    @Column(nullable = false)
    String color;

    Double precio;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    Cliente cliente_id;

    @OneToMany(mappedBy = "coche_id")
    @Builder.Default
    List<Revision> revisiones = new ArrayList<>();

}
