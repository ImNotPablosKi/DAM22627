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
@Builder
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true, nullable = false)
    String nif;

    @Column(unique = true, nullable = false)
    String nombre;

    String direccion;
    String ciudad;
    String telefono;

    @OneToMany(mappedBy = "cliente_id")
    @Builder.Default
    List<Coche> coches = new ArrayList<>();
}
