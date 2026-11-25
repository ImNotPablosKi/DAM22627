package org.iesch.ad.ej_consultas.dto;

import java.math.BigDecimal;

public record ClienteResumen(Long id, String nombre, String nif, String direccion, String ciudad,
                             String telefono, Long totalCoches, BigDecimal gastoRevisiones) {
}
