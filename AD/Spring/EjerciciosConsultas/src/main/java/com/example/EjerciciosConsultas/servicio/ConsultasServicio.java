package com.example.EjerciciosConsultas.servicio;

import com.example.EjerciciosConsultas.modelo.Cliente;
import com.example.EjerciciosConsultas.modelo.Coche;
import com.example.EjerciciosConsultas.repositorio.ClienteRepositorio;
import com.example.EjerciciosConsultas.repositorio.CocheRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultasServicio {

    @Autowired
    private ClienteRepositorio clienteRepository;

    @Autowired
    private CocheRepositorio cocheRepository;

    public List<Cliente> clientesPorColor(String color) {

        return clienteRepository.findDistinctByCochesColorIgnoreCase(color);

    }

    public List<Cliente> clientesPorPrecioMayorQue(int precio) {

        return clienteRepository.findDistinctByCochesPrecioGreaterThan(precio);

    }

    public Cliente clienteConMasCoches() {

        return clienteRepository.clienteConMasCoches();

    }

    public Coche cocheConMenosRevisiones() {
        return  cocheRepository.cocheConMenosRevisiones();
    }

    public List<String> cochesJuntoARevisiones() {
        return cocheRepository.cochesJuntoARevisiones();
    }

}
