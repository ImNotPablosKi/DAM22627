package org.iesch.ad.demoCarga.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nombre;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private List<Pedido> pedidos;



}
