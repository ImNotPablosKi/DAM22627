package org.iesch.ad.demoSpring1.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
public class Persona {


    @Id // Para indicar la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para que sea autoincremental
    Long id;

    String nombre;
    String apellidos;

    @Column(length = 9)
    String dni;
    String email;
    private LocalDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coche_id", referencedColumnName = "id")
    Coche coche;

    @PrePersist
    public void preGuardar() {

        this.createdAt = LocalDateTime.now();

    }

    @PostPersist
    public void postGuardado() {

        System.out.println("Se guarda la persona con ID: " + this.id);

    }

}
