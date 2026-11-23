package com.example.EjerciciosConsultas.servicio;

import com.example.EjerciciosConsultas.modelo.Cliente;
import com.example.EjerciciosConsultas.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultasServicio {

    private final ClienteRepositorio clienteRepository;

    public List<Cliente> clientesPorColor(String color) {

        return clienteRepository.findDistinctByCochesColorIgnoreCase(color);

    }

    public List<Cliente> clientesPorPrecioMayorQue(int precio) {

        return clienteRepository.findDistinctByCochesPrecioGreaterThan(precio);

    }
}
