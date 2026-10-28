package org.iesch.ad.demoSpring1.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nombre;
    LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "order_id") // Bidireccionalidad
    Cliente cliente;

}
