package ejercicios.ejercicio2.modelos;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    private String autor;

    @ToString.Exclude
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Categoria")
    private Categoria categoria;



}
