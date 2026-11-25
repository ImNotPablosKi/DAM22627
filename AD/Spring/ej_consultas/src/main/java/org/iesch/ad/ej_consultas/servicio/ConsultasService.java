package org.iesch.ad.ej_consultas.servicio;


import org.iesch.ad.ej_consultas.dto.ClienteDatos;
import org.iesch.ad.ej_consultas.dto.ClienteResumen;
import org.iesch.ad.ej_consultas.dto.CocheRevisiones;
import org.iesch.ad.ej_consultas.modelo.Cliente;
import org.iesch.ad.ej_consultas.modelo.Coche;
import org.iesch.ad.ej_consultas.repositorio.ClienteRepository;
import org.iesch.ad.ej_consultas.repositorio.CocheRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConsultasService {
    private final ClienteRepository clientes;
    private final CocheRepository coches;

    public ConsultasService(ClienteRepository clientes, CocheRepository coches) {
        this.clientes = clientes;
        this.coches = coches;
    }

    public List<Cliente> clientesPorColor(String color) {
        return clientes.findDistinctByCochesColorIgnoreCase(color);
    }

    public List<Cliente> clientesPorPrecioMayorQue(BigDecimal precio) {
        return clientes.findDistinctByCochesPrecioGreaterThan(precio);
    }

    public List<ClienteDatos> clientesConMasCoches() {
        return clientes.buscarClientesConMasCoches();
    }

    public List<Coche> cochesConMenosRevisiones() {
        return coches.buscarCochesConMenosRevisiones();
    }

    public List<CocheRevisiones> revisionesPorCoche() {
        return coches.contarRevisionesPorCoche();
    }

    public Optional<Cliente> clientePorMatricula(String matricula) {
        return clientes.findByCochesMatricula(matricula);
    }

    public Optional<Cliente> clientePorCodigoRevision(String codigo) {
        return clientes.findByCochesRevisionesCodigo(codigo);
    }

    public Optional<ClienteResumen> resumenPorCodigoRevision(String codigo) {
        return clientes.buscarResumenPorCodigoRevision(codigo);
    }
}
